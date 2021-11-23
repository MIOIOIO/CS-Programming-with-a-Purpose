public class Birthday {

    public static void main(String[] args) {
        int days = Integer.parseInt(args[0]);     // number of days
        int trials = Integer.parseInt(args[1]);
        int[] daysNeeded = new int[days + 2];
        for (int i = 0; i < trials; i++) {
            boolean found = false;
            boolean[] twin = new boolean[days];
            //  hasBirthday[d] = true if someone born on day d; false otherwise
            int count = 0;                           // total number of people
            while (!found) {
                double birthday = days * Math.random();
                int bDay = (int) birthday;
                if (twin[bDay]) {
                    found = true;
                    daysNeeded[count] += 1.0;
                } else {
                    twin[bDay] = true;
                    count++;
                }
            }
        }
        double fraction = 0.0;
        int i = 0;
        do {
            fraction += daysNeeded[i] / (trials * 1.0);
            System.out.print((i + 1) + "\t" + daysNeeded[i] + "\t" + fraction + "\n");
            i++;
        } while (fraction < 0.5);
    }
}



