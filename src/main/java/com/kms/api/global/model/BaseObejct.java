package com.kms.api.global.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseObejct<T> {

    private Object data;

    public BaseObejct(Object data) {
        this.data = data;
    }
}
