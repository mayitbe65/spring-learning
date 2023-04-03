package container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现容器，提供两个方法add、size
 * 启动两个线程
 * 线程1添加10个元素到容器中
 * 线程2实现监控元素个数，当个数到5个时，线程2给出提示并结束
 */
public class LockNotifySample {
    static volatile List<Integer> countList = new ArrayList<>();

    public void add(Integer i) {
        countList.add(i);
    }

    public int size() {
        return countList.size();
    }


    public static void main(String[] args) {

        LockNotifySample sms = new LockNotifySample();

        final Object lock = new Object();

        new Thread(() -> {
            System.out.println("线程2启动");
            synchronized (lock) {
                if (sms.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2检测到计数=5，break");
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("线程1启动");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (sms.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sms.add(i);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("添加元素 " + i);
                }
            }

        }, "t1").start();
    }

}
