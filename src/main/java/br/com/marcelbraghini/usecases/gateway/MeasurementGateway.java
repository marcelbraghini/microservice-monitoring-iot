package br.com.marcelbraghini.usecases.gateway;

import br.com.marcelbraghini.entities.Measurement;
import br.com.marcelbraghini.usecases.exception.MeasurementException;

import java.util.List;

public interface MeasurementGateway {
    List<Measurement> findMeasurement() throws MeasurementException;

    Measurement saveMeasurement(final Measurement measurement) throws MeasurementException;
}