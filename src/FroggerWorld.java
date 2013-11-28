/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. FroggerWorld
 *     2.1 FIELDS
 *       2.1.1 player   -- Frog
 *       2.1.2 cars     -- ArrayList<Log>
 *       2.1.3 logs     -- ArrayList<Car>
 *       2.1.4 LilyPads -- ArrayList<LilyPad>
 *     2.2 CONSTRUCTORS
 *       2.2.1 FroggerWorld()
 *       2.2.2 FroggerWorld(Frog, ArrayList<Car>,
 *                          ArrayList<Log>, ArrayList<LilyPad>)
 *     2.3 METHODS
 *       2.3.1 ticker()                     -- void
 *         2.3.1.1 moveWhenOnLilyPadOrLog() -- void
 *         2.3.1.2 moveObjects()            -- void
 *       2.3.2 keyEventer(String)           -- void
 *       2.3.3 worldEnder()                  -- WorldEnd
 *       2.3.4 render()                  -- WorldImage
 *       2.3.5 renderLast(String)            -- WorldImage
 * 
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import java.util.ArrayList;

import javalib.colors.Red;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;





// 2 - FroggerWorld ///////////////////////////////////////////////////////////
/** The world state. Consists of a frog, cars, logs, and lilypads. 
 * @author Austin Colcord
 * @author Nick Alekhine 
 * 
 * */
public class FroggerWorld implements FroggerWorldConstants {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    Yeezus player;
    ArrayList<Car> cars;
    ArrayList<Log> logs;
    ArrayList<LilyPad> lilypads;
    MakeSound sounder = new MakeSound(); 




    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    // 2.2.1 //////////////////////////////////////////////////////////////////
    FroggerWorld() {
        this.player = new Yeezus();
        this.cars = new ArrayList<Car>();
        this.logs = new ArrayList<Log>();
        this.lilypads = new ArrayList<LilyPad>();
    }

    // 2.2.2 //////////////////////////////////////////////////////////////////
    FroggerWorld(Yeezus player, ArrayList<Car> cars, 
            ArrayList<Log> logs, ArrayList<LilyPad> lilypads) {
        this.player = player;
        this.cars = cars;
        this.logs = logs;
        this.lilypads = lilypads;
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - Methods //////////////////////////////////////////////////////////
    // 2.2.1 - ticker() ///////////////////////////////////////////////////////
    /** Move the player around the scene. Move logs, lilypads, and cars.
     * @author Nick Alekhine
     * 
     *  */
    public void ticker() {
        this.moveWhenOnLilyPadOrLog();
        this.moveObjects();
    }

    // 2.2.1.1 - moveWhenOnLilyPadOrLog() /////////////////////////////////////
    /** Move the player when on a lily pad or log
     * @author Nick Alekhine 
     * 
     * */
    public void moveWhenOnLilyPadOrLog() {

        // go through list of logs and see if player has collided with any
        for (Log l : this.logs) {
            // if player has collided with the log
            if (l.collide(this.player)) {
                this.player.move(l.facingLeft, l.speed);
                break;
            }
        }

        // go through list of lilypads and see if player has collided with any
        for (LilyPad lp : this.lilypads) {
            // if player has collided with the lilypad
            if (lp.collide(this.player)) {
                this.player.move(lp.facingLeft, lp.speed);
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
    // 2.2.2 - keyEventer(String) /////////////////////////////////////////////
    /** Change the direction of the player.
     * @author Nick Alekhine
     * 
     *  */
    public void keyEventer(String ke) {

        // "up" key press
        if (ke.equals("up")) {
            this.player.moveFrogUp();
        }

        // "down" key press
        else if (ke.equals("down")) {
            this.player.moveFrogDown();
        }

        // "left" key press
        else if (ke.equals("left")) {
            this.player.moveFrogLeft();
        }

        // "right" key press
        else if (ke.equals("right")) {
            this.player.moveFrogRight();
        }

    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.3 - worldEnder() ///////////////////////////////////////////////////
    /** To end the game if a collision occurs. 
     * @param boolean (auto-terminates game if true)
     * @return WorldEnd
     * @author Nick Alekhine
     * 
     *  */
    public WorldEnd worldEnder() {
        // go through list of cars and see if any car has collided with player 
        for (Car c : this.cars) {
            if (c.collide(player)) {
                return new WorldEnd(true, this.renderLast("YOU DED."));
            }
        }

        // if player's position is in the water
        if (this.player.posn.y < 200 && this.player.posn.y > 25) {
            boolean hasCollided = false;
            
            for (Log l : this.logs) {
                if (l.collide(player)) {
                    hasCollided = true;
                }
            }
            
            if (!hasCollided) {
                return new WorldEnd(true, this.renderLast("DROWNED."));
            }
            
            
        }
        
        if (this.player.posn.y <= 25) {
            return new WorldEnd(true, this.winState());
        }
        
        return new WorldEnd(false, this.render());
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.4 - render() ///////////////////////////////////////////////////////
    /** To draw the world onto the scene.
     * @return WorldImage 
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage render() {
        // initialize stack as background; 
        WorldImage stack = froggerBackgroundImage;

        // overlay all logs onto the scene
        for (Log l : this.logs) {
            stack = new OverlayImages(stack, l.makeImage());
        }

        // overlay all lilypads onto the scene
        for (LilyPad lp : this.lilypads) {
            stack = new OverlayImages(stack, lp.makeImage());
        }

        // overlay the player onto the scene
        stack = new OverlayImages(stack, this.player.makeImage());

        // overlay all the cars onto the scene
        for (Car c : this.cars) {
            stack = new OverlayImages(stack, c.makeImage());
        }


        return stack;
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.2.5 - renderLast(String) /////////////////////////////////////////////
    /** To draw the win / lose message at the end of the game. 
     * @return WorldImage
     * @author Nick Alekhine
     * 
     *  */
    public WorldImage renderLast(String s) {
        return this.render().overlayImages(
                new TextImage(new Posn(500, 250), s, 
                        180, 3, new Red()));
    }
    
    public WorldImage winState() {
        this.sounder.playSound("win.wav");
        return this.render().overlayImages(
                new TextImage(new Posn(500, 250), "YOU ARE A GOD", 
                        100, 3, new Red()));
    }
}
