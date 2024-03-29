//CS 2510 Fall 2013
//Assignment 8
//partner1-Alekhine, Nick --alekhn
//partner2-Colcord, Austin --acolcord


/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. Yeezus
 *    2.1 FIELDS
 *      2.1.1 posn               -- Posn
 *      2.1.2 lives              -- int
 *      2.1.3 image              -- String
 *      2.1.4 width              -- int
 *      2.1.5 height             -- int
 *    2.2 CONSTRUCTORS
 *      2.2.1 Yeezus()
 *    2.3 METHODS
 *      2.3.1 moveUp()           -- void
 *      2.3.2 moveDown()         -- void
 *      2.3.3 moveLeft()         -- void
 *      2.3.4 moveRight()        -- void
 *      2.3.5 loseLife()         -- void 
 *      2.3.6 move(Boolean, int) -- void
 *      2.3.7 returnToStart()    -- void
 *      2.3.8 makeImage()        -- WorldImage
 *          
 *****************************************************************************/

// 1 - Libraries //////////////////////////////////////////////////////////////
import javalib.worldimages.*;





// 2 - Yeezus /////////////////////////////////////////////////////////////////
/** To represent the player you control.  
 * @author Austin Colcord
 * @author Nick Alekhine
 * 
 * */
public class Yeezus implements YeezusWorldConstants {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    Posn posn;    // 2.1.1
    int lives;    // 2.1.2
    String image; // 2.1.3
    int width;    // 2.1.4
    int height;   // 2.1.5

    
    
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    Yeezus() {
        this.posn = new Posn((canvasWidth / 2), 475);
        this.lives = 3;
        this.image = yeUp;
        this.width = 50;
        this.height = 50;
    }

    
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    // 2.3 - Methods //////////////////////////////////////////////////////////
    
    // 2.3.1 - moveUp() /////////////////////////////////////////////////TESTED
    /** move up one step 
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     * */
    public void moveUp() {
        // if y coordinate is below canvasHeight
        if (this.posn.y > 50) {
            // set new x coordinate
            this.posn.y = this.posn.y - (canvasHeight / 10);
            // set image to yeezus in up position
            this.image = yeUp;
        }
    }

    
    
    
    
    // 2.3.2 - moveDown() ///////////////////////////////////////////////TESTED
    /** move down one step unless at the bottom
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     */
    public void moveDown() {
        // if y coordinate is above canvasHeight
        if (this.posn.y < (canvasHeight) - 50) {
            // set new y coordinate
            this.posn.y = this.posn.y + (canvasHeight / 10);
            // set image to yeezus in down position
            this.image = yeDown;
        }
    }

    
    
    
    
    // 2.3.3 - moveLeft() ///////////////////////////////////////////////TESTED
    /** move to the left unless near the left edge of the canvas 
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     * */
    public void moveLeft() {
        // if x coordinate is greater than LHS of canvas.
        if (this.posn.x > (canvasWidth / 20)) {
            // set new x coordinate
            this.posn.x = this.posn.x - (canvasWidth / 20);
            // set image to yeezus in left position.
            this.image = yeLeft;
        }
    }

    
    
    
    
    // 2.3.4 - moveRight() //////////////////////////////////////////////TESTED
    /**  move to the right unless near the right edge of the canvas 
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     * */
    public void moveRight() {
        // if x coordinate is less than RHS of canvas
        if (this.posn.x < (canvasWidth - (canvasWidth / 20))) {
            // set new x coordinate
            this.posn.x = this.posn.x + (canvasWidth / 20);
            // set image to yeezus in right position
            this.image = yeRight;
        }
    }
    
    
    
    
    
    // 2.3.5 - loseLife() ///////////////////////////////////////////////TESTED
    /** lose life if enter water or collide with car
     * @author Austin Colcord
     * @author Nick Alekhine
     * 
     */
    public void loseLife() {
        this.lives = this.lives - 1;
    }
    
    
    
    
    
    // 2.3.6 - move(Boolean, int) ///////////////////////////////////////TESTED
    /** Move in the direction and the speed given.
     * @param Boolean, int
     * @author Nick Alekhine 
     * 
     * */
    public void move(Boolean facingLeft, int speed) {
        // if moving left
        if (facingLeft) {
            // if x coordinate is not beyond canvas
            if (this.posn.x > (canvasWidth / 20)) {
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
    
    
    
    
    
    // 2.3.7 - returnToStart() //////////////////////////////////////////TESTED
    /** To return this player to the original position
     * @author Nick Alekhine
     * 
     *  */
    public void returnToStart() {
        this.posn = new Posn((canvasWidth / 2), 475);
    }
    
    
    
    
    
    // 2.3.8 - makeImage() //////////////////////////////////////////////TESTED
    /** Make image out of this image and position. 
     * @author Nick Alekhine 
     * 
     * */
    public WorldImage makeImage() {
        return new FromFileImage(this.posn, this.image);
    }
    
    
}
