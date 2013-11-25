/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. FroggerWorldConstants
 *      2.1 MEASUREMENTS
 *      2.2 COLORS
 *      2.3 SIMPLE IMAGES
 *          2.3.1 - Grass Images           -- WorldImage
 *          2.3.2 - Water Images           -- WorldImage
 *          2.3.3 - Road Images            -- WorldImage
 *          2.3.4 - froggerBackgroundImage -- WorldImage
 *          
 */

///////////////////////////////////////////////////////////////////////////////
// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import java.awt.Color;





// 2 - FroggerWorldConstants //////////////////////////////////////////////////
/** Represents the constants of data that are used
 * throughout the Frogger Game
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public interface FroggerWorldConstants {

    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - MEASUREMENTS /////////////////////////////////////////////////////
    public int canvasHeight = 500; // height of canvas
    public int canvasWidth = 1000; // width of canvas
    public int canvasWidthMid = canvasWidth / 2; // midpoint of canvas width
    public int stripHeight = 50; // height of strips

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - COLORS ///////////////////////////////////////////////////////////
    public Color grassColor = new Color(31, 156, 6);
    public Color waterColor = new Color(8, 42, 196);
    public Color roadColor = new Color(0, 0, 0);
    public Color groundColor = new Color(107, 48, 5);

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - SIMPLE IMAGES ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    // 2.3.1 - Grass Images ///////////////////////////////////////////////////
    /** the rectangle for the grass on the middle portion */
    public WorldImage grassImageMiddle = 
            new RectangleImage(new Posn(canvasWidthMid, 225),
                               canvasWidth, 
                               stripHeight,
                               grassColor);

    public WorldImage grassImageTop = 
            new RectangleImage(new Posn(canvasWidthMid, 25),
                               canvasWidth, 
                               stripHeight,
                               grassColor);

    public WorldImage grassImageBottom = 
            new RectangleImage(new Posn(canvasWidthMid, 475), 
                               canvasWidth, 
                               stripHeight, 
                               groundColor);
    
    
   /** The grass on the scene */
    public WorldImage grassAggregate = 
            new OverlayImages(grassImageBottom,
            new OverlayImages(grassImageMiddle,
                              grassImageTop));
    
    
    
    
    
    
    
    
    
    
    // 2.3.2 - Water Images ///////////////////////////////////////////////////
    public WorldImage waterImageTop = 
            new RectangleImage(new Posn(canvasWidthMid, 75),
                               canvasWidth, 
                               (canvasHeight / 10),
                               waterColor);

    public WorldImage waterImageMiddle = 
            new RectangleImage(new Posn(canvasWidthMid, 125),
                               canvasWidth, 
                               stripHeight,
                               waterColor);

    public WorldImage waterImageBottom = 
            new RectangleImage(new Posn(canvasWidthMid, 175),
                               canvasWidth, 
                               (canvasHeight / 10),
                               waterColor);
    
    
    /** The water on the scene */
    public WorldImage waterAggregate = 
            new OverlayImages(waterImageBottom,
            new OverlayImages(waterImageMiddle,
                              waterImageTop));
    
    
    
    
    
    
    
    
    
    

    // 2.3.3 - Road Images ////////////////////////////////////////////////////
    public WorldImage roadImageTop1 = 
            new RectangleImage(new Posn(canvasWidthMid, 275),
                               canvasWidth, 
                               stripHeight,
                               roadColor);

    public WorldImage roadImageTop2 = 
            new RectangleImage(new Posn(canvasWidthMid, 325),
                               canvasWidth, 
                               stripHeight,
                               roadColor);

    public WorldImage roadImageBottom1 = 
            new RectangleImage(new Posn(canvasWidthMid, 375),
                               canvasWidth, 
                               stripHeight,
                               roadColor);

    public WorldImage roadImageBottom2 = 
            new RectangleImage(new Posn(canvasWidthMid, 425),
                               canvasWidth, 
                               stripHeight,
                               roadColor);
    
    
    /** The road on the scene */
    public WorldImage roadAggregate = 
            new OverlayImages(roadImageTop1,
            new OverlayImages(roadImageTop2,
            new OverlayImages(roadImageBottom1,
                              roadImageBottom2)));

    
    
    
    
    

    
    

    // 2.4.3 - froggerBackgroundImage /////////////////////////////////////////
    /** the background scene */
    public WorldImage froggerBackgroundImage =
            new OverlayImages(grassAggregate, 
            new OverlayImages(waterAggregate,
                              roadAggregate));
    
}
