import java.util.Iterator;

import javalib.tunes.Note;
import javalib.tunes.SoundConstants;

// the ticky-tack song
public class Song implements SoundConstants, Iterable<Note> {

    Note a = new Note("A5n1");
    Note c2 = new Note("C4n2");
    Note d2 = new Note("D4n2");
    Note e2 = new Note("E4n2");
    Note e = new Note("E4n1");
    Note f2 = new Note("F4n2");
    Note f = new Note("F4n1");
    Note g2 = new Note("G4n2");
    Note g = new Note("G4n1");
    Note cup2 = new Note("C5n2");
    Note cup = new Note("C5n1");
    Note dup = new Note("D5n1");
    Note eup = new Note("E5n1");
    Note silent = new Note(0, 0);


    Note[] tickyTackSong = new Note[] {
            // li-ttle bo-xes
            this.g, this.a, this.e2, this.silent, this.c2, this.silent,     
            // on the hill side
            this.g, this.a, this.e2, this.silent, this.c2, this.silent,    
            // li-ttle bo-xes
            this.g, this.g, this.cup, this.silent, this.cup, this.silent,
            // made of ti-cky ta-cky
            this.cup, this.dup, this.eup, this.dup, this.cup2, this.silent,
            // li-ttle bo-xes
            this.cup, this.a, this.g2, this.silent, this.g2, this.silent,
            // li-ttle bo-xes
            this.g, this.a, this.f2, this.silent, this.f2, this.silent,
            // and they all look
            this.f, this.g, this.e2, this.silent, this.e2, this.silent, 
            // just the same
            this.e, this.f, this.d2, this.silent, this.silent, this.silent   
    };

    public Iterator<Note> iterator() {
        return new SongIterator(this.tickyTackSong);
    }
}