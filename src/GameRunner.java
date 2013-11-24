/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. GameRunner
 *     2.1 FIELDS
 *       2.1.1 player   -- Frog
 *       2.1.2 cars     -- ArrayList<Log>
 *       2.1.3 logs     -- ArrayList<Car>
 *       2.1.4 LilyPads -- ArrayList<LilyPad>
 *     2.2 CONSTRUCTORS
 *       2.2.1 GameRunner()
 *       2.2.2 GameRunner(Frog, ArrayList<Car>,
 *                        ArrayList<Log>, ArrayList<LilyPad>)
 *     2.3 METHODS
 *       2.3.1 onTick()                     -- void
 *         2.3.1.1 moveWhenOnLilyPadOrLog() -- void
 *         2.3.1.2 moveObjects()            -- void
 *       2.3.2 onKeyEvent(String)           -- void
 *       2.3.3 worldEnds()                  -- WorldEnd
 *       2.3.4 makeImage()                  -- WorldImage
 *       2.3.5 lastImage(String)            -- WorldImage
 * 
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import java.awt.Color;
import java.util.ArrayList;

import javalib.colors.Red;





import javalib.tunes.Note;
import javalib.worldimages.OverlayImagesXY;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;
import javalib.soundworld.World;

import java.awt.Color;
import java.util.Iterator;

import javalib.colors.Red;
import javalib.soundworld.World;
import javalib.tunes.Note;
import javalib.tunes.SoundConstants;
import javalib.tunes.TuneBucket;
import javalib.worldimages.CircleImage;
import javalib.worldimages.DiskImage;
import javalib.worldimages.FromFileImage;
import javalib.worldimages.LineImage;
import javalib.worldimages.OvalImage;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.TriangleImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;
import tester.Tester;




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
    Frog player;
    ArrayList<Car> cars;
    ArrayList<Log> logs;
    ArrayList<LilyPad> lilypads;





    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    // 2.2.1 //////////////////////////////////////////////////////////////////
    GameRunner() {
        this.player = new Frog();
        this.cars = new ArrayList<Car>();
        this.logs = new ArrayList<Log>();
        this.lilypads = new ArrayList<LilyPad>();
    }

    // 2.2.2 //////////////////////////////////////////////////////////////////
    GameRunner(Frog player, ArrayList<Car> cars, 
            ArrayList<Log> logs, ArrayList<LilyPad> lilypads) {
        this.player = player;
        this.cars = cars;
        this.logs = logs;
        this.lilypads = lilypads;
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - Methods //////////////////////////////////////////////////////////
    // 2.2.1 - onTick() ///////////////////////////////////////////////////////
    /** Move the player around the scene. Move logs, lilypads, and cars.
     * @author Nick Alekhine
     * 
     *  */
    public void onTick() {
        this.moveWhenOnLilyPadOrLog();
        this.moveObjects();
    }

    // 2.2.1.1 - moveWhenOnLilyPadOrLog() /////////////////////////////////////
    /** Move the player when on a lily pad or log
     * @author Nick Alekhine 
     * 
     * */
    public void moveWhenOnLilyPadOrLog() {
        boolean hasCollided = false; // conditional for when player collides

        // go through list of logs and see if player has collided with any
        for (Log l : this.logs) {
            // if player has collided with the log
            if (l.collide(this.player)) {
                this.player.move(l.facingLeft, l.speed);
                hasCollided = true;
            }
            // if player has collided
            else if (hasCollided) {
                break;
            }
        }

        // go through list of lilypads and see if player has collided with any
        for (LilyPad lp : this.lilypads) {
            // if player has collided with the lilypad
            if (lp.collide(this.player)) {
                this.player.move(lp.facingLeft, lp.speed);
                hasCollided = true;
            }
            // if player has collided
            else if (hasCollided) {
                break;
            }
        }
    }


    // 2.2.1.2 - moveObjects() ////////////////////////////////////////////////
    /** Move the list of cars, logs, and lilypads
     * @author Nick Alekhine
     * @author Austin Colcord
     * 
     *  */
    public void moveObjects() {
        // go through list of cars and move them 
        for (Car c : this.cars) {
            if (c.facingLeft) {
                c.moveObjectLeft();
            }
            else {
                c.moveObjectRight();
            }
        }

        // go through list of logs and move them
        for (Log l : this.logs) {
            if (l.facingLeft) {
                l.moveObjectLeft();
            }
            else {
                l.moveObjectRight();
            }
        }

        // go through list of lilypads and move them
        for (LilyPad lp : this.lilypads) {
            if (lp.facingLeft) {
                lp.moveObjectLeft();
            }
            else {
                lp.moveObjectRight();
            }
        }
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.2 - onKeyEvent(String) /////////////////////////////////////////////
    /** Change the direction of the player.
     * @author Nick Alekhine
     * 
     *  */
    public void onKeyEvent(String ke){
        if (ke.equals("up")) {
            System.out.println("up " + this.player.posn.y);
            this.player.moveFrogUp();
            System.out.println("up2 " + this.player.posn.y);
        }
        else if (ke.equals("down")) {
            System.out.println("down");
            this.player.moveFrogDown();
        }
        else if (ke.equals("left")) {
            System.out.println("left");
            this.player.moveFrogLeft();
        }
        else if (ke.equals("right")) {
            System.out.println("right");
            this.player.moveFrogRight();
        }
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.3 - worldEnds() ////////////////////////////////////////////////////
    /** To end the game if a collision occurs. 
     * @return WorldEnd
     * @author Nick Alekhine
     * 
     *  */
    public WorldEnd worldEnds() {
        return new WorldEnd(false, this.makeImage());
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.4 - makeImage() ////////////////////////////////////////////////////
    /** To draw the world onto the scene.
     * @return WorldImage 
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage makeImage() {
        WorldImage stack = new OverlayImages(froggerBackgroundImage,
                                             this.player.makeImage());


        for (Car c : this.cars) {
            stack = stack.overlayImages(c.image);
        }

        for (Log l : this.logs) {
            stack = stack.overlayImages(l.image);
        }

        for (LilyPad lp : this.lilypads) {
            stack = stack.overlayImages(lp.image);
        }

        return stack;
    }
    
    
    public WorldImage onDraw() {
        return this.makeImage();
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.5 - lastImage(String) //////////////////////////////////////////////
    /** To draw the win / lose message at the end of the game. 
     * @return WorldImage
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage lastImage(String s) {
        return this.makeImage().overlayImages(
                new TextImage(new Posn(150, 80), s, 
                        15, 3, new Red()));
    }





    ///////////////////////////////////////////////////////////////////////////
    // support for the regression tests
    public static ExamplesFrogger examplesInstance = 
            new ExamplesFrogger();
}
