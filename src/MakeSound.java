/******************************************************************************
 * This code was created by stackoverflow user greenLizard.
 * The original post can be found here:
 * http://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
 * 
 * 
 * We take no credit for the code. 
 * 
 * 
 * TABLE OF CONTENTS
 * 1. Import Libraries
 * 2. MakeSound
 *   2.1 Constants
 *   2.2 playSound(String) -- void
 * 
 * 
 ******************************************************************************/





// 1 - Import Libraries ///////////////////////////////////////////////////////
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;




// 2 - MakeSound //////////////////////////////////////////////////////////////
/** To make a sound by supplying a file to this class.
 * @author greenLizard
 * @author Nick Alekhine (editor) 
 * 
 * */
public class MakeSound {

    // 2.1 - Constants ////////////////////////////////////////////////////////
    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;

    
    
    
    
    
    // 2.2 - playSound(String) ////////////////////////////////////////////////
    /** Plays the sounds from the given file. 
     * @param filename the name of the file that is going to be played
     * @author greenLizard
     * @author Nick Alekhine (editor)
     * 
     */
    public void playSound(String filename){

        String strFilename = filename;

        // set soundFile to the supplied filename.
        try {
            soundFile = new File(strFilename);
        } 
        // if the supplied filename is incorrect.
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // set audioStream to the audio stream of the soundFile.
        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } 
        // if the supplied soundFile is not actually an audio stream. 
        catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        // set the format. 
        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, 
                                               audioFormat);
        
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } 
        catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // commence playing the audio. 
        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
}