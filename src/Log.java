import javalib.colors.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;

import java.awt.Color;

/** represents the logs in the water, implementing the abstract
 * class AWaterObject and it's methods
 * @author Austin
 *
 */
public class Log extends MovingObject {
    Log(Posn posn, boolean facingLeft, int speed, WorldImage image) {
        super(posn, facingLeft, speed, image);
        this.width = 266;
        this.height = 100;
    }
}
