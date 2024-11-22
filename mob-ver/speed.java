import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private Timer timer;
    private int interval = 1000; // Timer interval in milliseconds (1 second)

    public Game() {
        timer = new Timer();
    }

    // Start the game loop
    public void startGameLoop() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gameTick();
            }
        }, 0, interval); // 0 delay, and interval between ticks
    }

    // Double the game speed by halving the interval
    public void doubleGameSpeed() {
        timer.cancel(); // Stop the current timer
        timer = new Timer(); // Create a new timer
        interval /= 2; // Halve the interval
        startGameLoop(); // Restart with the new interval
        System.out.println("Game speed doubled! Interval: " + interval + "ms");
    }

    // Simulate a game tick
    public void gameTick() {
        System.out.println("Game tick at " + System.currentTimeMillis());
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.startGameLoop();

        // Simulate doubling speed after 5 seconds
        Thread.sleep(5000);
        game.doubleGameSpeed();
    }
}
