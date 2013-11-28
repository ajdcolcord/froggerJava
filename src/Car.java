/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Car
 *      2.1 FIELDS
 *          2.1.1 posn          -- Posn
 *          2.1.2 facingLeft    -- boolean
 *          2.1.3 speed         -- int
 *          2.1.4 image         -- String
 *          2.1.5 width         -- int
 *          2.1.6 height        -- int
 *      
 *          
 *          
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.Posn;





// 2 - Car ///////////////////////////////////////////////////////////////////
/** to represent a car
 * @author Austin Colcord
 * @author Nick Alekhine
 * */
public class Car extends MovingObject implements YeezusWorldConstants{

    Car(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 50, 50);
    }

}
