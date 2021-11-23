//  The Shannon entropy is a measure of the rate of information produced by a random source,
//  such as the outcomes of flipping a fair coin or rolling a loaded die.
//  It is a fundamental concept in information theory and data compression.
public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int counter = 0;
        // compute frequencies
        // freq[i] = # times integer i appears
        int[] freq = new int[m + 1];
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            freq[value]++;
            counter++;
        }

        // compute Shannon entropy
        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            double p = 1.0 * freq[i] / counter;
            if (freq[i] > 0)
                entropy -= p * Math.log(p) / Math.log(2);
        }

        StdOut.printf("%.4f", entropy);
    }
}
