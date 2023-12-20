package ch.hslu.oop.SW05.Switchable;

/**
 * The <code>Playable</code> interface represents a playable component.
 * <p>
 * It provides methods to play and stop the component as well as methods to
 * check the current state of the player component.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Switchable
 *
 */
public interface Playable {
    /**
     * A method to play the component.
     */
    void play();

    /**
     * A method to stop the component.
     */
    void stop();

    /**
     * A method to play the next track.
     */
    void nextTrack();

    /**
     * A method to play the previous track.
     */
    void previousTrack();

    /**
     * Returns the playing state of the component.
     * * @return true if component is playing.
     */
    boolean isPlaying();

    /**
     * Returns the stopped state of the component.
     * 
     * @return true if component is stopped.
     */
    boolean isStopped();

}
