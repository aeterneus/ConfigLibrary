package com.kuldegor.config_library;

import java.util.HashMap;
import java.util.Map;

public abstract class Config {
    protected Map<String,Object> mParametersMap;

    public Config() {
        mParametersMap = new HashMap<>();
    }

    public Object getParameterData(Parameter parameter){
        Object data = mParametersMap.get(parameter.getName());
        if (data==null){
            data = mParametersMap.get(parameter.getShortName());
        }
        return data;
    }

}
