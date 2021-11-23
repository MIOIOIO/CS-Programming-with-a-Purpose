public class RevesPuzzle {

    private static void revesPuzzle(int n, char a, char b, char c, char d) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + a + " to " + d);
            return;
        }
        int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));
        revesPuzzle(k, a, d, c, b);
        hanoi(n, k, a, d, c);
        revesPuzzle(k, b, a, c, d);
    }

    private static void hanoi(int n, int k, char source, char dest, char extra) {
        if (n == k) return;
        hanoi(n - 1, k, source, extra, dest);
        System.out.println("Move disc " + n + " from " + source + " to " + dest);
        hanoi(n - 1, k, extra, dest, source);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revesPuzzle(n, 'A', 'B', 'C', 'D');
    }
}
