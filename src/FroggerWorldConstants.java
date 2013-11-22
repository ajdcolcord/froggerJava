import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import java.awt.Color;

/** Represents the constants of data that are used
 * throughout the Frogger Game
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public interface FroggerWorldConstants {
    
    /** the width of the world */
    public int canvasWidth = 500;
    
    /** the height of the world */
    public int canvasHeight = 1000;
    
    /** the color of the grass */
    public Color grassColor = new Color(31, 156, 6);
    
    /** the color of the water */
    public Color waterColor = new Color(8, 42, 196);
    
    /** the color of the road */
    public Color roadColor = new Color(0, 0, 0);
    
    /** the color of the road lines */
    public Color lineColor = new Color(219, 219, 219);
    
    /** the color of the ground */
    public Color groundColor = new Color(107, 48, 5);

    /** the rectangle for the grass on the middle portion */
    public WorldImage grassImageMiddle = 
            new RectangleImage(
                    new Posn((canvasWidth / 2),
                            (canvasHeight * (11 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            grassColor);

    /** the rectangle for the grass on the top portion */
    public WorldImage grassImageTop = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (19 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            grassColor);
    
    /** the rectangle for the ground on the bottom portion */
    public WorldImage groundImage = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (1 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            groundColor);
    
    /** the rectangle for the water top row */
    public WorldImage waterImageTop = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (17 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            waterColor);
    
    /** the rectangle for the water top row */
    public WorldImage waterImageMiddle = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (15 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            waterColor);
    
    /** the rectangle for the water top row */
    public WorldImage waterImageBottom = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (13 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            waterColor);
    
    /** the rectangle for the road top row */
    public WorldImage roadImageTop1 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (9 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);
    
    /** the rectangle for the road second to top row */
    public WorldImage roadImageTop2 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (7 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);
    
    /** the rectangle for the road first bottom row */
    public WorldImage roadImageBottom1 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (5 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);
    
    /** the rectangle for the road bottom row */
    public WorldImage roadImageBottom2 = 
            new RectangleImage(
                    new Posn((canvasWidth / 2), 
                            (canvasHeight * (3 / 20))),
                            canvasWidth, 
                            (canvasHeight / 10),
                            roadColor);
    

    /** the water background of the world that includes the water */
    public WorldImage froggerWaterImage = 
            new OverlayImages(waterImageTop,
                    new OverlayImages(waterImageMiddle, waterImageBottom));
    
    /** the road background of the world that includes the road */
    public WorldImage froggerRoadImage = 
            new OverlayImages(roadImageTop1,
                    new OverlayImages(roadImageTop2,
                            new OverlayImages(roadImageBottom1,
                                    roadImageBottom2)));
    
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
