package br.com.marcelbraghini.adapters.resource;

import br.com.marcelbraghini.adapters.resource.converter.MeasurementResourceConverter;
import br.com.marcelbraghini.adapters.resource.domain.MeasurementRequest;
import br.com.marcelbraghini.adapters.resource.domain.MeasurementResponse;
import br.com.marcelbraghini.entities.Measurement;
import br.com.marcelbraghini.usecases.exception.MeasurementException;
import br.com.marcelbraghini.usecases.gateway.MeasurementGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/measurement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MeasurementResource {

    private final Logger log = LoggerFactory.getLogger(MeasurementResource.class);

    private final MeasurementGateway measurementGateway;

    private final MeasurementResourceConverter measurementResourceConverter;

    @Inject
    public MeasurementResource(final MeasurementGateway measurementGateway,
                               final MeasurementResourceConverter measurementResourceConverter) {
        this.measurementGateway = measurementGateway;
        this.measurementResourceConverter = measurementResourceConverter;
    }

    @GET
    public Response findReadingTemperature() {
        try {
            final List<Measurement> measurements = measurementGateway.findMeasurement();

            final List<MeasurementResponse> measurementResponses =
                    measurementResourceConverter.toMeasurementResponseList(measurements);

            return Response.status(Response.Status.OK).entity(measurementResponses).build();
        } catch (final MeasurementException e) {
            log.error("[findReadingTemperature:MeasurementException] "+e.getMessage()+" - "+e.getCause());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (final Exception e) {
            log.error("[findReadingTemperature:Exception] "+e.getMessage()+" - "+e.getCause());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    public Response saveReadingTemperature(final MeasurementRequest measurementRequest) {
        try {
            final Measurement measurement = measurementGateway
                    .saveMeasurement(measurementResourceConverter.totoMeasurement(measurementRequest));

            final MeasurementResponse measurementResponse =
                    measurementResourceConverter.totoMeasurementResponse(measurement);

            return Response.status(Response.Status.CREATED).entity(measurementResponse).build();
        } catch (final MeasurementException e) {
            log.error("[saveReadingTemperature:MeasurementException] "+e.getMessage()+" - "+e.getCause());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (final Exception e) {
            log.error("[saveReadingTemperature:Exception] "+e.getMessage()+" - "+e.getCause());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
