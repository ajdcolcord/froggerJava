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

// 1. Libraries ////////////////////////////////////////////////////////////
import java.util.ArrayList;

import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;




import java.awt.Color;
import java.util.Iterator;

import javalib.colors.Red;
import javalib.soundworld.World;
import javalib.tunes.Note;
import javalib.tunes.SoundConstants;
import javalib.tunes.TuneBucket;
import javalib.worldimages.CircleImage;
import javalib.worldimages.DiskImage;
import javalib.worldimages.LineImage;
import javalib.worldimages.OvalImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.TriangleImage;
import javalib.worldimages.WorldEnd;
import tester.Tester;




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
    MovingObject car1;  //2.1.2

    // initial instance of a car that is at the second to bottom
    // row of the road, at the center of the screen, facing right
    MovingObject car2;  //2.1.3

    // initial instance of a log that is at the middle of the bottom
    // row of water, facing left
    MovingObject log1;

    // initial instance of a lilypad that is at the center of the middle
    // row of water, facing right
    MovingObject lily1;


    // an ArrayList of Cars that will be used to test the functions
    ArrayList<MovingObject> molist1;

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
                        5,
                        new FromFileImage(
                                new Posn((canvasWidth / 2), 
                                        ((canvasHeight / 20) * 3)), 
                                "CarLeft.jpg")); 
        car2 = new Car(
                new Posn ((canvasWidth / 2),
                        ((canvasHeight / 20) * 5)),
                        false,
                        5,
                        new FromFileImage(
                                new Posn ((canvasWidth / 2),
                                        ((canvasHeight / 20) * 5)),
                                "CarRight.jpg"));
        log1 = new Log(
                new Posn ((canvasWidth / 2),
                        ((canvasHeight / 20) * 13)),
                        true, 
                        5, 
                        new FromFileImage(
                                new Posn((canvasWidth / 2),
                                        (((canvasHeight / 20) * 13))), 
                                "Log.gif"));

        lily1 = new LilyPad(
                new Posn ((canvasWidth / 2),
                        ((canvasHeight / 20) * 15)), 
                        false, 
                        5,
                        new FromFileImage(
                                new Posn ((canvasWidth / 2),
                                        ((canvasHeight / 20) * 15)),
                                "LilyPad.png"));

        molist1 = new ArrayList<MovingObject>();
    }

    // 2.2.2 ////////////////////////////////////////////
    /** move all of the cars in the given arrayList by calling
     * the moveCarLeft method for cars facing left, and calling the
     * moveCarRight method for cars facing left
     * 
     * @param ArrayList<Car>
     * @author Austin Colcord
     */
    public void moveAllObjects(ArrayList<MovingObject> molist) {
        for (MovingObject mo : molist) {
            if (mo.facingLeft) {
                mo.moveObjectLeft();
            }
            else {
                mo.moveObjectRight();
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
    public void testMoveObjectLeft(Tester t) {
        reset();
        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
        this.car1.moveObjectLeft();
        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) - 5));
        this.car1.posn.x = -100;
        this.car1.moveObjectLeft();
        t.checkExpect(this.car1.posn.x, (canvasWidth + 100));
        t.checkExpect(this.log1.posn.x, (canvasWidth / 2));
        this.log1.moveObjectLeft();
        t.checkExpect(this.log1.posn.x, ((canvasWidth / 2) - 5));
        this.log1.posn.x = -110;
        this.log1.moveObjectLeft();
        t.checkExpect(this.log1.posn.x, (canvasWidth + 100));
        t.checkExpect(this.lily1.posn.x, (canvasWidth / 2));
        this.lily1.moveObjectLeft();
        t.checkExpect(this.lily1.posn.x, ((canvasWidth / 2) - 5));
        this.lily1.posn.x = -105;
        this.lily1.moveObjectLeft();
        t.checkExpect(this.lily1.posn.x, (canvasWidth + 100));
    }

    // 2.3.6 ////////////////////////////////////////////
    /** test the moveCarLeft
     * @author Austin Colcord
     */
    public void testMoveObjectRight(Tester t) {
        reset();
        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
        this.car1.moveObjectRight();
        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) + 5));
        this.car1.posn.x = (canvasWidth + 100);
        this.car1.moveObjectRight();
        t.checkExpect(this.car1.posn.x, -100);
        t.checkExpect(this.log1.posn.x, (canvasWidth / 2));
        this.log1.moveObjectRight();
        t.checkExpect(this.log1.posn.x, ((canvasWidth / 2) + 5));
        this.log1.posn.x = (canvasWidth + 120);
        this.log1.moveObjectRight();
        t.checkExpect(this.log1.posn.x, -100);
        t.checkExpect(this.lily1.posn.x, (canvasWidth / 2));
        this.lily1.moveObjectRight();
        t.checkExpect(this.lily1.posn.x, ((canvasWidth / 2) + 5));
        this.lily1.posn.x = (canvasWidth + 120);
        this.lily1.moveObjectRight();
        t.checkExpect(this.lily1.posn.x, -100);
    } 

    // 2.3.7 ////////////////////////////////////////////
    /** test the moveAllCars
     * 
     * @author Austin Colcord
     */
    public void testMoveAllObjects(Tester t) {
        reset();
        this.molist1.add(this.car1);
        this.molist1.add(this.car2);
        this.molist1.add(this.log1);
        this.molist1.add(this.lily1);
        t.checkExpect(this.car1.posn.x, (canvasWidth / 2));
        t.checkExpect(this.car2.posn.x, (canvasWidth / 2));
        t.checkExpect(this.log1.posn.x, (canvasWidth / 2));
        t.checkExpect(this.lily1.posn.x, (canvasWidth / 2));
        this.moveAllObjects(this.molist1);
        t.checkExpect(this.car1.posn.x, ((canvasWidth / 2) - 5));
        t.checkExpect(this.car2.posn.x, ((canvasWidth / 2) + 5));
        t.checkExpect(this.log1.posn.x, ((canvasWidth / 2) - 5));
        t.checkExpect(this.lily1.posn.x, ((canvasWidth / 2) + 5));

    }

    // 2.3.8 ////////////////////////////////////////////
    /** test the loseLife
     * 
     * @author Austin Colcord
     */
    public void testLoseLife(Tester t) {
        reset();
        t.checkExpect(this.frog.lives, 3);
        this.frog.loseLife();
        t.checkExpect(this.frog.lives, 2);
        this.frog.loseLife();
        t.checkExpect(this.frog.lives, 1);
    }



    // 2.3.9 ////////////////////////////////////////////
    /** test the collide
     * 
     * @author Austin Colcord
     */
    public void testCollide(Tester t) {
        reset();
        t.checkExpect(this.log1.collide(this.frog), false);
        this.frog.posn.y = this.log1.posn.y;
        t.checkExpect(this.log1.collide(this.frog), true);
        reset();
        t.checkExpect(this.log1.collide(this.frog), false);
        t.checkExpect(this.car1.collide(this.frog), false);
        this.frog.posn.y = this.car1.posn.y;
        t.checkExpect(this.car1.collide(this.frog), true);
        this.frog.posn.x = this.frog.posn.x + 100;
        t.checkExpect(this.car1.collide(this.frog), false);
    }




    GameRunner world = new GameRunner();

    // 2.3.9 - testWholeWorld /////////////////////////////////////////////////
    // to run the game
    void testWholeWorld(Tester t) {
        this.world.bigBang(500, 1000, 0.2);
    }



    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] argv) {
        ExamplesFrogger ef = new ExamplesFrogger();

        Tester.runReport(ef, false, false);
    }

}
