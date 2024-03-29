package com.mmc.api.utils;

import org.json.*;

public class Convert {

    private static Convert singleton = null;

    private Convert() {
    };
    
    public static Convert getInstance() {
        if (singleton == null) {
            singleton = new Convert();
        }
        return singleton;
    }

    public JSONObject stringToJson(String jsonString) throws JSONException{
        return new JSONObject(jsonString);
    }
}
