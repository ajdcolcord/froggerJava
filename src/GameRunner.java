/** the class that runs the Yeezus Game
 * 
 * @author Austin
 * @author Nick Alekhine
 *
 */
public class GameRunner {

    /** An instance of the <code>Examples</code> class that defines
     * the initial world
     */
    ExamplesYeezusWorld ey = new ExamplesYeezusWorld();

    /** the initial world that invokes the <code>bigBang</code> method */
    YeezusWorld yw = this.ey.initYeezusWorld();

    
    
    
    /**  Method that runs the game
     */
    void run() {
        this.yw.bigBang(1000, 500, 0.075);
    }

    /** Main method to run the game
     * @param argv unused
     */
    public static void main(String[] argv) {
        GameRunner gm = new GameRunner();
        (new BackgroundMusic()).start();
        gm.run();
    }





    ///////////////////////////////////////////////////////////////////////////
    // support for the regression tests
    public static ExamplesYeezusWorld examplesInstance = 
            new ExamplesYeezusWorld();
}
