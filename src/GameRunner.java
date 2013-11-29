/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. GameRunner
 *     2.1 FIELDS
 *       2.1.1 fw -- FroggerWorld
 *     2.2 CONSTRUCTORS
 *       2.2.1 GameRunner()
 *       2.2.2 GameRunner(FroggerWorld)
 *     2.3 METHODS
 *       2.3.1 onTick()                     -- void
 *       2.3.2 onKeyEvent(String)           -- void
 *       2.3.3 worldEnds()                  -- WorldEnd
 *       2.3.4 makeImage()                  -- WorldImage
 *       2.3.5 lastImage(String)            -- WorldImage
 * 
 *****************************************************************************/








// 2 - GamerRunner ////////////////////////////////////////////////////////////
/** the class that runs the Yeezus Game
 * 
 * @author Austin
 * @author Nick Alekhine
 *
 */
public class GameRunner {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    YeezusWorld fw;





    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    // 2.2.1 //////////////////////////////////////////////////////////////////
    GameRunner() {
        this.fw = new YeezusWorld();
    }

    // 2.2.2 //////////////////////////////////////////////////////////////////
    GameRunner(YeezusWorld fw) {
        this.fw = fw;
    }



    /** An instance of the <code>Examples</code> class that defines
     * the initial world
     */
    ExamplesYeezus ey = new ExamplesYeezus();

    /** the initial world that invokes the <code>bigBang</code> method */
    YeezusWorld yw = this.ey.initYeezusWorld();

    /** 
     * Method that runs the game
     */
    void run() {
        this.yw.bigBang(1000, 500, 0.075);
    }

    /**
     * Main method to run the game
     * @param argv unused
     */
    public static void main(String[] argv) {
        GameRunner gm = new GameRunner();
        gm.run();
    }





    ///////////////////////////////////////////////////////////////////////////
    // support for the regression tests
    public static ExamplesYeezus examplesInstance = 
            new ExamplesYeezus();
}
