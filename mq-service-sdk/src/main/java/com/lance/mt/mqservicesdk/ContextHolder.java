// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.mqservicesdk;

import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/4/20 11:04 AM
 **/
public class ContextHolder {
    private static final ThreadLocal<String>       org      = new ThreadLocal<>();
    private static final ThreadLocal<String>       username = new ThreadLocal<>();
    private static final ThreadLocal<List<Object>> bankList = new ThreadLocal<>();

    public static void setOrg(String org) {
        ContextHolder.org.set(org);
    }

    public static String getOrg() {
        return ContextHolder.org.get();
    }

    public static void setUsername(String username) {
        ContextHolder.username.set(username);
    }

    public static String getUserName() {
        return ContextHolder.username.get();
    }

    public static void setBankList(List<Object> list) {
        ContextHolder.bankList.set(list);
    }

    public static List<Object> getBankList() {
        return ContextHolder.bankList.get();
    }

    public static void removeOrg() {
        ContextHolder.org.remove();
    }

    public static void removeUserName() {
        ContextHolder.username.remove();
    }

    public static void removeBankList() {
        ContextHolder.bankList.remove();
    }

}