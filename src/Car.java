/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Car
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
