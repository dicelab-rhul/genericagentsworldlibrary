package uk.ac.rhul.cs.dice.gawl.interfaces.environment;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rhul.cs.dice.gawl.interfaces.appearances.ComplexEnvironmentAppearance;
import uk.ac.rhul.cs.dice.gawl.interfaces.environment.physics.Physics;
import uk.ac.rhul.cs.dice.gawl.interfaces.perception.Perception;

/**
 * A subclass of {@link SimpleEnvironment} which can contain an arbitrary number of {@link AbstractEnvironment} instances as sub-environments.
 * Thus, the method {@link #isSimple()} will always return false.<br/><br/>
 * 
 * Known direct subclasses: {@link Universe}.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Ben Wilkins
 * @author Kostas Stathis
 *
 */
public abstract class ComplexEnvironment<P extends Perception> extends SimpleEnvironment<P> {
	private List<AbstractEnvironment<P>> subEnvironments;
	
	/**
	 * The default class constructor.
	 * 
	 * @param state : an {@link Space} instance.
	 * @param physics : the {@link Physics} of the environment.
	 * @param bounded : a {@link Boolean} value indicating whether the environment is bounded or not.
	 * @param appearance : the {@link ComplexEnvironmentAppearance} of the environment.
	 */
	public ComplexEnvironment(Space state, Physics<P> physics, Boolean bounded, ComplexEnvironmentAppearance appearance) {
		super(state, physics, bounded, appearance);
		
		this.subEnvironments = new ArrayList<>();
	}
	
	/**
	 * Returns the {@link List} of sub-environments.
	 * 
	 * @return a {@link List} of {@link AbstractEnvironment} elements.
	 */
	public List<AbstractEnvironment<P>> getSubEnvironments() {
		return this.subEnvironments;
	}
	
	/**
	 * Adds an {@link AbstractEnvironment} to the {@link List} of sub-environments.
	 * 
	 * @param environment : the {@link AbstractEnvironment} to add to the {@link List} of sub-environments.
	 */
	public void addSubEnvironment(AbstractEnvironment<P> environment) {
		this.subEnvironments.add(environment);
	}
	
	@Override
	public Boolean isSimple() {
		return false;
	}
}