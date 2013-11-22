/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. GameRunner
 *     2.1 FIELDS
 *       2.1.1 N/A
 *     2.2 METHODS
 *       2.2.1 onTick()             -- void
 *       2.2.2 onKeyEvent(String)   -- void
 *       2.2.3 onMouseClicked(Posn) -- void
 *       2.2.4 worldEnds()          -- WorldEnd
 *       2.2.5 makeImage()          -- WorldImage
 *       2.2.6 lastImage(String)    -- WorldImage
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
    /** TBD
     * @author Nick Alekhine
     * 
     *  */
    public void onKeyEvent(String ke){

    }

    
    // 2.2.3 - onMouseClicked(Posn) ///////////////////////////////////////////
    /** TBD
     * @author Nick Alekhine
     * 
     *  */
    public void onMouseClicked(Posn p) {

    }

    
    // 2.2.4 - worldEnds() ////////////////////////////////////////////////////
    /** TBD
     * @author Nick Alekhine
     * 
     *  */
    public WorldEnd worldEnds() {
        return null;
    }

    
    // 2.2.5 - makeImage() ////////////////////////////////////////////////////
    /** TBD
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage makeImage() {
        return null;
    }

    
    // 2.2.6 - lastImage(String) //////////////////////////////////////////////
    /** TBD
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage lastImage(String s) {
        return null;
    }
}
