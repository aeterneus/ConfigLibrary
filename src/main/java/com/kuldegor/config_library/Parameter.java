package com.kuldegor.config_library;

public class Parameter {
    private String mName;
    private String mShortName;
    private String mDescription;

    public Parameter(String name, String shortName, String description) {
        mName = name;
        mShortName = shortName;
        mDescription = description;
    }

    public Parameter(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public String getShortName() {
        return mShortName;
    }

    public String getDescription() {
        return mDescription;
    }
}
