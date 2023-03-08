package thread;

/**
 * 实现接口Runnable实现
 * 启动线程：Thread(目标对象).start()
 * 建议使用：避免单继承局限性,灵活方便，方便一个对象被多个线程使用
 */
public class RunnableSample implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("run线程-----" + i);
        }
    }

    public static void main(String[] args) {
        RunnableSample runnableSample = new RunnableSample();
        new Thread(runnableSample).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程-----" + i);
        }
    }
}
