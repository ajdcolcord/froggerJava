/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Car
 *      2.1 FIELDS
 *          2.1.1 posn          -- Posn
 *          2.1.2 facingLeft    -- boolean
 *          2.1.3 speed         -- int
 *          2.1.4 image         -- WorldImage
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
    int speed;          //2.1.3
    WorldImage image;   //2.1.4
    int width;
    int height;

    Car(Posn posn, boolean facingLeft, int speed, WorldImage image) {
        this.posn = posn;
        this.facingLeft = facingLeft;
        this.speed = speed;
        this.image = image;
        this.width = 100;
        this.height = 100;
    }

    ////////////////////////////////////////////////////////////////

    // 2.2 Methods /////////////////////////////////////////////////

    // 2.2.1 /////////////////////////////////////////////////////
    /** move the car to the left when called by the 
     * rate of speed that the car contains. Once the
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
            this.posn.x = this.posn.x - this.speed;
        }
    }

    // 2.2.2 /////////////////////////////////////////////////////
    /** move the car to the right when called by the rate
     * of speed that the car contains. Once the car has
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
            this.posn.x = this.posn.x + this.speed;
        }
    }
    
    // 2.2.3 /////////////////////////////////////////////////////
    /** return a boolean to tell if the frog has collided with this object
     * @author Austin Colcord
     */
     public boolean collide(Frog f) {
         //if ( (this.posn.x - (this.width / 2)) <= ((f.posn.x + ))
         return false;
     }
    


}
