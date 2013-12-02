//CS 2510 Fall 2013
//Assignment 8
//partner1-Alekhine, Nick --alekhn
//partner2-Colcord, Austin --acolcord


import javalib.worldimages.Posn;





/** to represent a car
 * @author Austin Colcord
 * @author Nick Alekhine
 * */
public class Car extends MovingObject implements YeezusWorldConstants {
    Car(Posn posn, boolean facingLeft, int speed, String image) {
        super(posn, facingLeft, speed, image, 50, 50);
    }

}
