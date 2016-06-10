package uk.ac.rhul.cs.dice.gawl.interfaces.environment;

import java.util.Set;

import uk.ac.rhul.cs.dice.gawl.interfaces.actions.Action;
import uk.ac.rhul.cs.dice.gawl.interfaces.common.Appearance;
import uk.ac.rhul.cs.dice.gawl.interfaces.entities.Body;
import uk.ac.rhul.cs.dice.gawl.interfaces.environment.physics.Physics;

/**
 * A subclass of {@link ComplexEnvironment} which is always bounded. Thus, the {@link #isBounded()} method will always return true.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Kostas Stathis
 *
 */
public class Universe extends ComplexEnvironment {

	public Universe(EnvironmentalSpace state, Set<Action> admissibleActions, Set<Body> bodies, Physics physics, boolean bounded, Appearance appearance) {
		super(state, admissibleActions, bodies, physics, bounded, appearance);
	}
	
	@Override
	public boolean isBounded() {
		return true;
	}
}