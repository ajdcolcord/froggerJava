import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;

import java.awt.Color;

/** represents the abstract class that contains all the 
 * fields for objects that are in the water
 * @author Austin
 *
 */
public class AWaterObject implements FroggerWorldConstants {
    Posn posn;
    WorldImage image;
    
    AWaterObject(Posn posn, WorldImage image) {
        this.posn = posn;
        this.image = image;
    }
    
   
}
