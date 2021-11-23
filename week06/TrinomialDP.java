public class TrinomialDP {
    public static long trinomial(int n, int k) {
            if (n == 0 && k == 0) return 1;
            if (k < -n || k > n) return 0;
            long[][] t = new long[n + 1][n + 1];
            t[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) t[i][j] = t[i - 1][j] + 2 * t[i - 1][j + 1];
                    else if (j == i) t[i][j] = t[i - 1][j - 1];
                    else t[i][j] = t[i - 1][j - 1] + t[i - 1][j] + t[i - 1][j + 1];
                }
            }
            if (k < 0) return t[n][Math.abs(k)];
            else return t[n][k];
        }



    // takes two integer command-line arguments n and k and prints t(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}