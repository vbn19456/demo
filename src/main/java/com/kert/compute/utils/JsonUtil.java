package com.kert.compute.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonUtil {
    private static final JsonMapper jsonMapper;
    static {
        jsonMapper = JsonMapper.builder()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();
    }
    public static String toStr(Object obj) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(obj);
    }
    public static String byte2Str(byte[] obj) throws JsonProcessingException {
        String s = new String(obj);
        return jsonMapper.writeValueAsString(s);
    }

    public static Object toObj(String json) throws JsonProcessingException {
        return jsonMapper.readValue(json,Object.class);
    }
}
