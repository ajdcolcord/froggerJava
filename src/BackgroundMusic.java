/** A thread that calls the background music for the game.
 * @author Nick Alekhine 
 * 
 * */
public class BackgroundMusic extends Thread {
    MakeSound sounder = new MakeSound();

    /** To play Power by Kanye West
     * @author Nick Alekhine
     * 
     *  */
    public void run() {
        this.sounder.playSound("power.wav");
    }
}
