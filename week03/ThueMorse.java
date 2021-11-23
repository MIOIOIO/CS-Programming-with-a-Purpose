public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] thue = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) thue[i] = 0;
            else if (i % 2 == 0) thue[i] = thue[i / 2];
            else thue[i] = 1 - thue[i - 1];
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (thue[i] == 1 ^ thue[j] == 0) System.out.print("+");
                else System.out.print("-");
                if (i < n - 1) System.out.print("  ");
            }
            if (j < n - 1) System.out.println();
        }
    }
}

