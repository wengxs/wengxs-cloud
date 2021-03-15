package com.wengxs.cloud.core;

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

    public static R ok() {
        return ok(null);
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.data = data;
        return r;
    }

    public static R fail(String message) {
        R r = new R();
        r.setCode(FAIL);
        r.setMessage(message);
        return r;
    }

    public static R fail(Throwable e) {
        return fail(e.getMessage());
    }

}
