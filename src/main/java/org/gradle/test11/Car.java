package org.gradle.test11;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	String model;
	Engine engine;
	Tire tire;

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

	@Autowired(required = false)
	public void setTire(Tire tire) {
		this.tire = tire;
	}

	public Tire getTire() {
		return tire;
	}

	public Engine getEngine() {
		return engine;
	}

	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		StringBuffer carInfo = new StringBuffer();
		carInfo.append("[Car:" + model);
		carInfo.append("\n  " + engine.toString());
		if (tire != null) {
			carInfo.append("\n  " + tire.toString());
		}
		return carInfo.toString();
	}
}
