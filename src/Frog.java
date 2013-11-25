/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Frog
 *    2.1 FIELDS
 *      2.1.1 posn   -- Posn
 *      2.1.2 lives  -- int
 *      2.1.3 image  -- String
 *      2.1.4 width  -- int
 *      2.1.5 height -- int
 *    2.2 CONSTRUCTORS
 *      2.2.1 Frog()
 *    2.3 METHODS
 *      2.3.1 moveFrogUp()       -- void
 *      2.3.2 moveFrogDown()     -- void
 *      2.3.3 moveFrogLeft()     -- void
 *      2.3.4 moveFrogRight()    -- void
 *      2.3.5 loseLife()         -- void 
 *      2.3.6 move(Boolean, int) -- void
 *      2.3.7 makeImage()        -- WorldImage
 *          
 *****************************************************************************/

// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.*;





//2 - Frog ////////////////////////////////////////////////////////////////////
/** represents the frog that is controlled by the player 
 * @author Austin Colcord
 * @author Nick Alekhine
 * 
 * */
public class Frog implements FroggerWorldConstants {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    Posn posn;
    int lives;
    String image;
    int width;
    int height;

    
    
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    Frog() {
        this.posn = new Posn((canvasWidth / 2), 475);
        this.lives = 3;
        this.image = frogUp;
        this.width = 50;
        this.height = 50;

    }

    
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - Methods //////////////////////////////////////////////////////////
    
    // 2.3.1 - moveFrogUp() ///////////////////////////////////////////////////
    /** move the frog up one step 
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     * */
    public void moveFrogUp() {
        // if y coordinate is below canvasHeight
        if (this.posn.y > 50) {
            // set new x coordinate
            this.posn.y = this.posn.y - (canvasHeight / 10);
            // set image to frog in up position
            this.image = frogUp;
        }
    }

    
    
    
    
    // 2.3.2 - moveFrogDown() /////////////////////////////////////////////////
    /** move the frog down one step, unless the frog is at the bottom
     * row, then do nothing
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     */
    public void moveFrogDown() {
        // if y coordinate is above canvasHeight
        if (this.posn.y < (canvasHeight) - 50) {
            // set new y coordinate
            this.posn.y = this.posn.y + (canvasHeight / 10);
            // set image to frog in down position
            this.image = frogDown;
        }
    }

    
    
    
    
    // 2.3.3 - moveFrogLeft() /////////////////////////////////////////////////
    /** move the frog to the left, unless near the left edge of the canvas 
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     * */
    public void moveFrogLeft() {
        // if x coordinate is greater than LHS of canvas.
        if (this.posn.x > (canvasWidth / 20)) {
            // set new x coordinate
            this.posn.x = this.posn.x - (canvasWidth / 20);
            // set image to frog in left position.
            this.image = frogLeft;
        }
    }

    
    
    
    
    // 2.3.4 - moveFrogRight() ////////////////////////////////////////////////
    /**  move the frog to the right unless near the right edge of the canvas 
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     * */
    public void moveFrogRight() {
        // if x coordinate is less than RHS of canvas
        if (this.posn.x < (canvasWidth - (canvasWidth / 20))) {
            // set new x coordinate
            this.posn.x = this.posn.x + (canvasWidth / 20);
            // set image to frog in right position
            this.image = frogRight;
        }
    }
    
    
    
    
    
    // 2.3.5 - loseLife() ////////////////////////////////////////////////////.
    /** make the frog lose a life by 1. this will be called if
     * the frog falls in the water or is hit by a car
     * @author Austin Colcord
     */
    public void loseLife() {
        this.lives = this.lives - 1;
    }
    
    
    
    
    
    // 2.3.6 - move(Boolean, int) /////////////////////////////////////////////
    public void move(Boolean facingLeft, int speed) {
        // if moving left
        if (facingLeft) {
            // if x coordinate is not beyond canvas
            if (this.posn.x < (canvasWidth / 20)) {
                this.posn.x = this.posn.x - speed;
            }
        }
        // else moving right
        else {
            // if x coordinate is not beyond canvas
            if (this.posn.x < (canvasWidth - (canvasWidth / 20))) {
                this.posn.x = this.posn.x + speed;
            }
        }
    }
    
    
    
    
    
    // 2.3.7 - makeImage() ////////////////////////////////////////////////////
    public WorldImage makeImage() {
        return new FromFileImage(this.posn, this.image);
    }
    
    
}
