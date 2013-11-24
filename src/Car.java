/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Car
 *      2.1 FIELDS
 *          2.1.1 posn          -- Posn
 *          2.1.2 facingLeft    -- boolean
 *          2.1.3 speed         -- int
 *          2.1.4 image         -- WorldImage
 *          2.1.5 width         -- int
 *          2.1.6 height        -- int
 *      
 *          
 *          
 *****************************************************************************/

// 1. Libraries ////////////////////////////////////////////////////////////
import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;
////////////////////////////////////////////////////////////////////////////

//2. Car ///////////////////////////////////////////////////////////////////
/** represents the car in the game 
 * 
 * @author Austin Colcord
 * */
public class Car extends MovingObject implements FroggerWorldConstants{
    // 2.1 //////////////////////////////////////
    Posn posn;          //2.1.1
    boolean facingLeft; //2.1.2
    int speed;          //2.1.3
    WorldImage image;   //2.1.4
    int width;          //2.1.5
    int height;         //2.1.6

    Car(Posn posn, boolean facingLeft, int speed, WorldImage image) {
        super(posn, facingLeft, speed, image);
        this.width = 100;
        this.height = 100;
    }

}
