import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private int correctAnswer;
    private static Timer timer;
    private int seconds;
    private boolean gameEnded;

    public QuizApp() {
        correctAnswer = 0;
        seconds = 0;
        gameEnded = false;
    }

    public void start() {

        System.out.println("Welcome to the QuizApp!");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                System.out.println("Time remaining: " + (30 - seconds));
                if (seconds == 30) {
                    endGame();
                }
            }
        }, 0, 1000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the color of the sky?");
        System.out.println("1. Red");
        System.out.println("2. Blue");
        System.out.println("3. Green");

        int userAnswer = scanner.nextInt();
        correctAnswer = 2;

        if (userAnswer == correctAnswer) {
            System.out.println("Correct! Your score is 1.");
        } else {
            System.out.println("Incorrect. Your score is 0.");
        }
    }

    public void endGame() {
        if (!gameEnded) {
            gameEnded = true;
            timer.cancel();
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.start();
    }
}
