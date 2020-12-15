package br.com.marcelbraghini.adapters.resource.domain;

public class MeasurementResponse {

    private String temperature;

    private String moisture;

    private String dateTime;

    public MeasurementResponse(String temperature, String moisture, String dateTime) {
        this.temperature = temperature;
        this.moisture = moisture;
        this.dateTime = dateTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getMoisture() {
        return moisture;
    }

    public String getDateTime() {
        return dateTime;
    }
}
