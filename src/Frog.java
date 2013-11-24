/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Frog
 *      2.1 FIELDS
 *          2.1.1 posn  -- Posn
 *          2.1.2 lives -- int
 *          2.1.3 image -- WorldImage
 *      2.2 METHODS
 *          2.2.1 moveFrogUp()      -- void
 *          2.2.2 moveFrogDown()    -- void
 *          2.2.3 moveFrogLeft()    -- void
 *          2.2.4 moveFrogRight()   -- void
 *          2.2.5 loseLife()        -- void 
 *          
 *****************************************************************************/

// 1. Libraries ////////////////////////////////////////////////////////////
import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import java.awt.Color;

///////////////////////////////////////////////////////////////////////////


//2. Frog /////////////////////////////////////////////////////////////////
/** represents the frog that is controlled by the player 
 * 
 * @author Austin Colcord
 * */
public class Frog implements FroggerWorldConstants {
    // 2.1 //////////////////////////////////////
    Posn posn;
    int lives;
    WorldImage image;
    int width;
    int height;

    Frog() {
        this.posn = new Posn((canvasWidth / 2), 950);
        this.lives = 3;
        this.image = new FromFileImage(this.posn, "frogUp.png");
        this.width = 100;
        this.height = 100;

    }

    // 2.2.1 ////////////////////////////////////////////////////
    /** move the frog up one step 
     * @author Austin Colcord
     * */
    public void moveFrogUp() {
        this.posn.y = this.posn.y + (canvasHeight / 10);
    }

    // 2.2.2 ////////////////////////////////////////////////////
    /** move the frog down one step, unless the frog is at the bottom
     * row, then do nothing
     * @author Austin Colcord
     */
    public void moveFrogDown() {
        if (this.posn.y <= (canvasHeight / 10)) {
            // if the frog is at the bottom row, don't do anything
            this.posn = this.posn;
        }
        else {
            this.posn.y = this.posn.y - (canvasHeight / 10);
        }
    }

    // 2.2.3 ////////////////////////////////////////////////////
    /** move the frog to the left, unless near the left edge of the canvas 
     * @author Austin Colcord
     * */
    public void moveFrogLeft() {
        if (this.posn.x <= (canvasWidth / 5)) {
            this.posn = this.posn;
        }
        else {
            this.posn.x = this.posn.x - (canvasWidth / 5);
        }
    }

    // 2.2.4 ////////////////////////////////////////////////////
    /**  move the frog to the right unless near the right edge of the canvas 
     * @author Austin Colcord
     * */
    public void moveFrogRight() {
        if (this.posn.x >= (canvasWidth - (canvasWidth / 5))) {
            this.posn = this.posn;
        }
        else {
            this.posn.x = this.posn.x + (canvasWidth / 5);
        }
    }
    
    // 2.2.5 ////////////////////////////////////////////////////
    /** make the frog lose a life by 1. this will be called if
     * the frog falls in the water or is hit by a car
     * @author Austin Colcord
     */
    public void loseLife() {
        this.lives = this.lives - 1;
    }
    
    // 2.2.6 //////////////////////////////////////////////////////////////////
    public void move(Boolean facingLeft, int speed) {
        
    }
}
