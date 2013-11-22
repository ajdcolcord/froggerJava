/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. FroggerWorldConstants
 *      2.1 MEASUREMENTS
 *          2.1.1 canvasWidth   -- int
 *          2.1.2 canvasHeight  -- int
 *      2.2 COLORS
 *          2.2.1 grassColor    -- Color
 *          2.2.2 waterColor    -- Color
 *          2.2.3 roadColor     -- Color
 *          2.2.4 groundColor   -- Color
 *      2.3 SIMPLE IMAGES
 *          2.3.1 grassImageMiddle  -- WorldImage
 *          2.3.2 grassImageTop     -- WorldImage
 *          2.3.3 groundImage       -- WorldImage
 *          2.3.4 waterImageTop     -- WorldImage
 *          2.3.5 waterImageMiddle  -- WorldImage
 *          2.3.6 waterImageBottom  -- WorldImage
 *          2.3.7 roadImageTop1     -- WorldImage
 *          2.3.8 roadImageTop2     -- WorldImage
 *          2.3.9 roadImageBottom1  -- WorldImage
 *          2.3.10 roadImageBottom2 -- WorldImage
 *      2.4 BACKGROUND IMAGE
 *          2.4.1 froggerWaterImage         -- WorldImage
 *          2.4.2 froggerRoadImage          -- WorldImage
 *          2.4.3 froggerBackgroundImage    -- WorldImage
 *          
 */

// 1. Libraries ////////////////////////////////////////////////////////////
import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import java.awt.Color;

////////////////////////////////////////////////////////////////////////////



//2. FroggerWorldConstants /////////////////////////////////////////////////
/** Represents the constants of data that are used
 * throughout the Frogger Game
 * @author Austin Colcord
 *
 */
public interface FroggerWorldConstants {

    // 2.1.1 ////////////////////////////////////////////////////
    /** the width of the world */
    public int canvasWidth = 500;

    // 2.1.2 ////////////////////////////////////////////////////
    /** the height of the world */
    public int canvasHeight = 1000;

    // 2.2.1 ////////////////////////////////////////////////////
    /** the color of the grass */
    public Color grassColor = new Color(31, 156, 6);

    // 2.2.2 ////////////////////////////////////////////////////
    /** the color of the water */
    public Color waterColor = new Color(8, 42, 196);

    // 2.2.3 ////////////////////////////////////////////////////
    /** the color of the road */
    public Color roadColor = new Color(0, 0, 0);

    // 2.2.4 ////////////////////////////////////////////////////
    /** the color of the ground */
    public Color groundColor = new Color(107, 48, 5);

    // 2.3.1 ////////////////////////////////////////////////////
    /** the rectangle for the grass on the middle portion */
    public WorldImage grassImageMiddle = 
            new RectangleImage(
                    new Posn((canvasWidth / 2),
                            (canvasHeight * (11 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            grassColor);

    // 2.3.2 ////////////////////////////////////////////////////
    /** the rectangle for the grass on the top portion */
    public WorldImage grassImageTop = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (19 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            grassColor);

    // 2.3.3 ////////////////////////////////////////////////////
    /** the rectangle for the ground on the bottom portion */
    public WorldImage groundImage = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (1 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            groundColor);

    // 2.3.4 ////////////////////////////////////////////////////
    /** the rectangle for the water top row */
    public WorldImage waterImageTop = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (17 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            waterColor);

    // 2.3.5 ////////////////////////////////////////////////////
    /** the rectangle for the water top row */
    public WorldImage waterImageMiddle = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (15 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            waterColor);

    // 2.3.6 ////////////////////////////////////////////////////
    /** the rectangle for the water top row */
    public WorldImage waterImageBottom = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (13 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            waterColor);

    // 2.3.7 ////////////////////////////////////////////////////
    /** the rectangle for the road top row */
    public WorldImage roadImageTop1 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (9 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);

    // 2.3.8 ////////////////////////////////////////////////////
    /** the rectangle for the road second to top row */
    public WorldImage roadImageTop2 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (7 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);

    // 2.3.9 ////////////////////////////////////////////////////
    /** the rectangle for the road first bottom row */
    public WorldImage roadImageBottom1 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (5 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);

    // 2.3.10 ////////////////////////////////////////////////////
    /** the rectangle for the road bottom row */
    public WorldImage roadImageBottom2 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (3 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);

    // 2.4.1 ////////////////////////////////////////////////////
    /** the water background of the world that includes the water */
    public WorldImage froggerWaterImage = 
            new OverlayImages(waterImageTop,
                    new OverlayImages(waterImageMiddle, waterImageBottom));

    // 2.4.2 ////////////////////////////////////////////////////
    /** the road background of the world that includes the road */
    public WorldImage froggerRoadImage = 
            new OverlayImages(roadImageTop1,
                    new OverlayImages(roadImageTop2,
                            new OverlayImages(roadImageBottom1,
                                    roadImageBottom2)));

    // 2.4.3 ////////////////////////////////////////////////////
    /** the complete background for the game, that includes the grass,
     * ground, water, and road sections
     */
    public WorldImage froggerBackgroundImage =
            new OverlayImages(grassImageTop,
                    new OverlayImages(froggerWaterImage,
                            new OverlayImages(grassImageMiddle,
                                    new OverlayImages(froggerRoadImage,
                                            groundImage))));



}
