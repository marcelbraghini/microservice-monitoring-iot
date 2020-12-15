package br.com.marcelbraghini.usecases.exception;

public class MeasurementException extends Exception {

    public MeasurementException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
