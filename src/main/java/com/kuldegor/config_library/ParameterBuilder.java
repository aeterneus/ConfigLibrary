package com.kuldegor.config_library;

public class ParameterBuilder {
    private String mName;
    private String mShortName;
    private String mDescription;

    public ParameterBuilder(Parameter parameter) {
        mName = parameter.getName();
        mShortName = parameter.getShortName();
        mDescription = parameter.getDescription();
    }

    public ParameterBuilder() {
    }

    public String getName() {
        return mName;
    }

    public ParameterBuilder setName(String name) {
        mName = name;
        return this;
    }

    public String getShortName() {
        return mShortName;
    }

    public ParameterBuilder setShortName(String shortName) {
        mShortName = shortName;
        return this;
    }

    public String getDescription() {
        return mDescription;
    }

    public ParameterBuilder setDescription(String description) {
        mDescription = description;
        return this;
    }


    public Parameter build(){
        return new Parameter(mName,mShortName,mDescription);
    }
}
