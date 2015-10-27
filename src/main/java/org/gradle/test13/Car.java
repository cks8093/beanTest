package org.gradle.test13;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	String model;
	Engine engine;

	public Car() {
	}

	public Car(String model, Engine engine) {
		this.model = model;
		this.engine = engine;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	@Resource(name="kiaEngine")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		StringBuffer carInfo = new StringBuffer();
		carInfo.append("[Car:" + model);
		carInfo.append("\n  " + engine.toString());
		return carInfo.toString();
	}
}
