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





// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;
import javalib.soundworld.World;





// 2 - GamerRunner ////////////////////////////////////////////////////////////
/** the class that runs the Frogger Game
 * 
 * @author Austin
 * @author Nick Alekhine
 *
 */
public class GameRunner extends World implements FroggerWorldConstants {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    FroggerWorld fw;





    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    // 2.2.1 //////////////////////////////////////////////////////////////////
    GameRunner() {
        this.fw = new FroggerWorld();
    }

    // 2.2.2 //////////////////////////////////////////////////////////////////
    GameRunner(FroggerWorld fw) {
        this.fw = fw;
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - Methods //////////////////////////////////////////////////////////
    // 2.2.1 - onTick() ///////////////////////////////////////////////////////
    /** Move the player around the scene. Move logs, lilypads, and cars.
     * @author Nick Alekhine
     * 
     *  */
    public void onTick() {
        this.fw.ticker();
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.2 - onKeyEvent(String) /////////////////////////////////////////////
    /** Change the direction of the player.
     * @author Nick Alekhine
     * 
     *  */
    public void onKeyEvent(String ke){
        this.fw.keyEventer(ke);
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.3 - worldEnds() ////////////////////////////////////////////////////
    /** To end the game if a collision occurs. 
     * @return WorldEnd
     * @author Nick Alekhine
     * 
     *  */
    public WorldEnd worldEnds() {
        return this.fw.worldEnder();
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.4 - makeImage() ////////////////////////////////////////////////////
    /** To draw the world onto the scene.
     * @return WorldImage 
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage makeImage() {
        return this.fw.render();
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.5 - lastImage(String) //////////////////////////////////////////////
    /** To draw the win / lose message at the end of the game. 
     * @return WorldImage
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage lastImage(String s) {
        return this.fw.renderLast(s);
    }





    ///////////////////////////////////////////////////////////////////////////
    // support for the regression tests
    public static ExamplesFrogger examplesInstance = 
            new ExamplesFrogger();
}
