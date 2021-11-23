public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double result = Double.NaN;
        if (x < 0) result = 0.0;
        else if (x == 0) result = 0.5;
        else if (x > 0) result = 1;
        return result;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double result = Double.NaN;
        if (!Double.isNaN(x)) result = 1 / (1+ Math.exp(-x));
        return result;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double result = Double.NaN;
        if (!Double.isNaN(x)) {
            if (x <= -20) result = -1;
            else if (x >= 20) result = 1;
            else result = (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
        }
            return result;
    }

    // Returns the soft sign function of x.
    public static double softsign(double x) {
        double result = Double.NaN;
        if (!Double.isNaN(x)) {
            if (x == Double.NEGATIVE_INFINITY) result = -1;
            else if (x == Double.POSITIVE_INFINITY) result = 1;
            else if (x == 0) result = 0;
            else result = x / (1 + Math.abs(x));
        }
        return result;
    }

    // Returns the square non-linearity function of x.
    public static double sqnl(double x) {
        double result = Double.NaN;
        if (x <= -2) result = -1;
        else if (x < 0) result = (x + (x*x / 4));
        else if (x < 2) result = (x - (x*x /4));
        else if (x >= 2) result = 1;
        return result;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.printf("heaviside(%f) = %.16f\n", x, heaviside(x));
        StdOut.printf("  sigmoid(%f) = %.16f\n", x, sigmoid(x));
        StdOut.printf("     tanh(%f) = %.16f\n", x, tanh(x));
        StdOut.printf(" softsign(%f) = %.16f\n", x, softsign(x));
        StdOut.printf("     sqnl(%f) = %.16f\n", x, sqnl(x));
    }
}