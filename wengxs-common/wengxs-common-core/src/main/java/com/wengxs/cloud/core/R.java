package com.wengxs.cloud.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Zorg
 * 2020-02-10 01:14
 */
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    public static final int SUCCESS = 200;

    public static final int FAIL = 500;

    private int code = SUCCESS;

    private String message = "success";

    private T data;

    public static R<?> ok() {
        return ok(null);
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.data = data;
        return r;
    }

    public static <T> R<T> fail(String message) {
        R<T> r = new R<>();
        r.setCode(FAIL);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> fail(Throwable e) {
        return fail(e.getMessage());
    }

    @JsonIgnore
    public boolean isOk() {
        return this.code == SUCCESS;
    }

}
