package br.com.marcelbraghini.infrastructure.repository;

import br.com.marcelbraghini.entities.Measurement;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeasurementRepository implements PanacheMongoRepository<Measurement> {
}
