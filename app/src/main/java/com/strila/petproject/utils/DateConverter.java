package com.strila.petproject.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Serhii Strila on 10/1/17
 */

public class DateConverter implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context)
            throws JsonParseException {
        long time = json.getAsJsonPrimitive().getAsLong();
        long timeMillis = time * 1000;
        return new Date(timeMillis + TimeZone.getDefault().getOffset(System.currentTimeMillis()));

    }

}
