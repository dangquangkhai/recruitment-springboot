package com.dev.recruitmentsystem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomErrorResponseContent {
    private HashMap<String, Object> res = new HashMap<>();
    private String sc, message;

    public CustomErrorResponseContent(String sc, String message) {
        this.setSc(sc);
        this.setMessage(message);
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getRes() {
        res = new HashMap<>();
        Instant instant = Instant.now();
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        String code = this.getSc(), mess = this.getMessage();
        Object error = new Object() {
            public String status = code;
            public String timestamp = now.toString();
            public String message = mess;
        };
        HashMap<String, Object> res = new HashMap<>();
        res.put("status", false);
        res.put("data", error);
        return res;
    }

    @Override
    public String toString() {
        try {
            return ReflectionHelper._mapper().writeValueAsString(this.getRes());
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
