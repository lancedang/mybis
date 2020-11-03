// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.bisserviceimpl.pboc;

import com.lance.mt.bisservicefacade.pboc.PbocRequest;
import com.lance.mt.bisservicefacade.pboc.PbocResponse;
import com.lance.mt.bisservicefacade.pboc.PbocService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/3/20 9:17 PM
 **/
public class PbocServiceImpl implements PbocService {
    @Override
    public PbocResponse queryPbocByIdNo(PbocRequest pbocRequest) {

        PbocResponse pbocResponse = new PbocResponse();

        Map<String, String> result = new HashMap<>();
        result.put("address", "背景");
        pbocResponse.setData(result);
        pbocResponse.setStatus(0);
        pbocResponse.setMessage("success");

        return pbocResponse;
    }
}