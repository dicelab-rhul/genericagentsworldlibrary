package uk.ac.rhul.cs.dice.gawl.interfaces.appearances;

import java.util.Map;

import uk.ac.rhul.cs.dice.gawl.interfaces.environment.SpaceCoordinates;
import uk.ac.rhul.cs.dice.gawl.interfaces.environment.Universe;

/**
 * The appearance of a {@link Universe}, subclass of {@link ComplexEnvironmentAppearance}.
 * It contains a pair of {@link Double} bounds for every {@link SpaceCoordinates} type.<br/><br/>
 * 
 * Known direct subclasses: none.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Ben Wilkins
 * @author Kostas Stathis
 *
 */
public abstract class UniverseAppearance extends ComplexEnvironmentAppearance {
	private Map<SpaceCoordinates, Double[]> bounds;
	
	/**
	 * Constructor with a {@link String} name and a {@link Map} with a pair of {@link Double} bounds for
	 * every {@link SpaceCoordinates} instance in the {@link Universe}.
	 * 
	 * @param name : the {@link String} name of the {@link Universe}.
	 * @param bounds : the {@link Map} from {@link SpaceCoordinates} to {@link Double} array.
	 */
	public UniverseAppearance(String name, Map<SpaceCoordinates, Double[]> bounds) {
		super(name);
		this.bounds = bounds;
	}

	/**
	 * Returns the bounds of the {@link Universe}.
	 * 
	 * @return a {@link Map} with a pair of {@link Double} bounds for
	 * every {@link SpaceCoordinates} instance in the {@link Universe}.
	 */
	public Map<SpaceCoordinates, Double[]> getBounds() {
		return this.bounds;
	}
	
	/**
	 * Returns the bounds for a particular {@link SpaceCoordinates} instance.
	 * 
	 * @param coord : the {@link SpaceCoordinates} instance which is the key for the bounds {@link Map}.
	 * @return the bounds for a particular {@link SpaceCoordinates} instance.
	 */
	public Double[] getBounds(SpaceCoordinates coord) {
		return this.bounds.get(coord);
	}
}