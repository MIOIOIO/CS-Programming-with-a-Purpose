public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int max = 0;
        int[][] matrix = new int[a.length + 1][a.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                if (a[i - 1][j - 1] == 1) {
                    int min = Math.min(matrix[i][j - 1], matrix[i - 1][j]);
                    matrix[i][j] = Math.min(min, matrix[i - 1][j - 1]) + 1;
                }
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        StdOut.println(size(a));
    }
}
