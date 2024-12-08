package com.example.sunnygym;

public class Activity {
    private String name;
    private int imageResId;

    // Constructor
    public Activity(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    // Setters (opcional, si necesitas modificar los valores después de la creación)
    public void setName(String name) {
        this.name = name;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
