/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. FroggerWorld
 *     2.1 FIELDS
 *       2.1.1 player                              -- Yeezus
 *       2.1.2 cars                                -- ArrayList<Car>
 *       2.1.3 ricks                               -- ArrayList<RickRoss>
 *       2.1.4 macs                                -- ArrayList<MacMiller>
 *       2.1.5 sounder                             -- MakeSound
 *       2.1.6 bg                                  -- BackgroundMusic
 *     2.2 CONSTRUCTORS
 *       2.2.1 YeezusWorld()
 *       2.2.2 YeezusWorld(Yeezus, ArrayList<Car>,
 *                         ArrayList<RickRoss>, ArrayList<MacMiller>)
 *     2.3 METHODS
 *       2.3.1 onTick()                            -- void
 *         2.3.1.1 moveWhenOnRickRossOrMacMiller() -- void
 *         2.3.1.2 moveObjects()                   -- void
 *       2.3.2 onKeyEvent(String)                  -- void
 *       2.3.3 worldEnds()                         -- WorldEnd
 *       2.3.4 makeImage()                         -- WorldImage
 *       2.3.5 lastImage(String)                   -- WorldImage
 *       2.3.6 winState()                          -- WorldImage
 *       2.3.7 bigBang(int, int, double)           -- void
 * 
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import java.util.ArrayList;

import javalib.colors.Black;
import javalib.colors.Red;
import javalib.soundworld.World;
import javalib.tunes.Note;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;





// 2 - YeezusWorld ///////////////////////////////////////////////////////////
/** The world state. Consists of a frog, cars, logs, and lilypads. 
 * @author Austin Colcord
 * @author Nick Alekhine 
 * 
 * */
public class YeezusWorld extends World implements YeezusWorldConstants {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    Yeezus player;                              // 2.1.1
    ArrayList<Car> cars;                        // 2.1.2
    ArrayList<RickRoss> ricks;                  // 2.1.3
    ArrayList<MacMiller> macs;                  // 2.1.4
    MakeSound sounder = new MakeSound();        // 2.1.5 
    BackgroundMusic bg = new BackgroundMusic(); // 2.1.6





    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    // 2.2.1 
    YeezusWorld() {
        this.player = new Yeezus();
        this.cars = new ArrayList<Car>();
        this.ricks = new ArrayList<RickRoss>();
        this.macs = new ArrayList<MacMiller>();
    }

    // 2.2.2 
    YeezusWorld(Yeezus player, ArrayList<Car> cars, 
            ArrayList<RickRoss> ricks, ArrayList<MacMiller> macs) {
        this.player = player;
        this.cars = cars;
        this.ricks = ricks;
        this.macs = macs;
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - Methods //////////////////////////////////////////////////////////
    // 2.3.1 - onTick() /////////////////////////////////////////////////TESTED
    /** Move the player around the scene. Move logs, lilypads, and cars.
     * @author Nick Alekhine
     * 
     *  */
    public void onTick() {
        this.moveWhenOnRickRossorMacMiller();
        this.moveObjects();
    }

    // 2.3.1.1 - moveWhenOnRickRossOrMacMiller() ////////////////////////TESTED
    /** Move the player when on a MacMiller or RickRoss
     * @author Nick Alekhine 
     * 
     * */
    public void moveWhenOnRickRossorMacMiller() {

        // go through list of logs and see if player has collided with any
        for (RickRoss l : this.ricks) {
            // if player has collided with the log
            if (l.collide(this.player)) {
                this.player.move(l.facingLeft, l.speed);
                return; // breaks out of method. 
            }
        }

        // go through list of lilypads and see if player has collided with any
        for (MacMiller lp : this.macs) {
            // if player has collided with the lilypad
            if (lp.collide(this.player)) {
                this.player.move(lp.facingLeft, lp.speed);
                break;
            }
        }
    }


    // 2.3.1.2 - moveObjects() //////////////////////////////////////////TESTED
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
        for (RickRoss l : this.ricks) {
            if (l.facingLeft) {
                l.moveObjectLeft();
            }
            else {
                l.moveObjectRight();
            }
        }

        // go through list of lilypads and move them
        for (MacMiller lp : this.macs) {
            if (lp.facingLeft) {
                lp.moveObjectLeft();
            }
            else {
                lp.moveObjectRight();
            }
        }
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3.2 - onKeyEvent(String) ///////////////////////////////////////TESTED
    /** Change the direction of the player.
     * @author Nick Alekhine
     * 
     *  */
    public void onKeyEvent(String ke) {

        // "up" key press
        if (ke.equals("up")) {
            this.player.moveUp();
            this.keyTunes.addNote(BAGPIPE, new Note("E0n2"));
        }

        // "down" key press
        else if (ke.equals("down")) {
            this.player.moveDown();
            this.keyTunes.addNote(BAGPIPE, new Note("E1n2"));
        }

        // "left" key press
        else if (ke.equals("left")) {
            this.player.moveLeft();
            this.keyTunes.addNote(PIANO, new Note("E1n2"));
        }

        // "right" key press
        else if (ke.equals("right")) {
            this.player.moveRight();
            this.keyTunes.addNote(PIANO, new Note("E0n2"));
        }

    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3.3 - worldEnds() //////////////////////////////////////////////TESTED
    /** To end the game if a collision occurs. 
     * @param boolean (auto-terminates game if true)
     * @return WorldEnd
     * @author Nick Alekhine
     * 
     *  */
    public WorldEnd worldEnds() {
        // go through list of cars and see if any car has collided with player 
        for (Car c : this.cars) {
            // if car has collided with the player
            if (c.collide(player)) {
                // if the player has 1 (or fewer) lives, end the game. 
                if (this.player.lives <= 1) {
                    return new WorldEnd(true, this.lastImage("YOU DEAD."));
                }
                // lose one life. 
                else {
                    this.player.loseLife();
                    this.player.returnToStart();
                    return new WorldEnd(false, this.makeImage());
                }
            }
        }

        // if player's position is in the water
        if (this.player.posn.y < 200 && this.player.posn.y > 25) {
            boolean hasCollided = false;

            int i = 0;
            // go through the list of RickRoss'
            while (i < this.ricks.size() && !hasCollided) {
                // if the RickRoss has collided with the player
                if (this.ricks.get(i).collide(this.player)) {
                    hasCollided = true;
                }

                i++;
            }

            i = 0; // reset incrementer
            // go through the list of MacMillers
            while (i < this.macs.size() && !hasCollided) {
                // if the MacMiller has collided with the player
                if (this.macs.get(i).collide(this.player)) {
                    hasCollided = true;
                }

                i++;
            }

            // if player has not collided with a RickRoss or MacMiller.
            if (!hasCollided) {
                // if the player has 1 (or fewer) lives, end the game. 
                if (this.player.lives <= 1) {
                    return new WorldEnd(true, this.lastImage("YOU DROWNED."));
                }
                // lose one life. 
                else {
                    this.player.loseLife();
                    this.player.returnToStart();
                    return new WorldEnd(false, this.makeImage());
                }
            }


        }

        // if player has reached the 'Ye Zone
        if (this.player.posn.y <= 25) {
            return new WorldEnd(true, this.winState());
        }

        // else the game continues on. 
        return new WorldEnd(false, this.makeImage());
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3.4 - makeImage() //////////////////////////////////////////////TESTED
    /** To draw the world onto the scene.
     * @return WorldImage 
     * @author Nick Alekhine
     * @author Austin Colcord
     * 
     *  */
    public WorldImage makeImage() {
        // initialize stack as background; 
        WorldImage stack = backgroundImage;

        // set the image of the life counter
        WorldImage lifeCount = new TextImage(
                new Posn(900, 30), "Lives: " + this.player.lives,
                30, 3, new Black());


        // overlay all logs onto the scene
        for (RickRoss l : this.ricks) {
            stack = new OverlayImages(stack, l.makeImage());
        }

        // overlay all MacMiller's onto the scene
        for (MacMiller lp : this.macs) {
            stack = new OverlayImages(stack, lp.makeImage());
        }

        // overlay the player onto the scene
        stack = new OverlayImages(stack, this.player.makeImage());

        // overlay all the cars onto the scene
        for (Car c : this.cars) {
            stack = new OverlayImages(stack, c.makeImage());
        }

        //overlay the lifeCounter over the whole image
        return new OverlayImages(stack, lifeCount);
    }





    ///////////////////////////////////////////////////////////////////////////
    // 2.3.5 - lastImage(String) ////////////////////////////////////////TESTED
    /** To draw the lose message at the end of the game. 
     * @return WorldImage
     * @author Nick Alekhine
     * 
     *  */
    @SuppressWarnings("deprecation")
    public WorldImage lastImage(String s) {
        this.bg.stop();
        return this.makeImage().overlayImages(
                new TextImage(new Posn(500, 250), s, 
                        120, 3, new Red()));
    }


    ///////////////////////////////////////////////////////////////////////////
    // 2.3.6 - winState() ///////////////////////////////////////////////TESTED
    /** To draw the win message at the end of the game. 
     * @return WorldImage
     * @author Nick Alekhine
     */
    @SuppressWarnings("deprecation")
    public WorldImage winState() {
        this.bg.stop();
        this.sounder.playSound("win.wav");
        this.sounder.playSound("win.wav");
        return this.makeImage().overlayImages(
                new TextImage(new Posn(500, 250), "YOU ARE A GOD", 
                        100, 3, new Red()));
    }

    
    ///////////////////////////////////////////////////////////////////////////
    // 2.3.7 - bigBang(int, int, double) //////////////////////////////////////
    /** To override the super's big bang so music can be player
     * @param int, int, double
     * @author Nick Alekhine
     * 
     *  */
    public void bigBang(int width, int height, double tick) {
        this.bg.start();

        super.bigBang(width, height, tick);
    }
}
