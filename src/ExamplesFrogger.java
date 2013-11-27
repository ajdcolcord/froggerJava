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
public class ExamplesFrogger implements FroggerWorldConstants {

    // 2.1 Examples of Objects ///////////////////////////////////////////////

    // initial instance of a frog that is centered at the bottom
    // of the canvas, with 3 lives, and the image of the frog
    Frog frog; //2.1.1

    // initial instance of a car that is at the bottom row of the road,
    // at the center of the screen, facing left
    MovingObject car1;  //2.1.2

    // initial instance of a car that is at the second to bottom
    // row of the road, at the center of the screen, facing right
    MovingObject car2;  //2.1.3

    // initial instance of a log that is at the middle of the bottom
    // row of water, facing left
    MovingObject log1;

    // initial instance of a lilypad that is at the center of the middle
    // row of water, facing right
    MovingObject lp1;
    
    // an ArrayList of Cars that will be used to test the functions
    ArrayList<MovingObject> molist1;

    /////////////////////////////////////////////////////////////////////


    Frog f1 = new Frog();
    Car c1 = new Car(
              new Posn(250, 400),
              true,
              5,
              "carLeft.png"); 
    
    ArrayList<Car> carList = new ArrayList<Car>(Arrays.asList(this.c1));
    ArrayList<Log> logList = new ArrayList<Log>();
    ArrayList<LilyPad> lpList = new ArrayList<LilyPad>();
    

    FroggerWorld fworld = new FroggerWorld(this.f1, this.carList,
            this.logList, this.lpList);
    GameRunner runner = new GameRunner(fworld);





    // 2.2 Methods ////////////////////////////////////////////////////////

//    // 2.2.1 ////////////////////////////////////////////
//    /** initialize objects to these states
//     *  @author Austin Colcord
//     *  */
//    public void reset() {
//        frog = new Frog();
//
//        car1 = new Car(
//                new Posn((canvasWidth / 2), 
//                        ((canvasHeight / 20) * 3)),
//                        true,
//                        5,
//                        new FromFileImage(
//                                new Posn((canvasWidth / 2), 
//                                        ((canvasHeight / 20) * 3)), 
//                                "carLeft.png")); 
//        car2 = new Car(
//                new Posn ((canvasWidth / 2),
//                        ((canvasHeight / 20) * 5)),
//                        false,
//                        5,
//                        new FromFileImage(
//                                new Posn ((canvasWidth / 2),
//                                        ((canvasHeight / 20) * 5)),
//                                "carRight.png"));
//        log1 = new Log(
//                new Posn ((canvasWidth / 2),
//                        ((canvasHeight / 20) * 13)),
//                        true, 
//                        5, 
//                        new FromFileImage(
//                                new Posn((canvasWidth / 2),
//                                        (((canvasHeight / 20) * 13))), 
//                                "log.png"));
//
//        lp1 = new LilyPad(
//                new Posn ((canvasWidth / 2),
//                        ((canvasHeight / 20) * 15)), 
//                        false, 
//                        5,
//                        new FromFileImage(
//                                new Posn ((canvasWidth / 2),
//                                        ((canvasHeight / 20) * 15)),
//                                "lilyPad.png"));
//
//        molist1 = new ArrayList<MovingObject>();
//        
//    }
//
//    // 2.2.2 ////////////////////////////////////////////
//    /** move all of the objects in the given arrayList by calling
//     * the moveObjectLeft method for cars facing left, and calling the
//     * moveObjectRight method for cars facing left
//     * 
//     * @param ArrayList<Object>
//     * @author Austin Colcord
//     */
//    public void moveAllObjects(ArrayList<MovingObject> molist) {
//        for (MovingObject mo : molist) {
//            if (mo.facingLeft) {
//                mo.moveObjectLeft();
//            }
//            else {
//                mo.moveObjectRight();
//            }
//        }
//    }
//
//    // 2.2.2 ////////////////////////////////////////////
//    /** check to see if the frog has collided with any of
//     * the objects in the given ArrayList<MovingObject>.
//     * if it has collided with a car, call the loseLife 
//     * method on the frog, else do nothing
//     * @param ArrayList<MovingObject>
//     * @author Austin Colcord
//     */
//    /*public void collideAny(Frog f, ArrayList<MovingObject> molist) {
//        for (MovingObject mo : molist) {
//            if (mo instanceof Car) {
//
//            }
//        }
//    } */
//
//
//    /////////////////////////////////////////////////////////////////////
//
//
//
//    // 2.3 Tests of Methods //////////////////////////////////////////////////
//
//    // 2.3.1 ////////////////////////////////////////////
//    /** test the moveFrogUp
//     * @author Austin Colcord
//     */
//    public void testMoveFrogUp(Tester t) {
//        reset();
//        //t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
//        // call the method
//        this.frog.moveFrogUp();
//        // check the moved position
//        t.checkExpect(this.frog.posn.y, 
//                ((canvasHeight / 20) + (canvasHeight / 10)));
//    }
//
//
//    // 2.3.2 ////////////////////////////////////////////
//    /** test the moveFrogDown
//     * @author Austin Colcord
//     */
//    public void testMoveFrogDown(Tester t) {
//        reset();
//        t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
//        // call the method
//        this.frog.moveFrogDown();
//        // check the moved position, which won't be moved because
//        // the frog is close to the bottom border
//        t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
//        // setting to a higher position to test again
//        this.frog.posn.y = canvasHeight;
//        this.frog.moveFrogDown();
//        t.checkExpect(this.frog.posn.y, (canvasHeight - (canvasHeight / 10)));
//    }
//
//    // 2.3.3 ////////////////////////////////////////////
//    /** test the moveFrogLeft
//     * @author Austin Colcord
//     */
//    public void testMoveFrogLeft(Tester t) {
//        reset();
//        t.checkExpect(this.frog.posn.x, (canvasWidth / 2));
//        this.frog.moveFrogLeft();
//        t.checkExpect(this.frog.posn.x, 
//                ((canvasWidth / 2) - (canvasWidth / 5)));
//        this.frog.posn.x = (canvasWidth / 20);
//        this.frog.moveFrogLeft();
//        t.checkExpect(this.frog.posn.x, (canvasWidth / 20));
//    }
//
//    // 2.3.4 ////////////////////////////////////////////
//    /** test the moveFrogRight
//     * @author Austin Colcord
//     */
//    public void testMoveFrogRight(Tester t) {
//        reset();
//        t.checkExpect(this.frog.posn.x, (canvasWidth / 2));
//        this.frog.moveFrogRight();
//        t.checkExpect(this.frog.posn.x, 
//                ((canvasWidth / 2) + (canvasWidth / 5)));
//        this.frog.posn.x = ((canvasWidth / 20) * 19);
//        this.frog.moveFrogRight();
//        t.checkExpect(this.frog.posn.x, ((canvasWidth / 20) * 19));
//    }
//
//    // 2.3.5 ////////////////////////////////////////////
//    /** test the moveCarLeft
//     * @author Austin Colcord
//     */
//    public void testMoveObjectLeft(Tester t) {
//        reset();
//        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
//        this.car1.moveObjectLeft();
//        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) - 5));
//        this.car1.posn.x = -100;
//        this.car1.moveObjectLeft();
//        t.checkExpect(this.car1.posn.x, (canvasWidth + 100));
//        t.checkExpect(this.log1.posn.x, (canvasWidth / 2));
//        this.log1.moveObjectLeft();
//        t.checkExpect(this.log1.posn.x, ((canvasWidth / 2) - 5));
//        this.log1.posn.x = -110;
//        this.log1.moveObjectLeft();
//        t.checkExpect(this.log1.posn.x, (canvasWidth + 100));
//        t.checkExpect(this.lp1.posn.x, (canvasWidth / 2));
//        this.lp1.moveObjectLeft();
//        t.checkExpect(this.lp1.posn.x, ((canvasWidth / 2) - 5));
//        this.lp1.posn.x = -105;
//        this.lp1.moveObjectLeft();
//        t.checkExpect(this.lp1.posn.x, (canvasWidth + 100));
//    }
//
//    // 2.3.6 ////////////////////////////////////////////
//    /** test the moveCarLeft
//     * @author Austin Colcord
//     */
//    public void testMoveObjectRight(Tester t) {
//        reset();
//        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
//        this.car1.moveObjectRight();
//        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) + 5));
//        this.car1.posn.x = (canvasWidth + 100);
//        this.car1.moveObjectRight();
//        t.checkExpect(this.car1.posn.x, -100);
//        t.checkExpect(this.log1.posn.x, (canvasWidth / 2));
//        this.log1.moveObjectRight();
//        t.checkExpect(this.log1.posn.x, ((canvasWidth / 2) + 5));
//        this.log1.posn.x = (canvasWidth + 120);
//        this.log1.moveObjectRight();
//        t.checkExpect(this.log1.posn.x, -100);
//        t.checkExpect(this.lp1.posn.x, (canvasWidth / 2));
//        this.lp1.moveObjectRight();
//        t.checkExpect(this.lp1.posn.x, ((canvasWidth / 2) + 5));
//        this.lp1.posn.x = (canvasWidth + 120);
//        this.lp1.moveObjectRight();
//        t.checkExpect(this.lp1.posn.x, -100);
//    } 
//
//    // 2.3.7 ////////////////////////////////////////////
//    /** test the moveAllCars
//     * 
//     * @author Austin Colcord
//     */
//    public void testMoveAllObjects(Tester t) {
//        reset();
//        this.molist1.add(this.car1);
//        this.molist1.add(this.car2);
//        this.molist1.add(this.log1);
//        this.molist1.add(this.lp1);
//        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
//        t.checkExpect(this.car2.posn.x, (canvasWidth / 2));
//        t.checkExpect(this.log1.posn.x, (canvasWidth / 2));
//        t.checkExpect(this.lp1.posn.x, (canvasWidth / 2));
//        this.moveAllObjects(this.molist1);
//        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) - 5));
//        t.checkExpect(this.car2.posn.x, ((canvasWidth / 2) + 5));
//        t.checkExpect(this.log1.posn.x, ((canvasWidth / 2) - 5));
//        t.checkExpect(this.lp1.posn.x, ((canvasWidth / 2) + 5));
//
//    }
//
//    // 2.3.8 ////////////////////////////////////////////
//    /** test the loseLife
//     * 
//     * @author Austin Colcord
//     */
//    public void testLoseLife(Tester t) {
//        reset();
//        t.checkExpect(this.frog.lives, 3);
//        this.frog.loseLife();
//        t.checkExpect(this.frog.lives, 2);
//        this.frog.loseLife();
//        t.checkExpect(this.frog.lives, 1);
//    }
//
//
//
//    // 2.3.9 ////////////////////////////////////////////
//    /** test the collide
//     * 
//     * @author Austin Colcord
//     */
//    public void testCollide(Tester t) {
//        reset();
//        t.checkExpect(this.log1.collide(this.frog), false);
//        this.frog.posn.y = this.log1.posn.y;
//        t.checkExpect(this.log1.collide(this.frog), true);
//        reset();
//        t.checkExpect(this.log1.collide(this.frog), false);
//        t.checkExpect(this.car1.collide(this.frog), false);
//        this.frog.posn.y = this.car1.posn.y;
//        t.checkExpect(this.car1.collide(this.frog), true);
//        this.frog.posn.x = this.frog.posn.x + 100;
//        t.checkExpect(this.car1.collide(this.frog), false);
//    }




    // 2.3.9 - testWholeWorld /////////////////////////////////////////////////
    // to run the game
    void testWholeWorld(Tester t) {
        this.runner.bigBang(1000, 500, 0.2);
    }



    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] argv) {
        ExamplesFrogger ef = new ExamplesFrogger();

        Tester.runReport(ef, false, false);
    }

}
