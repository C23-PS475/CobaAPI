package com.example.cobaapi;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Deklarasi elemen-elemen UI
    private EditText snEdt, usernameEdt, locationEdt, latitudeEdt, longitudeEdt;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;
    private TextView deviceInfoTV;
    private TextView gatewayInfoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen-elemen UI
        snEdt = findViewById(R.id.idEdtsn);
        usernameEdt = findViewById(R.id.idEdtname);
        locationEdt = findViewById(R.id.idEdtlocation);
        latitudeEdt = findViewById(R.id.idEdtlatitude);
        longitudeEdt = findViewById(R.id.idEdtlongitude);
        postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);
        deviceInfoTV = findViewById(R.id.idDeviceInfoTV);
        gatewayInfoTV = findViewById(R.id.idGatewayInfoTV);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validasi apakah semua kolom terisi
//                if (snEdt.getText().toString().isEmpty() ||
//                        usernameEdt.getText().toString().isEmpty() ||
//                        locationEdt.getText().toString().isEmpty() ||
//                        latitudeEdt.getText().toString().isEmpty() ||
//                        longitudeEdt.getText().toString().isEmpty()) {
//
//                    Toast.makeText(MainActivity.this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                // Panggil metode postData dengan nilai-nilai dari kolom
                String sn = "6822120109".toString();
                String username = "nanang".toString();
                String location = "bka".toString();
                String latitude = "6.19".toString();
                String longitude = "106.81".toString();
                postData(sn, username, location, latitude, longitude);
            }
        });
    }

    private void postData(String sn, String username, String location, String latitude, String longitude) {
        loadingPB.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://36.92.168.180:7480/drivetest/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);



        Call<ApiResponse> call = retrofitAPI.sendData(sn, username, location, latitude,  longitude);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d("kk",  response.toString());
                if (response.isSuccessful()) {
                    // Handle a successful response here
                    ApiResponse apiResponse = response.body();

                    // Tampilkan data dari 'device'
                    Device device = apiResponse.getDevice();
                    String deviceInfo = "SN: " + device.getSn() + "\n" +
                            "DevEui: " + device.getDevEui() + "\n" +
                            "Last Update: " + device.getLastUpdate() + "\n" +
                            "rssi " + device.getRssi() + "\n" + "snr" + device.getSnr() + "\n"
                            + "latitude" + device.getDev_lat() + "\n" + "longitude" + device.getDev_lon() + "\n" +
                            "location" + device.getDev_location() + "\n";
                            // Tambahkan atribut lainnya yang ingin Anda tampilkan

                            deviceInfoTV.setText(deviceInfo);

                    // Tampilkan data dari daftar 'gateway'
                    List<Gateway> gatewayList = apiResponse.getGateway().getList();
                    StringBuilder gatewayInfo = new StringBuilder();
                    for (Gateway gateway : gatewayList) {
                        gatewayInfo.append("GW ID: ").append(gateway.getGw_id()).append("\n")
                                .append("GW Name: ").append(gateway.getGw_name()).append("\n")
                                .append("Distance: ").append(gateway.getDistance()).append("\n\n");
                    }

                    gatewayInfoTV.setText(gatewayInfo.toString());



                    Toast.makeText(MainActivity.this, "Data berhasil dikirim ke API", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle an unsuccessful response here
                    Toast.makeText(MainActivity.this, "Gagal mengirim data ke API", Toast.LENGTH_SHORT).show();
                }
                loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                responseTV.setText("Error: " + t.getMessage()); // Menampilkan pesan kesalahan di responseTV
                loadingPB.setVisibility(View.GONE);
            }

        });
    }
}

