package com.example.cobaapi;

import java.util.List;
/*
class Device {
    @SerializedName("sn")
    private String sn;

    @SerializedName("devEui")
    private String devEui;

    @SerializedName("lastUpdate")
    private String lastUpdate;

    @SerializedName("rssi")
    private int rssi;

    @SerializedName("snr")
    private double snr;

    @SerializedName("counter")
    private int counter;

    @SerializedName("dev_lat")
    private String devLat;

    @SerializedName("dev_lon")
    private String devLon;

    @SerializedName("dev_location")
    private String devLocation;

    // Buat getter untuk semua atribut di atas
    // ...
    public String getSn() {
        return sn;
    }

    public String getDevEui() {
        return devEui;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public int getRssi() {
        return rssi;
    }

    public double getSnr() {
        return snr;
    }

    public int getCounter() {
        return counter;
    }

    public String getDevLat() {
        return devLat;
    }

    public String getDevLon() {
        return devLon;
    }

    public String getDevLocation() {
        return devLocation;
    }
}

class Gateway {
    @SerializedName("gw_id")
    private String gwId;

    @SerializedName("duplicate")
    private boolean duplicate;

    @SerializedName("gw_name")
    private String gwName;

    @SerializedName("gw_lat")
    private String gwLat;

    @SerializedName("gw_lon")
    private String gwLon;

    @SerializedName("distance")
    private double distance;

    // Buat getter untuk semua atribut di atas
    // ...
    public String getGwId() {
        return gwId;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public String getGwName() {
        return gwName;
    }

    public String getGwLat() {
        return gwLat;
    }

    public String getGwLon() {
        return gwLon;
    }

    public double getDistance() {
        return distance;
    }

}

 public class ApiResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("username")
    private String username;

    @SerializedName("device")
    private Device device;

    @SerializedName("gateway")
    private List<Gateway> gatewayList;

    // Buat getter untuk atribut message
    public String getMessage() {
        return message;
    }

    // Buat getter untuk atribut username
    public String getUsername() {
        return username;
    }

    // Buat getter untuk atribut device
    public Device getDevice() {
        return device;
    }

    // Buat getter untuk atribut gatewayList
    public List<Gateway> getGatewayList() {
        return gatewayList;
    }
}
 */

public class ApiResponse {
    private String message;
    private String username;
    private Device device;
    private GatewayWrapper gateway;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public GatewayWrapper getGateway() {
        return gateway;
    }

    public void setGateway(GatewayWrapper gateway) {
        this.gateway = gateway;
    }
}

 class Device {
    private String sn;
    private String devEui;
    private String lastUpdate;
    private double rssi;
    private double snr;
    private int counter;
    private String dev_lat;
    private String dev_lon;
    private String dev_location;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDevEui() {
        return devEui;
    }

    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public double getRssi() {
        return rssi;
    }

    public void setRssi(double rssi) {
        this.rssi = rssi;
    }

    public double getSnr() {
        return snr;
    }

    public void setSnr(double snr) {
        this.snr = snr;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getDev_lat() {
        return dev_lat;
    }

    public void setDev_lat(String dev_lat) {
        this.dev_lat = dev_lat;
    }

    public String getDev_lon() {
        return dev_lon;
    }

    public void setDev_lon(String dev_lon) {
        this.dev_lon = dev_lon;
    }

    public String getDev_location() {
        return dev_location;
    }

    public void setDev_location(String dev_location) {
        this.dev_location = dev_location;
    }
}

 class Gateway {
    private String gw_id;
    private boolean duplicate;
    private String gw_name;
    private String gw_lat;
    private String gw_lon;
    private double distance;

    public String getGw_id() {
        return gw_id;
    }

    public void setGw_id(String gw_id) {
        this.gw_id = gw_id;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    public String getGw_name() {
        return gw_name;
    }

    public void setGw_name(String gw_name) {
        this.gw_name = gw_name;
    }

    public String getGw_lat() {
        return gw_lat;
    }

    public void setGw_lat(String gw_lat) {
        this.gw_lat = gw_lat;
    }

    public String getGw_lon() {
        return gw_lon;
    }

    public void setGw_lon(String gw_lon) {
        this.gw_lon = gw_lon;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

 class GatewayWrapper {
    private List<Gateway> list;

    public List<Gateway> getList() {
        return list;
    }

    public void setList(List<Gateway> list) {
        this.list = list;
    }
}


