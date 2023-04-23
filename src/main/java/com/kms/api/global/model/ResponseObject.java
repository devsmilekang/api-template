package com.kms.api.global.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject<T> {

    private Object data;

    public ResponseObject(Object data) {
        this.data = data;
    }
}
