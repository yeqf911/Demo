package stabalpartner;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by yeqf on 5/25/15.
 */
public class StablePartner {
    private final static int g1 = 0;
    private final static int g2 = 1;
    private final static int g3 = 2;
    private final static int b1 = 0;
    private final static int b2 = 1;
    private final static int b3 = 2;


    public static void main(String[] args) {
        Boy[] boys = new Boy[3];
        boys[0] = new Boy(g2, 5, g1);
        boys[1] = new Boy(g1, g2, g3);
        boys[2] = new Boy(g3, g2, g1);
        Girl[] girls = new Girl[3];
        girls[0] = new Girl(b3, b2, b1);
        girls[1] = new Girl(b1, b3, b2);
        girls[2] = new Girl(b3, b2, b1);

        boolean flag = true;

        while (flag) {
            for (int i = 0; i < 3; i++) {
                if (!boys[i].hasPart()) {
                    for (int j = 0; j < 3; j++) {
                        int currgirl = boys[i].getGirl(j);
                        if (!girls[currgirl].hasPart()) {
                            girls[currgirl].setPartner(i);
                            boys[i].setPartner(currgirl);
                            break;
                        } else if (girls[currgirl].getId(i) >
                                girls[currgirl].getId(girls[currgirl].getPartner())) {
                            boys[girls[currgirl].getPartner()].setPartner(-1);
                            girls[currgirl].setPartner(i);
                            boys[i].setPartner(currgirl);
                            break;
                        }
                    }
                }
            }

            if (boys[0].hasPart() && boys[1].hasPart() && boys[2].hasPart()) {
                flag = false;
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("boy " + i + " de partner is "
                    + "girl " + boys[i].getPartner());
        }
    }

    private static class Boy {
        private int[] girls = new int[3];
        private int partner = -1;

        public Boy(int a, int b, int c) {
            girls[0] = a;
            girls[1] = b;
            girls[2] = c;
        }

        public int getPartner() {
            return partner;
        }

        public void setPartner(int partner) {
            this.partner = partner;
        }

        public boolean hasPart() {
            return (partner != -1);
        }

        public int getGirl(int girlId) {
            return girls[girlId];
        }
    }

    private static class Girl {
        private int[] boys = new int[3];
        private int partner = -1;

        public Girl(int a, int b, int c) {
            boys[0] = a;
            boys[1] = b;
            boys[2] = c;
        }

        public int getPartner() {
            return partner;
        }

        public void setPartner(int partner) {
            this.partner = partner;
        }

        public boolean hasPart() {
            return (partner != -1);
        }

     /*   public int getBoys(int boyId) {
            return boys[boyId];
        }*/

        public int getId(int boy) {
            int i = 0;
            while (boys[i] != boy) {
                i++;
            }
            return i;
        }
    }
}
