package com.ptconsultancy.admin;

public class BuildVersion {

    public static String getBuildVersion() {

        return BuildVersion.class.getPackage().getImplementationVersion();
    }

    public static String getBuildProjectTitle() {

        return BuildVersion.class.getPackage().getImplementationTitle();
    }
}
