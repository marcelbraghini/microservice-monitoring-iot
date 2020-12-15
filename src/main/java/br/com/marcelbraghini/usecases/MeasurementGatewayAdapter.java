package br.com.marcelbraghini.usecases;

import br.com.marcelbraghini.entities.Measurement;
import br.com.marcelbraghini.infrastructure.repository.MeasurementRepository;
import br.com.marcelbraghini.usecases.exception.MeasurementException;
import br.com.marcelbraghini.usecases.gateway.MeasurementGateway;
import io.quarkus.mongodb.panache.PanacheQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MeasurementGatewayAdapter implements MeasurementGateway {

    private final Logger log = LoggerFactory.getLogger(MeasurementGatewayAdapter.class);

    private MeasurementRepository measurementRepository;

    @Inject
    public MeasurementGatewayAdapter(final MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public List<Measurement> findMeasurement() throws MeasurementException {
        try {
            final PanacheQuery<Measurement> measurementRepositoryAll = measurementRepository.findAll();

            log.info("[findMeasurement] {} results were retrieved", measurementRepositoryAll.list().size());

            return measurementRepositoryAll.list();
        } catch (final Exception e) {
            throw new MeasurementException("Failed to find Measurement", e);
        }
    }

    @Override
    public Measurement saveMeasurement(final Measurement measurement) throws MeasurementException {
        try {
            measurementRepository.persist(measurement);

            log.info("[saveMeasurement] was saved {}", measurement.toString());

            return measurement;
        } catch (final Exception e) {
            throw new MeasurementException("Failed to save Measurement", e);
        }
    }
}
