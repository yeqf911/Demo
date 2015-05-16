package thread;

/**
 * Created by yeqf on 5/16/15.
 * 当多个线程需要共享一个资源的时候，就需要实现Runnable接口
 * 来进行多线程的任务，共享一个资源什么时候该用synchronized
 * 关键字要想清楚。
 */
class MyThread implements Runnable {
    private int ticketNum = 5;
    private int testNum = 5;

	//共享一个资源的时候要用synchronized修饰符把代码块锁起来
	//也可以在方法内部用synchronized修饰符锁定一部分代码块
    @Override
    public /*synchronized*/ void run() {
        synchronized (this) {
            while (ticketNum > 0) {
                ticketNum--;
                System.out.println(Thread.currentThread().getName() +
                        " sheng yu piao shu: " + ticketNum);
            }
        }
        System.out.println("Hello");
        while (testNum > 0) {
            testNum--;
            System.out.println(Thread.currentThread().getName() +
                    " test count: " + testNum);
        }
    }


}

public class TicketRunnable{
    public static void main(String[] args) {
        MyThread tr = new MyThread();
        Thread t1 = new Thread(tr,"window1");
        Thread t2 = new Thread(tr,"window2");
        Thread t3 = new Thread(tr,"window3");

        //start the thread
        t1.start();
        t2.start();
        t3.start();
    }
}

