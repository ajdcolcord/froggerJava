import java.util.Iterator;

import javalib.tunes.Note;

// a circular iterator for the given Array of notes
// must play a silent note when pausing
public class SongIterator implements Iterator<Note> {

    Note[] song;
    int i;
    int len;

    SongIterator(Note[] song) {
        this.song = song;
        this.len = song.length;
        this.i = this.len - 1;
    }


    // circular iterator - never runs out of notes ot play
    public boolean hasNext() {
        return true;
    }

    // produce the next note to play
    public Note next() {
        this.i = (i + 1) % 48;
        return this.song[i];
    }

    // do nothing on remove
    public void remove() { }
}