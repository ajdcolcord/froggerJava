import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

/** represents the car in the game */
public class Car implements FroggerWorldConstants{
    Posn posn;
    WorldImage image;
    
    Car(Posn posn) {
        this.posn = posn;
        this.image = image;
    }
}
