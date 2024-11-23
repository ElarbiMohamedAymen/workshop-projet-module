package com.example.demo.exceptions;

public class ModuleNotFoundException extends Exception {

    public ModuleNotFoundException() {
    }

    public ModuleNotFoundException(String message) {
        super(message);
    }
}
