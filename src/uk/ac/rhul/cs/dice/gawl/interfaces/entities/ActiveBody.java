package uk.ac.rhul.cs.dice.gawl.interfaces.entities;

import java.util.ArrayList;
import java.util.List;

import uk.ac.rhul.cs.dice.gawl.interfaces.actions.EnvironmentalAction;
import uk.ac.rhul.cs.dice.gawl.interfaces.appearances.BodyAppearance;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.agents.AbstractActuator;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.agents.AbstractAgent;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.agents.AbstractSensor;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.agents.Actuator;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.agents.Sensor;

/**
 * A subclass of {@link PhysicalBody} capable to perform and/or simulate an {@link EnvironmentalAction}, thus implementing {@link Actor} and {@link Simulator}. It has a {@link List}
 * of {@link Sensor} elements and one of {@link Actuator} elements.<br/><br/>
 * 
 * Known direct subclasses: {@link AbstractAgent}, {@link DependentBody}.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Ben Wilkins
 * @author Kostas Stathis
 *
 */
public abstract class ActiveBody extends PhysicalBody implements Actor, Simulator {
	private List<Sensor> sensors;
	private List<Actuator> actuators;
	
	/**
	 * Constructor with a {@link BodyAppearance}, a {@link List} of {@link Sensor} instances and
	 * one of {@link Actuator} instances.
	 * 
	 * @param appearance : the {@link BodyAppearance} of the {@link ActiveBody}.
	 * @param sensors : a {@link List} of {@link Sensor} instances.
	 * @param actuators : a {@link List} of {@link Actuator} instances.
	 */
	public ActiveBody(BodyAppearance appearance, List<Sensor> sensors, List<Actuator> actuators) {
		super(appearance);
		
		this.sensors = sensors != null ? sensors : new ArrayList<>();
		this.actuators = actuators != null ? actuators : new ArrayList<>();
		
		init();
	}

	private void init() {
		if(!this.sensors.isEmpty()){
			initSensors();
		}
		
		if(!this.actuators.isEmpty()) {
			initActuators();
		}
	}

	private void initActuators() {
		for(Actuator a : this.actuators) {
			registerActuator(a);
		}
	}

	private void initSensors() {
		for(Sensor s : this.sensors) {
			registerSensor(s);
		}
	}

	/**
	 * Returns a {@link List} of {@link Sensor} instances.
	 * 
	 * @return the {@link List} of {@link Sensor} instances.
	 */
	@Override
	public List<Sensor> getSensors() {
		return this.sensors;
	}
	
	/**
	 * Returns a {@link List} of {@link Actuator} instances.
	 * 
	 * @return the {@link List} of {@link Actuator} instances.
	 */
	@Override
	public List<Actuator> getActuators() {
		return this.actuators;
	}
	
	/**
	 * Adds a {@link Sensor} to the {@link List}.
	 * 
	 * @param sensor : the {@link Sensor} to be added to the {@link List}.
	 */
	@Override
	public void addSensor(Sensor sensor) {
		registerSensor(sensor);
		
		this.sensors.add(sensor);
	}
	
	/**
	 * Adds an {@link Actuator} to the {@link List}.
	 * 
	 * @param sensor : the {@link Actuator} to be added to the {@link List}.
	 */
	@Override
	public void addActuator(Actuator actuator) {
		registerActuator(actuator);
		
		this.actuators.add(actuator);
	}
	
	private void registerActuator(Actuator actuator) {
		if(actuator instanceof AbstractActuator) {
			((AbstractActuator) actuator).addObserver(this);
			this.addObserver(actuator);
		}
	}
	
	private void registerSensor(Sensor sensor) {
		if(sensor instanceof AbstractSensor) {
			((AbstractSensor) sensor).addObserver(this);
			this.addObserver(sensor);
		}
	}
}