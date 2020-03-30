package com.renault.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {

    private int id;

    @NotNull
    @Pattern(regexp = "[a-zA-z0-9_-]")
    private String name;

    public UserDto() {
    }

    public UserDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
