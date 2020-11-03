// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.bisservicefacade.pboc;

import com.lance.mt.bisservicefacade.BaseRequest;
import lombok.Data;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/3/20 9:02 PM
 **/
@Data
public class PbocRequest extends BaseRequest {
    private String queryType;
}