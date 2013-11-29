import javalib.worldimages.Posn;

/** To represent a RickRoss floating on his back down the river. 
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public class RickRoss extends MovingObject {
    RickRoss(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 90, 50);
    }
}
