package com.kuldegor.config_library;

public class ConfigConsole extends Config {

    public ConfigConsole(String[] args) {
        super();
        setData(args);
    }

    private void setData(String[] args){
        int n = (args.length/2)+args.length%2;

        for (int i=0;i<n;i++){
            int nameIndex = i*2;
            int valueIndex = nameIndex+1;
            String name = args[nameIndex].replace("-","");
            String value = null;
            if (valueIndex<args.length){
                value = args[valueIndex];
            }
            mParametersMap.put(name,value);
        }
    }

    public static String getHelpText(Parameter ... parameters){
        StringBuilder stringBuilder = new StringBuilder();
        for (Parameter parameter:parameters){
            if (stringBuilder.length()>0){
                stringBuilder.append("\n");
            }
            stringBuilder
                    .append("--").append(parameter.getName())
                    .append(" (-").append(parameter.getShortName()).append(") - ")
                    .append(parameter.getDescription()).append(".");
        }
        return stringBuilder.toString();
    }

}
