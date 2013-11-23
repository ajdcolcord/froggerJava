import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

/** represents the lilypads in the game that extends the 
 * AWaterObject class and its methods
 * @author Austin
 *
 */
public class LilyPad extends AWaterObject {
    LilyPad(Posn posn, boolean facingLeft, int speed, WorldImage image) {
        super(posn, facingLeft, speed, image);
        this.width = 100;
        this.height = 100;
    }
}
