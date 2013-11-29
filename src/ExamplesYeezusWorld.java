/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. ExamplesFrogger
 *      2.1 EXAMPLES OF OBJECTS
 *          2.1.1 frog      -- Frog
 *          2.1.2 car1      -- Car
 *          2.1.3 car2      -- Car
 *          2.1.4
 *          2.1.4 clist1    -- ArrayList<Car>
 *      2.2 METHODS
 *          2.2.1 reset()                           -- void
 *          2.2.2 moveAllCars(ArrayList<Car> clist) -- void
 *      2.3 TESTS OF METHODS
 *          2.3.1 testMoveFrogUp()
 *          2.3.2 testMoveFrogDown()
 *          2.3.3 testMoveFrogLeft()
 *          2.3.4 testMoveFrogRight()
 *          2.3.5 testMoveCarLeft()
 *          2.3.6 testMoveCarRight()
 *          2.3.7 testMoveAllCars()
 *          2.3.8 testLoseLife()
 *          2.3.9 testCollide()
 *          2.3.9 testWholeWorld()
 *          
 *          
 *****************************************************************************/

// 1 - Libraries //////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Arrays;

import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import tester.Tester;





// 2 - ExamplesFrogger ////////////////////////////////////////////////////////
/** represents the examples, tests, and initial state of the frogger game 
 * 
 * @author Austin Colcord
 *
 */
public class ExamplesYeezusWorld implements YeezusWorldConstants {

    // 2.1 - Test Objects /////////////////////////////////////////////////////
    // initialize test objects. 

    // FROGS
    Yeezus y1;

    // CARS
    Car c1;

    // LOGS
    RickRoss rr1;

    // LILYPADS
    MacMiller mm1;

    // ARRAYLISTS
    ArrayList<Car> clistmt; // non-empty case
    ArrayList<Car> clist1; // empty case

    ArrayList<RickRoss> rrlistmt; // non-empty case
    ArrayList<RickRoss> rrlist1; // empty case

    ArrayList<MacMiller> mmlistmt; // non-empty case
    ArrayList<MacMiller> mmlist1; // empty case

    // initialize values in test objects
    public void reset() {
        this.y1 = new Yeezus();
        this.c1 = new Car(new Posn(100, 100), true, 10, "carLeft.png");
        this.rr1 = new RickRoss(new Posn(300, 200), false, 10, "rickRossRight.png");
        this.mm1 = new MacMiller(new Posn(400, 200), true, 10, "macMiller.png");

        this.clistmt = new ArrayList<Car>();
        this.clist1 = new ArrayList<Car>();
        this.clist1.add(this.c1);

        this.rrlistmt = new ArrayList<RickRoss>();
        this.rrlist1 = new ArrayList<RickRoss>();
        this.rrlist1.add(this.rr1);

        this.mmlistmt = new ArrayList<MacMiller>();
        this.mmlist1 = new ArrayList<MacMiller>();
        this.mmlist1.add(this.mm1);
    }


    // 2.3 Tests of Methods //////////////////////////////////////////////////

    // 2.3.1 ////////////////////////////////////////////
    /** test the moveUp method
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


    // 2.3.2 ////////////////////////////////////////////
    /** test the movedDown method
     * @author Austin Colcord
     */
    public void testMoveDown(Tester t) {
        reset();
        t.checkExpect(this.y1.posn.y, 475);
        // call the method
        this.y1.moveDown();
        // check the moved position, which won't be moved because
        // the frog is close to the bottom border
        t.checkExpect(this.y1.posn.y, 475);
        // setting to a higher position to test again
        this.y1.posn.y = canvasHeight;
        this.y1.moveDown();
        t.checkExpect(this.y1.posn.y, 500);
    }

    // 2.3.3 ////////////////////////////////////////////
    /** test the moveLeft
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

    // 2.3.4 ////////////////////////////////////////////
    /** test the moveRight
     * @author Austin Colcord
     */
    public void testMoveRight(Tester t) {
        reset();
        //check the original position
        t.checkExpect(this.y1.posn.x,500);
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

    // 2.3.5 ////////////////////////////////////////////
    /** test the moveCarLeft
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

    // 2.3.6 ////////////////////////////////////////////
    /** test the moveCarLeft
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


    // 2.3.8 ////////////////////////////////////////////
    /** test the loseLife
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



    // 2.3.9 ////////////////////////////////////////////
    /** test the collide
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

    // 2.3.10 ////////////////////////////////////////////
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


    // 2.3.11 ////////////////////////////////////////////
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


    // 2.3.12 ////////////////////////////////////////////
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



    // 2.3.13 ////////////////////////////////////////////
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




    // 2.2 - Game Running Objects /////////////////////////////////////////////
    // These are actually used in the game. 

    // FROG ///////////////////////////
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

    // LOGS ///////////////////////////
    // LANE 1 [FROM RHS -> LHS]
    RickRoss ll11 = new RickRoss(new Posn(50, 175), false, 5, rickRossRight);

    // LANE 2 [FROM LHS -> RHS]
    RickRoss ll21 = new RickRoss(new Posn(975, 125), true, 10, rickRossLeft);
    MacMiller ll22 = new MacMiller(new Posn(900, 125), true, 10, macMiller);


    // LANE 3 [FROM RHS -> LHS]
    RickRoss ll31 = new RickRoss(new Posn(100, 75), false, 7, rickRossRight);


    // LILYPADS ///////////////////////

    // ARRAYLISTS
    ArrayList<Car> carList = new ArrayList<Car>(
            Arrays.asList(this.cl11, this.cl12, this.cl13, this.cl14,
                    this.cl21, this.cl31, this.cl41));
    ArrayList<RickRoss> logList = new ArrayList<RickRoss>(
            Arrays.asList(this.ll11, this.ll21, this.ll31));
    ArrayList<MacMiller> lpList = new ArrayList<MacMiller>(
            Arrays.asList(this.ll22));

    // FROGGERWORLD
    YeezusWorld fworld = new YeezusWorld(this.f1, this.carList,
            this.logList, this.lpList);


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