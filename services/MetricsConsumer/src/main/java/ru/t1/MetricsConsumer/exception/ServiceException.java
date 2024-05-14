package ru.t1.MetricsConsumer.exception;

public class ServiceException extends Exception{
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
