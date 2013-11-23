/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. AWaterObject
 *      2.1 FIELDS
 *          2.1.1 posn          -- Posn
 *          2.1.2 facingLeft    -- boolean
 *          2.1.3 speed         -- int
 *          2.1.4 image         -- WorldImage
 *          
 *****************************************************************************/

// 1. Libraries ////////////////////////////////////////////////////////
import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import java.awt.Color;

///////////////////////////////////////////////////////////////////////


// 2. AWaterObject ////////////////////////////////////////////////////////
/** represents the abstract class that contains all the 
 * fields for objects that are in the water
 * @author Austin
 *
 */
public class AWaterObject implements FroggerWorldConstants {
    Posn posn;          //2.1.1
    boolean facingLeft; //2.1.2
    int speed;          //2.1.3
    WorldImage image;   //2.1.4
    int width;
    int height;
    
    AWaterObject(Posn posn, boolean facingLeft, int speed, WorldImage image) {
        this.posn = posn;
        this.facingLeft = facingLeft;
        this.speed = speed;
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    /** return a boolean to tell if the frog has collided with this object
    * @author Austin Colcord
    */
    public boolean collide(Frog f) {
        //if ( (this.posn.x - (this.width / 2)) <= ((f.posn.x + ))
        return false;
    }
    
    public void moveLeft() {
        
    }
    
    public void moveRight() {
        
    }
   
}
