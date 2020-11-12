package com.github.ypdieguez.calaveritatech.exercise.data;

/**
 * A generic class that holds a message with its status.
 */
public class Resource {
    public enum Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    private final Status status;
    private final String message;

    private Resource(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    static Resource success() {
        return new Resource(Status.SUCCESS, "OK");
    }

    static Resource error(String msg) {
        return new Resource(Status.ERROR, msg);
    }

    static Resource loading() {
        return new Resource(Status.LOADING, "LOADING");
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
