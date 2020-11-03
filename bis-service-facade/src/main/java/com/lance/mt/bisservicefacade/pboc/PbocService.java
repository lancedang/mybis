package com.lance.mt.bisservicefacade.pboc;

import java.io.Serializable;

/**
 * Author: 钱凯
 * Date: 11/3/20.
 */
public interface PbocService {
    PbocResponse queryPbocByIdNo(PbocRequest pbocRequest);
}
