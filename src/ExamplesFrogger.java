/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. ExamplesFrogger
 *      2.1 EXAMPLES OF OBJECTS
 *          2.1.1 frog      -- Frog
 *          2.1.2 car1      -- Car
 *          2.1.3 car2      -- Car
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
 *          
 *          
 *****************************************************************************/

// 1. Libraries ////////////////////////////////////////////////////////////
import java.util.ArrayList;

import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;
import tester.*;
////////////////////////////////////////////////////////////////////////////



//2. ExamplesFrogger ///////////////////////////////////////////////////////
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
    Car car1;  //2.1.2

    // initial instance of a car that is at the second to bottom
    // row of the road, at the center of the screen, facing right
    Car car2;  //2.1.3

    // an ArrayList of Cars that will be used to test the functions
    ArrayList<Car> clist1;

    /////////////////////////////////////////////////////////////////////



    // 2.2 Methods ////////////////////////////////////////////////////////

    // 2.2.1 ////////////////////////////////////////////
    /** initialize objects to these states
     *  @author Austin Colcord
     *  */
    public void reset() {
        frog = new Frog();
        car1 = new Car(
                new Posn((canvasWidth / 2), 
                        ((canvasHeight / 20) * 3)),
                        true,
                        new FromFileImage(
                                new Posn((canvasWidth / 2), 
                                        ((canvasHeight / 20) * 3)), 
                                "CarLeft.jpg"));
        car2 = new Car(
                new Posn ((canvasWidth / 2),
                        ((canvasHeight / 20) * 5)),
                        false,
                        new FromFileImage(
                                new Posn ((canvasWidth / 2),
                                        ((canvasHeight / 20) * 5)),
                                "CarRight.jpg"));
        clist1 = new ArrayList<Car>();
    }

    // 2.2.2 ////////////////////////////////////////////
    /** move all of the cars in the given arrayList by calling
     * the moveCarLeft method for cars facing left, and calling the
     * moveCarRight method for cars facing left
     * 
     * @param ArrayList<Car>
     * @author Austin Colcord
     */
    public void moveAllCars(ArrayList<Car> clist) {
        for (Car c : clist) {
            if (c.facingLeft) {
                c.moveCarLeft();
            }
            else {
                c.moveCarRight();
            }
        }
    }



    /////////////////////////////////////////////////////////////////////



    // 2.3 Tests of Methods //////////////////////////////////////////////////

    // 2.3.1 ////////////////////////////////////////////
    /** test the moveFrogUp
     * @author Austin Colcord
     */
    public void testMoveFrogUp(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
        // call the method
        this.frog.moveFrogUp();
        // check the moved position
        t.checkExpect(this.frog.posn.y, 
                ((canvasHeight / 20) + (canvasHeight / 10)));
    }


    // 2.3.2 ////////////////////////////////////////////
    /** test the moveFrogDown
     * @author Austin Colcord
     */
    public void testMoveFrogDown(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
        // call the method
        this.frog.moveFrogDown();
        // check the moved position, which won't be moved because
        // the frog is close to the bottom border
        t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
        // setting to a higher position to test again
        this.frog.posn.y = canvasHeight;
        this.frog.moveFrogDown();
        t.checkExpect(this.frog.posn.y, (canvasHeight - (canvasHeight / 10)));
    }

    // 2.3.3 ////////////////////////////////////////////
    /** test the moveFrogLeft
     * @author Austin Colcord
     */
    public void testMoveFrogLeft(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.x, (canvasWidth / 2));
        this.frog.moveFrogLeft();
        t.checkExpect(this.frog.posn.x, 
                ((canvasWidth / 2) - (canvasWidth / 5)));
        this.frog.posn.x = (canvasWidth / 20);
        this.frog.moveFrogLeft();
        t.checkExpect(this.frog.posn.x, (canvasWidth / 20));
    }

    // 2.3.4 ////////////////////////////////////////////
    /** test the moveFrogRight
     * @author Austin Colcord
     */
    public void testMoveFrogRight(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.x, (canvasWidth / 2));
        this.frog.moveFrogRight();
        t.checkExpect(this.frog.posn.x, 
                ((canvasWidth / 2) + (canvasWidth / 5)));
        this.frog.posn.x = ((canvasWidth / 20) * 19);
        this.frog.moveFrogRight();
        t.checkExpect(this.frog.posn.x, ((canvasWidth / 20) * 19));
    }

    // 2.3.5 ////////////////////////////////////////////
    /** test the moveCarLeft
     * @author Austin Colcord
     */
    public void testMoveCarLeft(Tester t) {
        reset();
        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
        this.car1.moveCarLeft();
        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) - 5));
        this.car1.posn.x = -100;
        this.car1.moveCarLeft();
        t.checkExpect(this.car1.posn.x, (canvasWidth + 100));
    }

    // 2.3.6 ////////////////////////////////////////////
    /** test the moveCarLeft
     * @author Austin Colcord
     */
    public void testMoveCarRight(Tester t) {
        reset();
        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
        this.car1.moveCarRight();
        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) + 5));
        this.car1.posn.x = (canvasWidth + 100);
        this.car1.moveCarRight();
        t.checkExpect(this.car1.posn.x, -100);
    }

    // 2.3.7 ////////////////////////////////////////////
    public void testMoveAllCars(Tester t) {
        reset();
        this.clist1.add(this.car1);
        this.clist1.add(this.car2);
        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
        t.checkExpect(this.car2.posn.x, (canvasWidth / 2));
        this.moveAllCars(this.clist1);
        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) - 5));
        t.checkExpect(this.car2.posn.x, ((canvasWidth / 2) + 5));
    }

    // 2.3.8 ////////////////////////////////////////////
    public void testLoseLife(Tester t) {
        reset();
        t.checkExpect(this.frog.lives, 3);
        this.frog.loseLife();
        t.checkExpect(this.frog.lives, 2);
        this.frog.loseLife();
        t.checkExpect(this.frog.lives, 1);
    }
    }
