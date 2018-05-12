package adong.org.finedust.data;

public class DustList {
    private String dataTime;
    private String stationName;
    private String pm10Value;
    private String pm25Value;

    public DustList(){}

    public DustList(String dataTime, String stationName, String pm10Value, String pm25Value) {
        this.dataTime = dataTime;
        this.stationName = stationName;
        this.pm10Value = pm10Value;
        this.pm25Value = pm25Value;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPm10Value() {
        return pm10Value;
    }

    public void setPm10Value(String pm10Value) {
        this.pm10Value = pm10Value;
    }

    public String getPm25Value() {
        return pm25Value;
    }

    public void setPm25Value(String pm25Value) {
        this.pm25Value = pm25Value;
    }
}