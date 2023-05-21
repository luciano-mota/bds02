package com.devsuperior.bds02.exceptions.handler;

import java.io.Serializable;

public class StandartError implements Serializable {

    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandartError() {}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
