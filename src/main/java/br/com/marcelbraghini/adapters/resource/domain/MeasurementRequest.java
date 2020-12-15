package br.com.marcelbraghini.adapters.resource.domain;

public class MeasurementRequest {

    private String temperature;

    private String moisture;

    public MeasurementRequest(String temperature, String moisture) {
        this.temperature = temperature;
        this.moisture = moisture;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getMoisture() {
        return moisture;
    }
}
