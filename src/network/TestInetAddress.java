package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by yeqf on 6/2/15.
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("local host name:" + inetAddress.getHostName());
            System.out.println("IP:" + inetAddress.getHostAddress());
            byte[] bt = inetAddress.getAddress();
            System.out.println(Arrays.toString(bt));
            byte[] bt2 = {119, 75, (byte) 217, 109};
            InetAddress inetAddress2 = InetAddress.getByAddress(bt2);

            System.out.println("address:" + inetAddress2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
