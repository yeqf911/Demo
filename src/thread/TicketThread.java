package thread;

/**
 * Created by yeqf on 5/16/15.
 */
public class TicketThread extends Thread {
    private int ticketNum = 5;
    private String name;

    public TicketThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketNum > 0) {
            ticketNum--;
            System.out.println(name + " sheng yu piao shu wei: " + ticketNum);
        }
    }

    public static void main(String[] args) {
        TicketThread t1 = new TicketThread("window1");
        TicketThread t2 = new TicketThread("window2");
        TicketThread t3 = new TicketThread("window3");

        //start the Thread
        t1.start();
        t2.start();
        t3.start();
    }
}
