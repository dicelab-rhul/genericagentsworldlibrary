package uk.ac.rhul.cs.dice.gawl.interfaces.actions;

import uk.ac.rhul.cs.dice.gawl.interfaces.entities.Actor;

/**
 * The interface for all the actions.<br/>
 * <br/>
 * 
 * Known implementations: {@link AbstractAction}.
 * 
 * @author cloudstrife9999 a.k.a. Emanuele Uliana
 * @author Ben Wilkins
 * @author Kostas Stathis
 *
 */
public interface Action {
    
    /**
     * Returns the {@link Actor}.
     * 
     * @return the {@link Actor}.
     */
    public abstract Actor getActor();
    
    /**
     * Sets the {@link Actor}.
     * 
     * @param actor: the {@link Actor} to be set.
     */
    public abstract void setActor(Actor actor);
}