package uk.ac.rhul.cs.dice.gawl.interfaces.environment;

import uk.ac.rhul.cs.dice.gawl.interfaces.appearances.UniverseAppearance;
import uk.ac.rhul.cs.dice.gawl.interfaces.environment.physics.Physics;

/**
 * A subclass of {@link ComplexEnvironment} which is always bounded. Thus, the {@link #isBounded()} method will always return true.<br/><br/>
 * 
 * Known direct subclasses: none.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Ben Wilkins
 * @author Kostas Stathis
 *
 */
public class Universe extends ComplexEnvironment {

	/**
	 * The default class constructor.
	 * 
	 * @param state : an {@link Space} instance.
	 * @param physics : the {@link Physics} of the environment.
	 * @param appearance : the {@link UniverseAppearance} of the environment.
	 */
	public Universe(Space state, Physics physics, UniverseAppearance appearance) {
		super(state, physics, true, appearance);
	}
}