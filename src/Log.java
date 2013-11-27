import javalib.worldimages.*;

/** represents the logs in the water. Implements MovingObject.
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public class Log extends MovingObject {
    Log(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 200, 50);
    }
}
