package com.example.cars.entity;

import java.io.Serializable;

public class Specification implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4058988512660666064L;
	private EngineType engine;
    private Color color;

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
