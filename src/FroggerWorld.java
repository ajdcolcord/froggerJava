/******************************************************************************
 * TABLE OF CONTENTS
 *   1. Libraries
 *   2. FroggerWorld
 *     2.1 FIELDS
 *       2.1.1 player   -- Frog
 *       2.1.2 cars     -- ArrayList<Log>
 *       2.1.3 logs     -- ArrayList<Car>
 *       2.1.4 LilyPads -- ArrayList<LilyPad>
 *     2.2 CONSTRUCTORS
 *       2.2.1 FroggerWorld()
 *       2.2.2 FroggerWorld(Frog, ArrayList<Car>,
 *                          ArrayList<Log>, ArrayList<LilyPad>)
 *     2.3 METHODS
 *       2.3.1 ticker()                     -- void
 *         2.3.1.1 moveWhenOnLilyPadOrLog() -- void
 *         2.3.1.2 moveObjects()            -- void
 *       2.3.2 keyEventer(String)           -- void
 *       2.3.3 worldEnder()                  -- WorldEnd
 *       2.3.4 render()                  -- WorldImage
 *       2.3.5 renderLast(String)            -- WorldImage
 * 
 *****************************************************************************/





// 1 - Libraries //////////////////////////////////////////////////////////////
import java.util.ArrayList;





// 2 - FroggerWorld ///////////////////////////////////////////////////////////
/** The world state. Consists of a frog, cars, logs, and lilypads. 
 * @author Austin Colcord
 * @author Nick Alekhine 
 * 
 * */
public class FroggerWorld {
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 - Fields ///////////////////////////////////////////////////////////
    Frog player;
    ArrayList<Car> cars;
    ArrayList<Log> logs;
    ArrayList<LilyPad> lilypads;




    ///////////////////////////////////////////////////////////////////////////
    // 2.2 - Constructors /////////////////////////////////////////////////////
    // 2.2.1 //////////////////////////////////////////////////////////////////
    FroggerWorld() {
        this.player = new Frog();
        this.cars = new ArrayList<Car>();
        this.logs = new ArrayList<Log>();
        this.lilypads = new ArrayList<LilyPad>();
    }

    // 2.2.2 //////////////////////////////////////////////////////////////////
    FroggerWorld(Frog player, ArrayList<Car> cars, 
                 ArrayList<Log> logs, ArrayList<LilyPad> lilypads) {
        this.player = player;
        this.cars = cars;
        this.logs = logs;
        this.lilypads = lilypads;
    }
}
