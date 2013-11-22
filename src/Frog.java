import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;

import java.awt.Color;

/** represents the frog that is controlled by the player */
public class Frog implements FroggerWorldConstants {
    Posn posn;
    int lives;
    WorldImage image;
    
    Frog() {
        this.posn = new Posn((canvasWidth / 2), (canvasHeight / 20));
        this.lives = 3;
        this.image = new FromFileImage(this.posn, "Frog.jpg");
                
    }
    
    /** move the frog up one step */
    public void moveFrogUp() {
        this.posn.y = this.posn.y + (canvasHeight / 10);
    }
    
    /** move the frog down one step, unless the frog is at the bottom
     * row, then do nothing
     */
    public void moveFrogDown() {
         if (this.posn.y <= (canvasHeight / 10)) {
             // if the frog is at the bottom row, don't do anything
             this.posn = this.posn;
         }
         else {
             this.posn.y = this.posn.y - (canvasHeight / 10);
         }
    }
    
    /** move the frog to the left, unless near the left edge of the canvas */
    public void moveFrogLeft() {
        if (this.posn.x <= (canvasWidth / 5)) {
            this.posn = this.posn;
        }
        else {
            this.posn.x = this.posn.x - (canvasWidth / 5);
        }
    }
    
    /**  move the frog to the right unless near the right edge of the canvas */
    public void moveFrogRight() {
        if (this.posn.x >= (canvasWidth - (canvasWidth / 5))) {
            this.posn = this.posn;
        }
        else {
            this.posn.x = this.posn.x + (canvasWidth / 5);
        }
    }
}
