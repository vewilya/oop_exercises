package ch.hslu.oop.SW04.Switchable;

/**
 * The <code>MusicPlayer</code> represents a music player that can be switched
 * on and off, and can play, stop, and switch between tracks.
 * This class implements the Playable and Switchable interfaces.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW04.Switchable.Engine
 * @see ch.hslu.oop.SW04.Switchable.Car
 * @see ch.hslu.oop.SW04.Switchable.Lights
 */
public final class MusicPlayer implements Playable, Switchable {

    /**
     * The main method creates a new MusicPlayer object and tests its functionality.
     * 
     * @param args the command line arguments
     */
    // public static void main(String[] args) {
    // MusicPlayer mPlayer = new MusicPlayer();

    // System.out.println(mPlayer.getCurrentTrack());

    // for (int i = 0; i < 15; i++) {
    // mPlayer.previousTrack();
    // System.out.println(mPlayer.getCurrentTrack());
    // }
    // }

    // ------------------------------ MusicPlayer ------------------------------

    /**
     * Constructs a new MusicPlayer object with the default state of being switched
     * off and not playing.
     */
    public MusicPlayer() {
        this.isMusicPlayerSwitchedOn = false;
        this.isPlaying = false;
    }

    // ------------------------------ Switchable ------------------------------

    /**
     * Switches the music player on.
     */
    @Override
    public void switchOn() {
        this.isMusicPlayerSwitchedOn = true;
    }

    /**
     * Switches the music player off.
     */
    @Override
    public void switchOff() {
        this.isMusicPlayerSwitchedOn = false;
    };

    /**
     * Returns true if the music player is switched on, false otherwise.
     * 
     * @return true if the music player is switched on, false otherwise
     */
    @Override
    public boolean isSwitchedOn() {
        return this.isMusicPlayerSwitchedOn;
    };

    /**
     * Returns true if the music player is switched off, false otherwise.
     * 
     * @return true if the music player is switched off, false otherwise
     */
    @Override
    public boolean isSwitchedOff() {
        return !this.isMusicPlayerSwitchedOn;
    };

    // ------------------------------ Playable ------------------------------

    /**
     * Starts playing the current track.
     */
    @Override
    public void play() {
        this.isPlaying = true;
    };

    /**
     * Stops playing the current track.
     */
    @Override
    public void stop() {
        this.isPlaying = false;
    };

    /**
     * Switches to the next track.
     */
    @Override
    public void nextTrack() {
        this.currentTrack += 1;
        this.currentTrack %= TOTOAL_NUMBER_TRACKS;
    };

    /**
     * Switches to the previous track.
     * If the current track is the first track, it switches to the last track.
     */
    @Override
    public void previousTrack() {
        this.currentTrack -= 1;

        if (this.currentTrack <= 0)
            this.currentTrack = TOTOAL_NUMBER_TRACKS;

    };

    /**
     * Returns the current track number.
     * 
     * @return the current track number
     */
    public int getCurrentTrack() {
        return this.currentTrack;
    }

    /**
     * Returns true if the music player is currently playing, false otherwise.
     * 
     * @return true if the music player is currently playing, false otherwise
     */
    @Override
    public boolean isPlaying() {
        return this.isPlaying;
    };

    /**
     * Returns true if the music player is currently stopped, false otherwise.
     * 
     * @return true if the music player is currently stopped, false otherwise
     */
    @Override
    public boolean isStopped() {
        return !this.isPlaying;
    };

    // ------------------------------ Private ------------------------------
    private boolean isMusicPlayerSwitchedOn;
    private boolean isPlaying;

    private int currentTrack = 0;
    private int TOTOAL_NUMBER_TRACKS = 10;

}
