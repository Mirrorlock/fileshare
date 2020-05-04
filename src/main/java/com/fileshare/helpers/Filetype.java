package com.fileshare.helpers;

public enum Filetype {
    File("file"),
    Directory("directory");

    public final String type;

    Filetype(String type) {
        this.type = type;
    }
}
