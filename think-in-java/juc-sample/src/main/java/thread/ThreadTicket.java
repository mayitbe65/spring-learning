package thread;


public class ThreadTicket implements Runnable {

    private Integer ticketNums = 20;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            synchronized (this) {
                if (ticketNums <= 0) {
                    flag = false;
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢到第" + ticketNums-- + "张票");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        ThreadTicket threadTicket = new ThreadTicket();
        new Thread(threadTicket, "张三").start();
        new Thread(threadTicket, "李四").start();
        new Thread(threadTicket, "王五").start();
    }
}
