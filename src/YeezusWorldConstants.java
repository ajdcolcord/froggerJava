/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. FroggerWorldConstants
 *      2.1 MEASUREMENTS
 *      2.2 IMAGES
 *        2.2.1 - froggerBackgroundImage -- WorldImage
 *        2.2.2 - Frog Images            -- String
 *        2.2.3 - Car Images             -- String
 *        2.2.4 - Log Images             -- String
 *        2.2.5 - LilyPad Images         -- String
 *          
 */

///////////////////////////////////////////////////////////////////////////////
// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.*;





// 2 - FroggerWorldConstants //////////////////////////////////////////////////
/** Represents the constants of data that are used
 * throughout the Frogger Game
 * @author Nick Alekhine
 *
 */
public interface YeezusWorldConstants {

    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - MEASUREMENTS /////////////////////////////////////////////////////
    public int canvasHeight = 500; // height of canvas
    public int canvasWidth = 1000; // width of canvas
    public int canvasWidthMid = canvasWidth / 2; // midpoint of canvas width
    public int stripHeight = 50; // height of strips

    
    
    
    
    // 2.2 - IMAGES ///////////////////////////////////////////////////////////
    // 2.2.1 - froggerBackgroundImage /////////////////////////////////////////
    public WorldImage froggerBackgroundImage = 
            new FromFileImage(new Posn(500, 250), "scene.png");
    
    // 2.2.2 - Yeezus Images ///////////////////////////////////////////////////
    public String yeUp = "yeUp.png";
    public String yeDown = "yeDown.png";
    public String yeLeft = "yeLeft.png";
    public String yeRight = "yeRight.png";
    
    // 2.2.3 - Car Images /////////////////////////////////////////////////////
    public String carLeft = "carLeft.png";
    public String carRight = "carRight.png";
    
    // 2.2.4 - RickRoss Images /////////////////////////////////////////////////
    public String rickRossRight = "rickRossRight.png";
    public String rickRossLeft = "rickRossLeft.png";
    
    // 2.2.4 - LilyPad Images /////////////////////////////////////////////////
    public String macMiller = "macMiller.png";
    
}
