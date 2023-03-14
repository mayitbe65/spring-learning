package thread;

public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "跑了第" + i + "步");
            if (gameOver(i)) {
                break;
            }
        }
    }

    public boolean gameOver(Integer step) {
        if (winner != null) {
            return true;
        }

        if (step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("冠军是: " + winner);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
