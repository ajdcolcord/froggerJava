import javalib.worldimages.Posn;

/** represents the lilypads in the game that extends the MovingObject class and 
 *  its methods.
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public class LilyPad extends MovingObject {
    
    LilyPad(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 50, 50);
    }
}
