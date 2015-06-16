package stabalpartner;

/**
 * Created by yeqf on 5/25/15.
 */
public class StablePartner {
    public static void main(String[] args) {
        Boy[] boys = new Boy[5];
        boys[0] = new Boy(0, 1, 2, 4, 3);
        boys[1] = new Boy(4, 1, 3, 2, 0);
        boys[2] = new Boy(2, 4, 0, 1, 3);
        boys[3] = new Boy(2, 3, 1, 0, 4);
        boys[4] = new Boy(3, 4, 0, 1, 2);
        Girl[] girls = new Girl[5];
        girls[0] = new Girl(1, 4, 3, 0, 2);
        girls[1] = new Girl(2, 1, 3, 0, 4);
        girls[2] = new Girl(0, 1, 3, 2, 4);
        girls[3] = new Girl(3, 0, 1, 4, 2);
        girls[4] = new Girl(4, 2, 1, 3, 0);

        boolean flag = true;

        while (flag) {
            for (int i = 0; i < 5; i++) {
                Boy boy = boys[i];
                if (!boy.hasPart()) {       //如果男孩没有伴侣
                    for (int j = 0; j < 5; j++) {
                        int girlId = boy.getGirlFromOrd(j).getId();     //得到该男孩心中排名为j的女孩的id
                        if (!boy.getGirlFromOrd(j).getIsRefused()) {    //如果这个女孩没有拒绝过男孩
                            girls[girlId].getBoyFromId(i).setIsAspired(true);   //男孩向女孩表白
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                Girl girl = girls[i];
                for (int j = 0; j < 5; j++) {
                    if (girl.getBoyFromOrd(j).getAspired()) {       //如果该男孩向女孩表过白
                        //拒绝排名在该男孩后面的所有向该女孩表白的男孩
                        for (int k = j + 1; k < 5; k++) {
                            if (girl.getBoyFromOrd(k).getAspired()) {
                                int boyId = girl.getBoyFromOrd(k).getId();
                                boys[boyId].getGirlFromId(i).setIsRefused(true);
                                //如果男孩是该女孩的当前伴侣，则放弃该男孩，并把该男孩设置为单身
                                if (girl.getPartner() == boyId) {
                                    boys[boyId].setPartner(-1);
                                }
                            }
                        }
                        girl.setPartner(girl.getBoyFromOrd(j).getId());     //女孩接受所有表白者中排名最高的男孩
                        boys[girl.getBoyFromOrd(j).getId()].setPartner(i);  //并把男孩的伴侣设置为该女孩
                        break;
                    }
                }
            }


            if (boys[0].hasPart() && boys[1].hasPart() && boys[2].hasPart() && boys[3].hasPart() && boys[4].hasPart()) {
                flag = false;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("boy " + i + " de partner is "
                    + "girl " + boys[i].getPartner());
        }
    }

    private static class Boy {
        private GirlList[] girlLists = new GirlList[5];
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

        public Boy(int a, int b, int c, int d, int e) {
            girlLists[0] = new GirlList(a);
            girlLists[1] = new GirlList(b);
            girlLists[2] = new GirlList(c);
            girlLists[3] = new GirlList(d);
            girlLists[4] = new GirlList(e);
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
        private BoyList[] boyLists = new BoyList[5];
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

        public Girl(int a, int b, int c, int d, int e) {
            boyLists[0] = new BoyList(a);
            boyLists[1] = new BoyList(b);
            boyLists[2] = new BoyList(c);
            boyLists[3] = new BoyList(d);
            boyLists[4] = new BoyList(e);
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