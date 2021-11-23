public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] freq = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            freq[i] = Integer.parseInt(args[i + 1]);
            total += freq[i];
        }
        for (int j = 0; j < m; j++) {
            if (j > 0 && j % 25 == 0) System.out.println();
            int r = (int) (Math.random() * total);
            int sum = 0;
            int event = -1;
            for (int i = 0; i < n && sum <= r; i++) {
                sum += freq[i];
                event = i + 1;
            }
            System.out.print(event + " ");
        }
    }
}
