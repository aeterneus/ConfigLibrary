package com.kuldegor.config_library;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ConfigFile extends Config {

    public ConfigFile() {
        super();
    }

    public ConfigFile(File file) throws FileNotFoundException {
        super();
        setData(file);
    }

    private void setData(File file) throws FileNotFoundException {

        Gson gson = new Gson();
        mParametersMap = gson.fromJson(new FileReader(file),
                TypeToken.getParameterized(
                        Map.class,
                        String.class,
                        Object.class).getType());
        if (mParametersMap==null){
            mParametersMap = new HashMap<>();
        }

    }

    public static <T> T loadConfig(File file,Class<T> ofClass) throws FileNotFoundException {
        Gson gson = new Gson();
       return gson.fromJson(new FileReader(file),ofClass);
    }

    public void addParameterData(Parameter parameter,Object data){
        mParametersMap.put(parameter.getName(),data);
    }

    public void saveConfigFile(File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(mParametersMap);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }


}
