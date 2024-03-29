//CS 2510 Fall 2013
//Assignment 8
//partner1-Alekhine, Nick --alekhn
//partner2-Colcord, Austin --acolcord

/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. ExamplesYeezusWorld
 *      2.1 EXAMPLES OF OBJECTS
 *          2.1.1 y1        -- Yeezus
 *          2.1.2 c1        -- Car
 *          2.1.3 rr1       -- RickRoss
 *          2.1.4 mm1       -- MacMiller
 *          2.1.5 clistmt   -- ArrayList<Car>
 *          2.1.6 clist1    -- ArrayList<Car>
 *          2.1.6 rrlistmt  -- ArrayList<RickRoss>
 *          2.1.6 rrlist1   -- ArrayList<RickRoss>
 *          2.1.6 mmlistmt  -- ArrayList<MacMiller>
 *          2.1.6 mmlist1   -- ArrayList<MacMiller>
 *          2.1.6 yWorld1   -- YeezusWorld
 *      2.2 TESTS OF METHODS
 *          2.2.1 testMoveUp()
 *          2.2.2 testMoveDown()
 *          2.2.3 testMoveLeft()
 *          2.2.4 testMoveRight()
 *          2.2.5 testMoveObjectLeft()
 *          2.2.6 testMoveObjectRight()
 *          2.2.7 testLoseLife()
 *          2.2.8 testCollide()
 *          2.2.9 testMakeImageMO()
 *          2.2.10 testMove()
 *          2.2.11 testReturnToStart
 *          2.2.12 testMakeImageY
 *          2.2.13 testMoveWhenOnRickRossorMacMiller
 *          2.2.14 testMoveObjects
 *          2.2.15 testOnTick
 *          2.2.16 testOnKeyEvent
 *          2.2.17 testWorldEnds
 *          2.2.18 testMakeImageYW
 *          2.2.19 testLastImage
 *          2.2.20 testWinState
 *      2.3 Game Running Objects
 *          
 *          
 *****************************************************************************/

// 1 - Libraries //////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Arrays;

import javalib.colors.Black;
import javalib.colors.Red;
import javalib.worldimages.FromFileImage;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;
import tester.Tester;





// 2 - ExamplesYeezusWorld ////////////////////////////////////////////////////
/** represents the examples, tests, and initial state of the Yeezus game 
 * 
 * @author Austin Colcord
 *
 */
public class ExamplesYeezusWorld implements YeezusWorldConstants {

    // 2.1 - Test Objects /////////////////////////////////////////////////////
    // initialize test objects. 

    // YEEZUS
    Yeezus y1; //2.1.1

    // CARS
    Car c1;  //2.1.2

    // RICKROSS
    RickRoss rr1;  //2.1.3

    // MACMILLER
    MacMiller mm1;  //2.1.4

    // ARRAYLISTS
    ArrayList<Car> clistmt; // non-empty case //2.1.5
    ArrayList<Car> clist1; // empty case      //2.1.6

    ArrayList<RickRoss> rrlistmt; // non-empty case  //2.1.7
    ArrayList<RickRoss> rrlist1; // empty case       //2.1.8

    ArrayList<MacMiller> mmlistmt; // non-empty case  //2.1.9
    ArrayList<MacMiller> mmlist1; // empty case       //2.1.10

    YeezusWorld yWorld1;

    // initialize values in test objects
    public void reset() {
        this.y1 = new Yeezus();
        this.c1 = new Car(new Posn(100, 100), true, 10, "carLeft.png");
        this.rr1 = new RickRoss(
                new Posn(300, 200), false, 10, "rickRossRight.png");
        this.mm1 = new MacMiller(
                new Posn(400, 200), true, 10, "macMiller.png");

        this.clistmt = new ArrayList<Car>();
        this.clist1 = new ArrayList<Car>();
        this.clist1.add(this.c1);

        this.rrlistmt = new ArrayList<RickRoss>();
        this.rrlist1 = new ArrayList<RickRoss>();
        this.rrlist1.add(this.rr1);

        this.mmlistmt = new ArrayList<MacMiller>();
        this.mmlist1 = new ArrayList<MacMiller>();
        this.mmlist1.add(this.mm1);

        this.yWorld1 = new YeezusWorld(
                this.y1, this.clist1, this.rrlist1, this.mmlist1);
    }


    // 2.2 Tests of Methods //////////////////////////////////////////////////

    // 2.2.1 ////////////////////////////////////////////
    /** test the moveUp method
     * 
     * @author Austin Colcord
     */
    public void testMoveUp(Tester t) {
        reset();
        t.checkExpect(this.y1.posn.y, 475);
        //call the method
        this.y1.moveUp();
        //check the moved position
        t.checkExpect(this.y1.posn.y, 425);
        //set the y position to the top of the canvas
        this.y1.posn.y = 0;
        this.y1.moveUp();
        //check to see that it didn't move
        t.checkExpect(this.y1.posn.y, 0);
    }


    // 2.2.2 ////////////////////////////////////////////
    /** test the movedDown method
     * 
     * @author Austin Colcord
     */
    public void testMoveDown(Tester t) {
        reset();
        t.checkExpect(this.y1.posn.y, 475);
        // call the method
        this.y1.moveDown();
        // check the moved position, which won't be moved because
        // the yeezus is close to the bottom border
        t.checkExpect(this.y1.posn.y, 475);
        // setting to a higher position to test again
        this.y1.posn.y = canvasHeight;
        this.y1.moveDown();
        t.checkExpect(this.y1.posn.y, 500);
    }

    // 2.2.3 ////////////////////////////////////////////
    /** test the moveLeft
     * 
     * @author Austin Colcord
     */
    public void testMoveLeft(Tester t) {
        reset();
        //test the original position
        t.checkExpect(this.y1.posn.x, 500);
        this.y1.moveLeft();
        //check to see that the position moved left
        t.checkExpect(this.y1.posn.x, 450);
        //set the position to the border
        this.y1.posn.x = 0;
        this.y1.moveLeft();
        //test that the position didn't move since it was on the border
        t.checkExpect(this.y1.posn.x, 0);
    }

    // 2.2.4 ////////////////////////////////////////////
    /** test the moveRight method
     * 
     * @author Austin Colcord
     */
    public void testMoveRight(Tester t) {
        reset();
        //check the original position
        t.checkExpect(this.y1.posn.x, 500);
        //move the player right
        this.y1.moveRight();
        //check that it was moved right
        t.checkExpect(this.y1.posn.x, 550);
        //set the position to the right edge
        this.y1.posn.x = (canvasWidth);
        this.y1.moveRight();
        // make sure the position did not change
        t.checkExpect(this.y1.posn.x, canvasWidth);
    }

    // 2.2.5 ////////////////////////////////////////////
    /** test the moveObjectLeft method
     * 
     * @author Austin Colcord
     */
    public void testMoveObjectLeft(Tester t) {
        reset();
        //check the original position
        t.checkExpect(this.c1.posn.x, 100);
        //move the car left
        this.c1.moveObjectLeft();
        //check the moved position
        t.checkExpect(this.c1.posn.x, 90);
        //set a new position
        this.c1.posn.x = -100;
        this.c1.moveObjectLeft();
        //check that the position was reset to the right side
        t.checkExpect(this.c1.posn.x, (canvasWidth + 100));

        //check the original position
        t.checkExpect(this.rr1.posn.x, 300);
        //move the object left
        this.rr1.moveObjectLeft();
        //check the moved position
        t.checkExpect(this.rr1.posn.x, 290);
        //set to a new position off the page
        this.rr1.posn.x = -110;
        this.rr1.moveObjectLeft();
        //make sure the object reset to the right side
        t.checkExpect(this.rr1.posn.x, 1100);

        //check the original position
        t.checkExpect(this.mm1.posn.x, 400);
        //move the object left
        this.mm1.moveObjectLeft();
        //check the moved position
        t.checkExpect(this.mm1.posn.x, 390);
        //set a new position outside the screen
        this.mm1.posn.x = -105;
        this.mm1.moveObjectLeft();
        //check that the object resets on the other side of the screen
        t.checkExpect(this.mm1.posn.x, (canvasWidth + 100));
    }

    // 2.2.6 ////////////////////////////////////////////
    /** test the moveCarLeft method
     * 
     * @author Austin Colcord
     */
    public void testMoveObjectRight(Tester t) {
        reset();
        //test the original position
        t.checkExpect(this.c1.posn.x, 100);
        //move the object right
        this.c1.moveObjectRight();
        //check that the position was moved
        t.checkExpect(this.c1.posn.x, 110);
        //set to a position off of the screen
        this.c1.posn.x = (canvasWidth + 100);
        this.c1.moveObjectRight();
        //check that the position resets to the left side
        t.checkExpect(this.c1.posn.x, -100);

        //test the original position
        t.checkExpect(this.rr1.posn.x, 300);
        //move the object right
        this.rr1.moveObjectRight();
        //check that the object moved
        t.checkExpect(this.rr1.posn.x, 310);
        //set to a new position off of the screen
        this.rr1.posn.x = (canvasWidth + 120);
        this.rr1.moveObjectRight();
        //check that the object resets ot before the screen
        t.checkExpect(this.rr1.posn.x, -100);

        //test the original position
        t.checkExpect(this.mm1.posn.x, 400);
        //move the object right
        this.mm1.moveObjectRight();
        //check the moved position
        t.checkExpect(this.mm1.posn.x, 410);
        //set a new position off the screen
        this.mm1.posn.x = (canvasWidth + 120);
        this.mm1.moveObjectRight();
        //check that the position resets
        t.checkExpect(this.mm1.posn.x, -100);
    } 


    // 2.2.7 ////////////////////////////////////////////
    /** test the loseLife method
     * 
     * @author Austin Colcord
     */
    public void testLoseLife(Tester t) {
        reset();
        t.checkExpect(this.y1.lives, 3);
        this.y1.loseLife();
        t.checkExpect(this.y1.lives, 2);
        this.y1.loseLife();
        t.checkExpect(this.y1.lives, 1);
    }



    // 2.2.8 ////////////////////////////////////////////
    /** test the collide method
     * 
     * @author Austin Colcord
     */
    public void testCollide(Tester t) {
        reset();
        t.checkExpect(this.rr1.collide(this.y1), false);
        this.y1.posn = this.rr1.posn;
        t.checkExpect(this.rr1.collide(this.y1), true);
        reset();
        t.checkExpect(this.rr1.collide(this.y1), false);
        t.checkExpect(this.c1.collide(this.y1), false);
        this.y1.posn = this.c1.posn;
        t.checkExpect(this.c1.collide(this.y1), true);
        t.checkExpect(this.mm1.collide(this.y1), false);
        this.y1.posn = this.mm1.posn;
        t.checkExpect(this.mm1.collide(this.y1), true);
    }

    // 2.2.9 ////////////////////////////////////////////
    /** test the makeImage method for makeImage in the 
     * Moving Object class
     * 
     * @author Austin Colcord
     */
    public void testMakeImageMO(Tester t) {
        reset();
        t.checkExpect(this.c1.makeImage(),  
                new FromFileImage(new Posn(100, 100), "carLeft.png"));
        t.checkExpect(this.rr1.makeImage(),
                new FromFileImage(new Posn(300, 200), "rickRossRight.png"));
        t.checkExpect(this.mm1.makeImage(),
                new FromFileImage(new Posn(400, 200), "macMiller.png"));
    }


    // 2.2.10 ////////////////////////////////////////////
    /** test the move method for Yeezus class
     * 
     * @author Austin Colcord
     */
    public void testMove(Tester t) {
        reset();
        t.checkExpect(this.y1.posn.x, 500);
        this.y1.move(true, 10);
        t.checkExpect(this.y1.posn.x, 490);
        this.y1.move(false, 20);
        t.checkExpect(this.y1.posn.x, 510);
    }


    // 2.2.11 ////////////////////////////////////////////
    /** test the returnToStart method for Yeezus class
     * 
     * @author Austin Colcord
     */
    public void testReturnToStart(Tester t) {
        reset();
        this.y1.posn.y = 300;
        this.y1.posn.x = 500;
        this.y1.returnToStart();
        t.checkExpect(this.y1.posn.x, (canvasWidth / 2));
        t.checkExpect(this.y1.posn.y, 475);
    }



    // 2.2.12 ////////////////////////////////////////////
    /** test the makeImage method for Yeezus class
     * 
     * @author Austin Colcord
     */
    public void testMakeImageY(Tester t) {
        reset();
        t.checkExpect(this.y1.makeImage(),
                new FromFileImage(new Posn(500, 475), "yeUp.png"));
        this.y1.posn.x = 100;
        t.checkExpect(this.y1.makeImage(),
                new FromFileImage(new Posn(100, 475), "yeUp.png"));
        this.y1.moveLeft();
        t.checkExpect(this.y1.makeImage(),
                new FromFileImage(new Posn(50, 475), "yeLeft.png"));
    }


    // 2.2.13 ////////////////////////////////////////////
    /** test the moveWhenOnRickRossOrMacMiller method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testMoveWhenOnRickRossorMacMiller(Tester t) {
        reset();
        //check the original position
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
        this.yWorld1.moveWhenOnRickRossorMacMiller();
        //check that the positions didn't move (since not on anything)
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
        //set the position to the same as the rr1 in the world
        this.y1.posn.y = this.rr1.posn.y;
        this.y1.posn.x = this.rr1.posn.x;
        //check those positions
        t.checkExpect(this.y1.posn.x, 300);
        t.checkExpect(this.y1.posn.y, 200);
        this.yWorld1.moveWhenOnRickRossorMacMiller();
        //check that the x position increased by 10
        t.checkExpect(this.y1.posn.x, 310);
        t.checkExpect(this.y1.posn.y, 200);
        //set the position to the same as the mm1 in the world
        this.y1.posn.y = this.mm1.posn.y;
        this.y1.posn.x = this.mm1.posn.x;
        //check the position
        t.checkExpect(this.y1.posn.x, 400);
        t.checkExpect(this.y1.posn.y, 200);
        this.yWorld1.moveWhenOnRickRossorMacMiller();
        //check that the x position moved
        t.checkExpect(this.y1.posn.x, 390);
        t.checkExpect(this.y1.posn.y, 200);
    }


    // 2.2.14 ////////////////////////////////////////////
    /** test the moveObjects method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testMoveObjects(Tester t) {
        reset();
        //check all original positions
        t.checkExpect(this.c1.posn.x, 100);
        t.checkExpect(this.c1.posn.y, 100);
        t.checkExpect(this.rr1.posn.x, 300);
        t.checkExpect(this.rr1.posn.y, 200);
        t.checkExpect(this.mm1.posn.x, 400);
        t.checkExpect(this.mm1.posn.y, 200);
        //call moveObjects
        this.yWorld1.moveObjects();
        //check all objects that moved
        t.checkExpect(this.c1.posn.x, 90);
        t.checkExpect(this.c1.posn.y, 100);
        t.checkExpect(this.rr1.posn.x, 310);
        t.checkExpect(this.rr1.posn.y, 200);
        t.checkExpect(this.mm1.posn.x, 390);
        t.checkExpect(this.mm1.posn.y, 200);
    }


    // 2.2.15 ////////////////////////////////////////////
    /** test the onTick method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testOnTick(Tester t) {
        reset();
        //check all original positions
        t.checkExpect(this.c1.posn.x, 100);
        t.checkExpect(this.c1.posn.y, 100);
        t.checkExpect(this.rr1.posn.x, 300);
        t.checkExpect(this.rr1.posn.y, 200);
        t.checkExpect(this.mm1.posn.x, 400);
        t.checkExpect(this.mm1.posn.y, 200);
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
        //call onTick
        this.yWorld1.onTick();
        //check all moved positions
        t.checkExpect(this.c1.posn.x, 90);
        t.checkExpect(this.c1.posn.y, 100);
        t.checkExpect(this.rr1.posn.x, 310);
        t.checkExpect(this.rr1.posn.y, 200);
        t.checkExpect(this.mm1.posn.x, 390);
        t.checkExpect(this.mm1.posn.y, 200);
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
        //set the posn of the player to be on rr1
        this.y1.posn.y = this.rr1.posn.y;
        this.y1.posn.x = this.rr1.posn.x;
        //check those positions
        t.checkExpect(this.y1.posn.x, 310);
        t.checkExpect(this.y1.posn.y, 200);
        this.yWorld1.onTick();
        //check that the x position increased by 10
        t.checkExpect(this.y1.posn.x, 320);
        t.checkExpect(this.y1.posn.y, 200);
        t.checkExpect(this.c1.posn.x, 80);
        t.checkExpect(this.c1.posn.y, 100);
        t.checkExpect(this.rr1.posn.x, 320);
        t.checkExpect(this.rr1.posn.y, 200);
        t.checkExpect(this.mm1.posn.x, 380);
        t.checkExpect(this.mm1.posn.y, 200);
    }


    // 2.2.16 ////////////////////////////////////////////
    /** test the onKeyEvent method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testOnKeyEvent(Tester t) {
        reset();
        //check original position
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
        //call up, and test position
        this.yWorld1.onKeyEvent("up");
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 425);
        //call down, and test position
        this.yWorld1.onKeyEvent("down");
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
        //call left, and test position
        this.yWorld1.onKeyEvent("left");
        t.checkExpect(this.y1.posn.x, 450);
        t.checkExpect(this.y1.posn.y, 475);
        //call right, and test position
        this.yWorld1.onKeyEvent("right");
        t.checkExpect(this.y1.posn.x, 500);
        t.checkExpect(this.y1.posn.y, 475);
    }


    // 2.3.17 ////////////////////////////////////////////
    /** test the worldEnds method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testWorldEnds(Tester t) {
        reset();
        //test when nothing collides
        t.checkExpect(this.yWorld1.worldEnds(), 
                new WorldEnd(false, this.yWorld1.makeImage()));
        //set the y position to the ye' zone and test
        this.y1.posn.y = 25;
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(true, this.yWorld1.winState()));
        //check when the player collides with a car with 1 life
        this.y1.lives = 1;
        this.y1.posn = this.c1.posn;
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(true, this.yWorld1.lastImage("YOU DEAD.")));
        //check when the player collides with a car but has more than 1 life
        reset();
        this.y1.lives = 3;
        this.y1.posn = this.c1.posn;
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(false, this.yWorld1.makeImage()));
        //check when the player is in the water, 
        //not colliding with a RickRoss or MacMiller, lives > 1
        reset();
        this.y1.posn.x = this.rr1.posn.x + 100;
        this.y1.posn.y = 100;
        t.checkExpect(this.rr1.collide(this.y1), false);
        t.checkExpect(this.mm1.collide(this.y1), false);
        t.checkExpect(this.c1.collide(this.y1), false);
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(false, this.yWorld1.makeImage()));
        //check when the player is in the water, 
        //not colliding with a RickRoss or MacMiller, lives = 1
        reset();
        this.y1.posn.x = this.rr1.posn.x + 100;
        this.y1.posn.y = 100;
        this.y1.lives = 1;
        t.checkExpect(this.rr1.collide(this.y1), false);
        t.checkExpect(this.mm1.collide(this.y1), false);
        t.checkExpect(this.c1.collide(this.y1), false);
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(true, this.yWorld1.lastImage("YOU DROWNED.")));
        //check when the player collides with a RickRoss, with more than 1 life
        this.y1.posn = this.rr1.posn;
        this.y1.lives = 3;
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(false, this.yWorld1.makeImage()));
        //check when the player collides with a RickRoss, with more than 1 life
        this.y1.posn = this.mm1.posn;
        this.y1.lives = 3;
        t.checkExpect(this.yWorld1.worldEnds(),
                new WorldEnd(false, this.yWorld1.makeImage()));
    }


    // 2.2.18 ////////////////////////////////////////////
    /** test the makeImage method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testMakeImageYW(Tester t) {
        reset();
        //make the full image of the world//////////////////////////////////
        WorldImage stack1 = backgroundImage;
        WorldImage lifeCount = new TextImage(
                new Posn(900, 30), "Lives: 3", 30, 3, new Black());
        WorldImage stack2 = new OverlayImages(stack1, this.rr1.makeImage());
        WorldImage stack3 = new OverlayImages(stack2, mm1.makeImage());
        WorldImage stack4 = new OverlayImages(stack3, this.y1.makeImage());
        WorldImage stack5 = new OverlayImages(stack4, this.c1.makeImage());
        WorldImage fullStack = new OverlayImages(stack5, lifeCount);
        ////////////////////////////////////////////////////////////////////
        //test the makeImage function with the above image
        t.checkExpect(this.yWorld1.makeImage(), fullStack);
    }


    // 2.2.19 ////////////////////////////////////////////
    /** test the lastImage method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testLastImage(Tester t) {
        reset();
        t.checkExpect(this.yWorld1.lastImage("LOSE"),
                this.yWorld1.makeImage().overlayImages(
                        new TextImage(new Posn(500, 250), "LOSE", 
                                120, 3, new Red())));
    }


    // 2.2.20 ////////////////////////////////////////////
    /** test the winState method in yeezusworld
     * 
     * @author Austin Colcord
     */
    public void testWinState(Tester t) {
        reset();
        t.checkExpect(this.yWorld1.winState(),
                this.yWorld1.makeImage().overlayImages(
                        new TextImage(new Posn(500, 250), "YOU ARE A GOD", 
                                100, 3, new Red())));
    }


    // 2.3 - Game Running Objects /////////////////////////////////////////////
    // These are actually used in the game. 

    // YEEZUS ///////////////////////////
    Yeezus f1 = new Yeezus();

    // CARS ///////////////////////////
    // LANE 1 [FROM RHS -> LHS]
    Car cl11 = new Car(new Posn(975, 425), true, 5, "carLeft.png"); 
    Car cl12 = new Car(new Posn(900, 425), true, 5, "carLeft.png");
    Car cl13 = new Car(new Posn(800, 425), true, 5, "carLeft.png");
    Car cl14 = new Car(new Posn(400, 425), true, 5, "carLeft.png");
    // ...

    // LANE 2 [FROM LHS -> RHS]
    Car cl21 = new Car(new Posn(25, 375), false, 10, "carRight.png");
    // ...

    // LANE 3 [FROM RHS -> LHS]
    Car cl31 = new Car(new Posn(950, 325), true, 7, "carLeft.png");
    // ...

    // LANE 4 [FROM RHS -> LHS]
    Car cl41 = new Car(new Posn(50, 275), false, 13, "carRight.png");
    // ...

    // RICKROSS' & MACMILLERS ///////////////////////////
    // LANE 1 [FROM RHS -> LHS]
    RickRoss ll11 = new RickRoss(new Posn(50, 175), false, 5, rickRossRight);

    // LANE 2 [FROM LHS -> RHS]
    RickRoss ll21 = new RickRoss(new Posn(975, 125), true, 10, rickRossLeft);
    MacMiller ll22 = new MacMiller(new Posn(900, 125), true, 10, macMiller);


    // LANE 3 [FROM RHS -> LHS]
    RickRoss ll31 = new RickRoss(new Posn(100, 75), false, 7, rickRossRight);



    // ARRAYLISTS
    ArrayList<Car> carList = new ArrayList<Car>(
            Arrays.asList(this.cl11, this.cl12, this.cl13, this.cl14,
                    this.cl21, this.cl31, this.cl41));
    ArrayList<RickRoss> rrList = new ArrayList<RickRoss>(
            Arrays.asList(this.ll11, this.ll21, this.ll31));
    ArrayList<MacMiller> lpList = new ArrayList<MacMiller>(
            Arrays.asList(this.ll22));

    // YEEZUSWORLD
    YeezusWorld fworld = new YeezusWorld(this.f1, this.carList,
            this.rrList, this.lpList);


    /** Produce the initial YeezusWorld
     * @return the initial world that starts the game
     */
    public YeezusWorld initYeezusWorld() {
        return this.fworld;
    }




    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] argv) {
        ExamplesYeezusWorld ef = new ExamplesYeezusWorld();

        Tester.runReport(ef, false, false);
    }

}
