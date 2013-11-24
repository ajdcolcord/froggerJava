/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. MovingObject
 *      2.1 FIELDS
 *          2.1.1 posn          -- Posn
 *          2.1.2 facingLeft    -- boolean
 *          2.1.3 speed         -- int
 *          2.1.4 image         -- WorldImage
 *          2.1.5 width         -- int
 *          2.1.6 height        -- int
 *      2.2 METHODS
 *          2.2.1 collide(Frog f)   -- boolean
 *          
 *****************************************************************************/

// 1. Libraries ////////////////////////////////////////////////////////
import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import java.awt.Color;

///////////////////////////////////////////////////////////////////////


// 2 AWaterObject ////////////////////////////////////////////////////////
/** represents the abstract class that contains all the 
 * fields for objects that are in the water
 * @author Austin
 *
 */
public abstract class MovingObject implements FroggerWorldConstants {
    Posn posn;          //2.1.1
    boolean facingLeft; //2.1.2
    int speed;          //2.1.3
    WorldImage image;   //2.1.4
    int width;          //2.1.5
    int height;         //2.1.6

    MovingObject(Posn posn, boolean facingLeft, int speed, WorldImage image) {
        this.posn = posn;
        this.facingLeft = facingLeft;
        this.speed = speed;
        this.image = image;
        this.width = width;
        this.height = height;
    }



    // 2.2 Methods /////////////////////////////////////////////////////

    // 2.2.1 /////////////////////////////////////////////////////
    /** move the object to the left when called by the 
     * rate of speed that the object contains. Once the
     * object has fully passed the left edge of the screen,
     * place the object at the border of the right edge
     * of the screen to restart the object
     * 
     * @author Austin Colcord
     */
    public void moveObjectLeft() {
        int pastScreen = 100;
        if (this.posn.x <= -pastScreen) {
            this.posn.x = canvasWidth + pastScreen;
        }
        else {
            this.posn.x = this.posn.x - this.speed;
        }
    }

    // 2.2.2 /////////////////////////////////////////////////////
    /** move the object to the right when called by the rate
     * of speed that the object contains. Once the object has
     * fully passed the right edge of the screen, place the object at
     * the border of the left edge of the screen to restart the object
     * 
     * @author Austin Colcord
     */
    public void moveObjectRight() {
        int pastScreen = canvasWidth + 100;
        int beforeScreen = -100;
        if (this.posn.x >= pastScreen) {
            this.posn.x = beforeScreen;
        }
        else {
            this.posn.x = this.posn.x + this.speed;
        }
    }

    // 2.2.3 //////////////////////////////////////////////////////
    /** return a boolean to tell if the frog has collided with this object
     * @param f the frog that is given to test against this
     * @author Austin Colcord
     */
    public boolean collide(Frog f) {
        // setting the left and right edges of this object and the frog
        int thisLeftEdge = (this.posn.x - (this.width / 2));
        int thisRightEdge = (this.posn.x + (this.width / 2));
        int fLeftEdge = (f.posn.x - (f.width / 2));
        int fRightEdge = (f.posn.x + (f.width / 2));
        boolean sameYAxis = (this.posn.y == f.posn.y);

        if (sameYAxis 
                && (thisLeftEdge <= fRightEdge)
                && (thisRightEdge >= fLeftEdge)) {
            return true;
        }
        else {
            return false;
        }
    } 



}
