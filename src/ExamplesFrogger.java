import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;
import tester.*;


/** represents the examples, tests, and initial state of the frogger game 
 * 
 * @author Austin
 *
 */
public class ExamplesFrogger implements FroggerWorldConstants {
    
    // initial instance of a frog that is centered at the bottom
    // of the canvas, with 3 lives, and the image of the frog
    Frog frog;
    
    
    /** initialize objects */
    public void reset() {
        frog = new Frog();
    }
    
    // test the moveFrogUp
    public void testMoveFrogUp(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.y, (canvasHeight / 20));
        // call the method
        this.frog.moveFrogUp();
        // check the moved position
        t.checkExpect(this.frog.posn.y, 
                ((canvasHeight / 20) + (canvasHeight / 10)));
    }
    
    // test the moveFrogDown
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
    
    // test the moveFrogLeft
    public void testMoveFrogLeft(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.x, (canvasWidth / 2));
        this.frog.moveFrogLeft();
        t.checkExpect(this.frog.posn.x, 
                ((canvasWidth / 2) - (canvasWidth / 5)));
    }
    
    // test the moveFrogRight
    public void testMoveFrogRight(Tester t) {
        reset();
        t.checkExpect(this.frog.posn.x, (canvasWidth / 2));
        this.frog.moveFrogRight();
        t.checkExpect(this.frog.posn.x, 
                ((canvasWidth / 2) + (canvasWidth / 5)));
    }
    
   
}
