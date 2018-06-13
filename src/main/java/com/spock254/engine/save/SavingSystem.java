package com.spock254.engine.save;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavingSystem {

    private Map<String,String> data;

    public SavingSystem(){
        this.data = new HashMap<String, String>();
    }

    public String getString(String key){
        return data.get(key);
    }
    public int getInteger(String key){
        return Integer.parseInt(data.get(key));
    }
    public float getFloat(String key){
        return Float.parseFloat(data.get(key));
    }
    public double getDouble(String key){
        return Double.parseDouble(data.get(key));
    }
    public byte getByte(String key){
        return Byte.parseByte(key);
    }

}
