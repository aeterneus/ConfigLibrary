package com.kuldegor.config_library;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class ConfigFileTest {

    @Test
    public void saveConfigFile() throws IOException {
        Parameter someParameter = new Parameter("someParameter");
        Parameter numberParameter = new Parameter("xParameter");
        Parameter classParameter = new Parameter("classParameter");
        ConfigFile configFile = new ConfigFile();
        configFile.addParameterData(someParameter,"Some string data");
        configFile.addParameterData(numberParameter,123);
        configFile.addParameterData(classParameter,new SomeClass("Class some string",1945));
        configFile.saveConfigFile(new File("config.json"));
    }

    @Test
    public void loadConfigFile() throws FileNotFoundException {
        Parameter someParameter = new Parameter("someParameter");
        Parameter numberParameter = new Parameter("xParameter");
        Parameter classParameter = new Parameter("classParameter");
        ConfigFile configFile = new ConfigFile(new File("config.json"));
        assertEquals("Some string data",configFile.getParameterData(someParameter));
        assertEquals(123,((Number)configFile.getParameterData(numberParameter)).intValue());
        Map<String,Object> actual = (Map<String, Object>) configFile.getParameterData(classParameter);
        assertNotNull(actual);
        assertEquals("Class some string",actual.get("mSomeString"));
        assertEquals(1945,((Number)actual.get("mSomeInteger")).intValue());
    }


    private static class SomeClass {
        public String mSomeString;
        public Integer mSomeInteger;

        public SomeClass(String someString, Integer someInteger) {
            mSomeString = someString;
            mSomeInteger = someInteger;
        }
    }
}