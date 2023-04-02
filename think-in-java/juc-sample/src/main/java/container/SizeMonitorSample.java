package container;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现容器，提供两个方法add、size
 * 启动两个线程
 * 线程1添加10个元素到容器中
 * 线程2实现监控元素个数，当个数到5个时，线程2给出提示并结束
 */
public class SizeMonitorSample {

    static volatile List<Integer> countList = new ArrayList<>();
    static volatile boolean interruptedState = false;

    public synchronized void add(Integer i) {
        countList.add(i);
    }

    public synchronized int size() {
        return countList.size();
    }


    public static void main(String[] args) {

        SizeMonitorSample sms = new SizeMonitorSample();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (interruptedState) {
                    System.out.println("线程1结束");
                    break;
                }
                sms.add(i);
                System.out.println("添加元素 " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
//                System.out.println("线程2获取大小" + countList.size());
                if (sms.size() == 5) {
                    interruptedState = true;
//                    try {
//                        t1.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    break;
                }
            }
            System.out.println("线程2检测到计数=5，break");
        });

        t1.start();
        t2.start();
    }
}
