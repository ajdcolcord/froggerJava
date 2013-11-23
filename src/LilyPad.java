import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

/** represents the lilypads in the game that extends the 
 * AWaterObject class and its methods
 * @author Austin
 *
 */
public class LilyPad extends AWaterObject {
    LilyPad(Posn posn, WorldImage image) {
        super(posn, image);
    }
}
