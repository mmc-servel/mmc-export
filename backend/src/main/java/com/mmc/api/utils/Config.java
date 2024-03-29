/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mmc.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;

public class Config {

    private static Config singleton = null;
    private static JSONObject json = null;

    private Config() {
    }

    public static void create(String fileName) throws FileNotFoundException {
        if (singleton == null) {
            singleton = new Config();
            json = new JSONObject(new Scanner(new File(fileName)).useDelimiter("\\Z").next());
        } else {
            //TO DO: Throw exception - Config already created (you are trying to create it second time)
        }
    }

    public static Config getInstance() {
        if (singleton == null) {
            //TO DO: Throw exception - you must Config.create("fileNmae")  first.
        }
        return singleton;
    }

    public static String getValueByKey(String keyValue) {
        return json.getString(keyValue);
    }
    public static org.json.JSONObject getJson() {

        return json;
    }    
}
