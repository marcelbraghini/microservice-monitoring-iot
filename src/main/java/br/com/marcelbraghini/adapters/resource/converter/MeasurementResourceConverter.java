package br.com.marcelbraghini.adapters.resource.converter;

import br.com.marcelbraghini.adapters.resource.domain.MeasurementRequest;
import br.com.marcelbraghini.adapters.resource.domain.MeasurementResponse;
import br.com.marcelbraghini.entities.Measurement;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MeasurementResourceConverter {

    public List<MeasurementResponse> toMeasurementResponseList(final List<Measurement> measurements) {
        List<MeasurementResponse> measurementResponses = new ArrayList<>();

        measurements.forEach(m -> {
            MeasurementResponse measurementResponse = new MeasurementResponse(m.getTemperature(), m.getMoisture(), m.getDateTime().toString());
            measurementResponses.add(measurementResponse);
        });

        return measurementResponses;
    }

    public MeasurementResponse totoMeasurementResponse(final Measurement measurement) {
        return new MeasurementResponse(measurement.getTemperature(), measurement.getMoisture(), measurement.getDateTime().toString());
    }

    public Measurement totoMeasurement(final MeasurementRequest measurementRequest) {
        return new Measurement(measurementRequest.getTemperature(), measurementRequest.getMoisture());
    }
}
