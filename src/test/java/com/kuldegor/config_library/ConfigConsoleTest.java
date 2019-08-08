package com.kuldegor.config_library;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigConsoleTest {
    private static final Parameter parameter = new Parameter("someParameter","sp","Description of some parameter");
    private static final Parameter parameter2 = new Parameter("someParameter2","sp2","Description of some parameter");
    private static final Parameter parameter3 = new Parameter("someParameter3","sp3","Description of some parameter");
    private static final Parameter parameter4 = new Parameter("someParameter4","sp4","Description of some parameter");


    @Test
    public void getHelpText() {

        String helpText = ConfigConsole.getHelpText(
                parameter,
                parameter2,
                parameter3,
                parameter4
        );
        assertEquals("--someParameter (-sp) - Description of some parameter.\n" +
                "--someParameter2 (-sp2) - Description of some parameter.\n" +
                "--someParameter3 (-sp3) - Description of some parameter.\n" +
                "--someParameter4 (-sp4) - Description of some parameter.",helpText);
    }

    @Test
    public void loadConfig(){

        String[] args = new String[] {
                "--someParameter","some value",
                "-sp2","some value 2",
                "--someParameter3"
        };
        ConfigConsole configConsole = new ConfigConsole(args);
        assertEquals("some value",configConsole.getParameterData(parameter));
        assertEquals("some value 2",configConsole.getParameterData(parameter2));
        assertNull(configConsole.getParameterData(parameter3));
        assertNull(configConsole.getParameterData(parameter4));

    }
    @Test
    public void loadConfig2(){

        String[] args = new String[] {};
        ConfigConsole configConsole = new ConfigConsole(args);
        assertNull(configConsole.getParameterData(parameter));
        assertNull(configConsole.getParameterData(parameter2));
        assertNull(configConsole.getParameterData(parameter3));
        assertNull(configConsole.getParameterData(parameter4));

    }

}