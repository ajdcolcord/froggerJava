/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. GameRunner
 *     2.1 FIELDS
 *       2.1.1 player   -- Frog
 *       2.1.2 cars     -- ArrayList<Log>
 *       2.1.3 logs     -- ArrayList<Car>
 *       2.1.4 LilyPads -- ArrayList<LilyPad>
 *     2.2 METHODS
 *       2.2.1 onTick()                     -- void
 *         2.2.1.1 moveWhenOnLilyPadOrLog() -- void
 *         2.2.1.2 moveObjects()            -- void
 *       2.2.2 onKeyEvent(String)           -- void
 *       2.2.3 worldEnds()                  -- WorldEnd
 *       2.2.4 makeImage()                  -- WorldImage
 *       2.2.5 lastImage(String)            -- WorldImage
 * 
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import java.awt.Color;
import java.util.ArrayList;

import javalib.colors.Red;
import javalib.tunes.Note;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
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
    Frog player = new Frog();
    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<Log> logs = new ArrayList<Log>();
    ArrayList<LilyPad> lilypads = new ArrayList<LilyPad>();


    //    GameRunner(Frog player, ArrayList<Car> cars, 
    //               ArrayList<Log> logs, ArrayList<LilyPad> lilypads) {
    //        this.player = player;
    //        this.cars = cars;
    //        this.logs = logs;
    //        this.lilypads = lilypads;
    //    }

    GameRunner() {
        this.player = new Frog();
        this.cars = new ArrayList<Car>();
        this.logs = new ArrayList<Log>();
        this.lilypads = new ArrayList<LilyPad>();
    }


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
                c.moveLeft();
            }
            else {
                c.moveRight();
            }
        }

        // go through list of logs and move them
        for (Log l : this.logs) {
            if (l.facingLeft) {
                l.moveLeft();
            }
            else {
                l.moveRight();
            }
        }

        // go through list of lilypads and move them
        for (LilyPad lp : this.lilypads) {
            if (lp.facingLeft) {
                lp.moveLeft();
            }
            else {
                lp.moveRight();
            }
        }
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
        return new WorldEnd(false, this.makeImage());
    }


    // 2.2.4 - makeImage() ////////////////////////////////////////////////////
    /** To draw the world onto the scene.
     * @return WorldImage 
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage makeImage() {
        WorldImage stack = player.image.overlayImages(froggerBackgroundImage);

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


    // support for the regression tests
    public static ExamplesFrogger examplesInstance = 
            new ExamplesFrogger();
}
