//CS 2510 Fall 2013
//Assignment 8
//partner1-Alekhine, Nick --alekhn
//partner2-Colcord, Austin --acolcord


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
