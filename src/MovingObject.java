/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. MovingObject
 *      2.1 FIELDS
 *          2.1.1 posn              -- Posn
 *          2.1.2 facingLeft        -- boolean
 *          2.1.3 speed             -- int
 *          2.1.4 image             -- WorldImage
 *          2.1.5 width             -- int
 *          2.1.6 height            -- int
 *      2.2 CONSTRUCTORS 
 *      2.3 METHODS
 *          2.3.1 collide(Yeezus)   -- boolean
 *          2.3.2 moveObjectLeft()  -- void
 *          2.3.3 moveObjectRight() -- void
 *          2.3.4 makeImage()       -- WorldImage
 *          
 *          
 *****************************************************************************/

// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.*;





// 2 - MovingObject ///////////////////////////////////////////////////////////
/** represents the abstract class that contains all the fields for objects that 
 *  are in the water.
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public abstract class MovingObject implements YeezusWorldConstants {
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    Posn posn;          // 2.1.1
    boolean facingLeft; // 2.1.2
    int speed;          // 2.1.3
    String image;       // 2.1.4
    int width;          // 2.1.5
    int height;         // 2.1.6

    // 2.2 - Constructors /////////////////////////////////////////////////////
    MovingObject(Posn posn, boolean facingLeft, int speed, 
                 String image, int width, int height) {
        this.posn = posn;
        this.facingLeft = facingLeft;
        this.speed = speed;
        this.image = image;
        this.width = width;
        this.height = height;
    }



    // 2.3 - Methods //////////////////////////////////////////////////////////

    // 2.3.1 - moveObjectLeft() /////////////////////////////////////////TESTED
    /** move the object to the left using this object's speed. 
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

    // 2.3.2 - moveObjectRight() ////////////////////////////////////////TESTED
    /** move the object to the right using this object's speed. 
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

    // 2.3.3 - collide(Yeezus) //////////////////////////////////////////TESTED
    /** to determine if the given Yeezus has collided with this object.
     * @param Yeezus
     * @return boolean 
     * @author Austin Colcord
     */
    public boolean collide(Yeezus f) {
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

    // 2.3.4 - makeImage() //////////////////////////////////////////////TESTED
    /** To make an image from this object's position and image filename. 
     * @return WorldImage
     * @author Nick Alekhine 
     * 
     * */
    public WorldImage makeImage() {
        return new FromFileImage(this.posn, this.image);
    }
}
