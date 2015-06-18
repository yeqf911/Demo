package stabalpartner;

/**
 * Created by yeqf on 5/25/15.
 */
public class StablePartner {
    public static void main(String[] args) {
        Boy[] boys = new Boy[4];
        boys[0] = new Boy(2, 3, 1, 0);
        boys[1] = new Boy(2, 1, 3, 0);
        boys[2] = new Boy(0, 2, 3, 1);
        boys[3] = new Boy(1, 3, 2, 0);
        Girl[] girls = new Girl[4];
        girls[0] = new Girl(0, 3, 2, 1);
        girls[1] = new Girl(0, 1, 2, 3);
        girls[2] = new Girl(0, 2, 3, 1);
        girls[3] = new Girl(1, 0, 3, 2);

        boolean flag = true;

        while (flag) {
            for (int i = 0; i < 4; i++) {
                Boy boy = boys[i];
                if (!boy.hasPart()) {
                    for (int j = 0; j < 4; j++) {
                        int girlId = boy.getGirlFromOrd(j).getId();
                        if (!boy.getGirlFromOrd(j).getIsRefused()) {
                            girls[girlId].getBoyFromId(i).setIsAspired(true);
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                Girl girl = girls[i];
                for (int j = 0; j < 4; j++) {
                    if (girl.getBoyFromOrd(j).getAspired()) {
                        for (int k = j + 1; k < 4; k++) {
                            if (girl.getBoyFromOrd(k).getAspired()) {
                                int boyId = girl.getBoyFromOrd(k).getId();
                                boys[boyId].getGirlFromId(i).setIsRefused(true);
                                if (girl.getPartner() == boyId) {
                                    boys[boyId].setPartner(-1);
                                }
                            }
                        }
                        girl.setPartner(girl.getBoyFromOrd(j).getId());
                        boys[girl.getBoyFromOrd(j).getId()].setPartner(i);
                        break;
                    }
                }
            }

            if (boys[0].hasPart() && boys[1].hasPart() && boys[2].hasPart() && boys[3].hasPart()) {
                flag = false;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("boy " + i + " de partner is "
                    + "girl " + boys[i].getPartner());
        }
    }

    private static class Boy {
        private GirlList[] girlLists = new GirlList[4];
        private int partner = -1;

        private class GirlList {
            private boolean isRefused = false;
            private int id;

            public GirlList(int id) {
                this.id = id;
            }

            public void setIsRefused(boolean flag) {
                isRefused = flag;
            }

            public boolean getIsRefused() {
                return isRefused;
            }

            public int getId() {
                return id;
            }
        }

        public Boy(int a, int b, int c, int d) {
            girlLists[0] = new GirlList(a);
            girlLists[1] = new GirlList(b);
            girlLists[2] = new GirlList(c);
            girlLists[3] = new GirlList(d);
        }

        public int getPartner() {
            return partner;
        }

        public void setPartner(int partner) {
            this.partner = partner;
        }

        public boolean hasPart() {
            if (partner == -1) {
                return false;
            }
            return true;
        }

        public GirlList getGirlFromOrd(int order) {
            return girlLists[order];
        }

        public GirlList getGirlFromId(int id) {
            int ord = 0;
            while (girlLists[ord].getId() != id) {
                ord++;
            }
            return girlLists[ord];
        }
    }

    private static class Girl {
        private BoyList[] boyLists = new BoyList[4];
        private int partner = -1;

        private class BoyList {
            private boolean isAspired = false;
            private int id;

            public BoyList(int id) {
                this.id = id;
            }

            public void setIsAspired(boolean flag) {
                this.isAspired = flag;
            }

            public boolean getAspired() {
                return isAspired;
            }

            public int getId() {
                return id;
            }
        }

        public Girl(int a, int b, int c, int d) {
            boyLists[0] = new BoyList(a);
            boyLists[1] = new BoyList(b);
            boyLists[2] = new BoyList(c);
            boyLists[3] = new BoyList(d);
        }

        public int getPartner() {
            return partner;
        }

        public void setPartner(int partner) {
            this.partner = partner;
        }

        public boolean hasPart() {
            if (partner == -1) {
                return false;
            }
            return true;
        }

        public BoyList getBoyFromOrd(int ord) {
            return boyLists[ord];
        }

        public BoyList getBoyFromId(int id) {
            int ord = 0;
            while (boyLists[ord].getId() != id) {
                ord++;
            }
            return boyLists[ord];
        }
    }
}