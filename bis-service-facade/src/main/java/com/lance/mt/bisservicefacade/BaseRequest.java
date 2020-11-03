// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.bisservicefacade;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/3/20 8:15 PM
 **/
@Data
public class BaseRequest implements Serializable {
    private String              businessCode;
    private String              productCode;
    //使用基本类型还是包装类
    private boolean             isSync;
    //使用object可行
    private Map<String, Object> extInfo = new HashMap<>();
}