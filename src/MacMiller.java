import javalib.worldimages.Posn;





/** to represent a MacMiller floating in the water. 
 * @author Austin Colcord
 * @author Nick Alekhine
 *
 */
public class MacMiller extends MovingObject {
    MacMiller(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 50, 50);
    }
}
