/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Car
 *      2.1 FIELDS
 *          2.1.1 posn          -- Posn
 *          2.1.2 facingLeft    -- boolean
 *          2.1.3 image         -- WorldImage
 *      2.2 METHODS
 *          2.2.1 moveCarLeft()     -- void
 *          2.2.2 moveCarRight()    -- void
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
public class Car implements FroggerWorldConstants{
    // 2.1 //////////////////////////////////////
    Posn posn;          //2.1.1
    boolean facingLeft; //2.1.2
    WorldImage image;   //2.1.3

    Car(Posn posn, boolean facingLeft, WorldImage image) {
        this.posn = posn;
        this.facingLeft = facingLeft;
        this.image = image;
    }

    ////////////////////////////////////////////////////////////////

    // 2.2 Methods /////////////////////////////////////////////////

    // 2.2.1 /////////////////////////////////////////////////////
    /** move the car to the left when called, once the
     * car has fully passed the left edge of the screen,
     * place the car at the border of the right edge
     * of the screen to restart the car
     * 
     * @author Austin Colcord
     */
    public void moveCarLeft() {
        int pastScreen = 100;
        if (this.posn.x <= -pastScreen) {
            this.posn.x = canvasWidth + pastScreen;
        }
        else {
            this.posn.x = this.posn.x - 5;
        }
    }

    // 2.2.2 /////////////////////////////////////////////////////
    /** move the car to the right when called, once the ccar has
     * fully passed the right edge of the screen, place the car at
     * the border of the left edge of the screen to restart the car
     * 
     * @author Austin Colcord
     */
    public void moveCarRight() {
        int pastScreen = canvasWidth + 100;
        int beforeScreen = -100;
        if (this.posn.x >= pastScreen) {
            this.posn.x = beforeScreen;
        }
        else {
            this.posn.x = this.posn.x + 5;
        }
    }
    


}
