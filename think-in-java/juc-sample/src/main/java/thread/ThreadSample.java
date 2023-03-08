package thread;


/**
 * 继承Thread类实现
 * 启动线程：子类对象.start()
 * 不建议使用：避免OOP单继承局限性
 */
public class ThreadSample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("run线程-----" + i);
        }
    }

    public static void main(String[] args) {
        ThreadSample threadSample = new ThreadSample();
        threadSample.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程-----" + i);
        }
    }
}
