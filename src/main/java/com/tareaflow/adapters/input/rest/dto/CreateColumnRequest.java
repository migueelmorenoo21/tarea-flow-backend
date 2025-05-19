package com.tareaflow.adapters.input.rest.dto;

public class CreateColumnRequest {
    private String name;
    private int position;

    public CreateColumnRequest() {}

    public CreateColumnRequest(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
}
