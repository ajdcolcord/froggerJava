/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. GameRunner
 *     2.1 FIELDS
 *       2.1.1 N/A
 *     2.2 METHODS
 *       2.2.1 onTick()             -- void
 *       2.2.2 onKeyEvent(String)   -- void
 *       2.2.3 worldEnds()          -- WorldEnd
 *       2.2.4 makeImage()          -- WorldImage
 *       2.2.5 lastImage(String)    -- WorldImage
 * 
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import java.awt.Color;
import javalib.colors.Red;
import javalib.tunes.Note;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;





// 2 - GamerRunner ////////////////////////////////////////////////////////////
/** the class that runs the Frogger Game
 * 
 * @author Austin
 * @author Nick Alekhine
 *
 */
public class GameRunner {

    GameRunner() {}


    // 2.2.1 - onTick() ///////////////////////////////////////////////////////
    /** Move the player around the scene. Move logs, lilypads, and cars.
     * @author Nick Alekhine
     * 
     *  */
    public void onTick() {

    }


    // 2.2.2 - onKeyEvent(String) /////////////////////////////////////////////
    /** Change the direction of the player.
     * @author Nick Alekhine
     * 
     *  */
    public void onKeyEvent(String ke){

    }

    
    // 2.2.3 - worldEnds() ////////////////////////////////////////////////////
    /** To end the game if a collision occurs. 
     * @return WorldEnd
     * @author Nick Alekhine
     * 
     *  */
    public WorldEnd worldEnds() {
        return null;
    }

    
    // 2.2.4 - makeImage() ////////////////////////////////////////////////////
    /** To draw the world onto the scene.
     * @return WorldImage 
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage makeImage() {
        return null;
    }

    
    // 2.2.6 - lastImage(String) //////////////////////////////////////////////
    /** To draw the win / lose message at the end of the game. 
     * @return WorldImage
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage lastImage(String s) {
        return null;
    }
}
