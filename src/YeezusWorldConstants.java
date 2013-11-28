/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. YeezusWorldConstants
 *      2.1 MEASUREMENTS
 *      2.2 IMAGES
 *        2.2.1 - BackgroundImage        -- WorldImage
 *        2.2.2 - Yeezus Images          -- String
 *        2.2.3 - Car Images             -- String
 *        2.2.4 - RickRoss Images        -- String
 *        2.2.5 - MacMiller Images       -- String
 *          
 */

///////////////////////////////////////////////////////////////////////////////
// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.*;





// 2 - YeezusWorldConstants ///////////////////////////////////////////////////
/** Represents the constants of data that are used throughout the game
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

    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - IMAGES ///////////////////////////////////////////////////////////
    
    // 2.2.1 - BackgroundImage /////////////////////////////////////////
    public WorldImage backgroundImage = 
            new FromFileImage(new Posn(500, 250), "scene.png");
    
    // 2.2.2 - Yeezus Images //////////////////////////////////////////////////
    public String yeUp = "yeUp.png";
    public String yeDown = "yeDown.png";
    public String yeLeft = "yeLeft.png";
    public String yeRight = "yeRight.png";
    
    // 2.2.3 - Car Images /////////////////////////////////////////////////////
    public String carLeft = "carLeft.png";
    public String carRight = "carRight.png";
    
    // 2.2.4 - RickRoss Images ////////////////////////////////////////////////
    public String rickRossRight = "rickRossRight.png";
    public String rickRossLeft = "rickRossLeft.png";
    
    // 2.2.4 - MacMiller Images ///////////////////////////////////////////////
    public String macMiller = "macMiller.png";
    
}
