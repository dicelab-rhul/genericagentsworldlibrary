package uk.ac.rhul.cs.dice.gawl.interfaces.environment;

import java.util.HashSet;
import java.util.Set;

import uk.ac.rhul.cs.dice.gawl.interfaces.actions.AbstractAction;
import uk.ac.rhul.cs.dice.gawl.interfaces.appearances.Appearance;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.Body;
import uk.ac.rhul.cs.dice.gawl.interfaces.environment.physics.Physics;

/**
 * The most general class representing an environment. It has an {@link EnvironmentalSpace}, a {@link Set} of admissible {@link AbstractAction}
 * elements and one of {@link Body} elements. It also contains an instance of {@link Physics}, a {@link Boolean} indicating whether
 * it is bounded or not, and an {@link Appearance}.<br/><br/>
 * 
 * Known direct subclasses: {@link SimpleEnvironment}.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Ben Wilkins
 * @author Kostas Stathis
 *
 */
public abstract class AbstractEnvironment implements Environment, Container {
	private Space state;
	private Set<Class<? extends AbstractAction>> admissibleActions;
	private Set<Body> bodies;
	private Physics physics;
	private Boolean bounded;
	private Appearance appearance;
	
	/**
	 * The default class constructor.
	 * 
	 * @param state : an {@link Space} instance.
	 * @param admissibleActions : the {@link Set} of performable {@link AbstractAction} instances.
	 * @param bodies : a {@link Set} of {@link Body} elements.
	 * @param physics : the {@link Physics} of the environment.
	 * @param bounded : a {@link Boolean} value indicating whether the environment is bounded or not.
	 * @param appearance : the {@link Appearance} of the environment.
	 */
	public AbstractEnvironment(Space state, Set<Class<? extends AbstractAction>> admissibleActions, Set<Body> bodies, Physics physics, Boolean bounded, Appearance appearance) {
		this.state = state;
		this.admissibleActions = admissibleActions != null ? admissibleActions : new HashSet<>();
		this.bodies = bodies != null ? bodies : new HashSet<>();
		this.physics = physics;
		this.bounded = bounded;
		this.appearance = appearance;
	}

	@Override
	public Space getState() {
		return this.state;
	}

	@Override
	public void setState(Space state) {
		this.state = state;
	}

	@Override
	public Set<Class<? extends AbstractAction>> getAdmissibleActions() {
		return this.admissibleActions;
	}

	@Override
	public void setAdmissibleActions(Set<Class<? extends AbstractAction>> admissibleActions) {
		this.admissibleActions = admissibleActions;
	}

	@Override
	public Set<Body> getBodies() {
		return this.bodies;
	}

	@Override
	public void setBodies(Set<Body> bodies) {
		this.bodies = bodies;
	}

	@Override
	public Physics getPhysics() {
		return this.physics;
	}

	@Override
	public void setPhysics(Physics physics) {
		this.physics = physics;
	}

	@Override
	public Boolean isBounded() {
		return this.bounded;
	}

	@Override
	public void setBounded(Boolean bounded) {
		this.bounded = bounded;
	}

	@Override
	public Appearance getAppearance() {
		return this.appearance;
	}

	@Override
	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}
}