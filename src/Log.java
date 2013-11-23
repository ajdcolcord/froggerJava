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
public class Log extends AWaterObject {
    Log(Posn posn, WorldImage image) {
        super(posn, image);
    }
}