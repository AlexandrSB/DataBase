package com.example.restservice.domain;

public enum EnumTypeOfEquipment {
    PRINTER("Принтер"),
    MFP("МФУ"),
    PLOTTER("Плоттер");

    private String name;

    EnumTypeOfEquipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
