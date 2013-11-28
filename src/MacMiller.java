import javalib.worldimages.Posn;

/** represents the lilypads in the game that extends the MovingObject class and 
 *  its methods.
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public class MacMiller extends MovingObject {
    
    MacMiller(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 50, 50);
    }
}
