// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.bisservicefacade;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/3/20 8:15 PM
 **/
@Data
public class BaseResponse<T> implements Serializable {
    private int    status;
    private String message;
    private T      data;
}