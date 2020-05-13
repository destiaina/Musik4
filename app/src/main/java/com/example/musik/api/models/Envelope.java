package com.example.musik.api.models;

public class Envelope<T> {
    public T result;

    public Envelope(T results) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

