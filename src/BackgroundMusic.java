
public class BackgroundMusic extends Thread {
    MakeSound sounder = new MakeSound();

    public void run() {
        this.sounder.playSound("power.wav");
    }
}
