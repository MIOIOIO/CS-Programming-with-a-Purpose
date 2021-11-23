public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] field = new int[m][n];
        int x;
        int y;
        // Mine placement
        while (k > 0) {
            x = (int) (Math.random() * m);
            y = (int) (Math.random() * n);
            if (field[x][y] == 0) {
                field[x][y] = -1;
                k--;
            }
        }
        // Count surrounding mines (-1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == -1) {
                    if (i - 1 >= 0 && j - 1 >= 0 && field[i - 1][j - 1] != -1)
                        field[i - 1][j - 1]++;
                    if (i + 1 < m && j - 1 >= 0 && field[i + 1][j - 1] != -1)
                        field[i + 1][j - 1]++;
                    if (i - 1 >= 0 && j + 1 < n && field[i - 1][j + 1] != -1)
                        field[i - 1][j + 1]++;
                    if (i + 1 < m && j + 1 < n && field[i + 1][j + 1] != -1)
                        field[i + 1][j + 1]++;
                    if (i - 1 >= 0 && field[i - 1][j] != -1) field[i - 1][j]++;
                    if (i + 1 < m && field[i + 1][j] != -1) field[i + 1][j]++;
                    if (j - 1 >= 0 && field[i][j - 1] != -1) field[i][j - 1]++;
                    if (j + 1 < n && field[i][j + 1] != -1) field[i][j + 1]++;
                }
            }
        }

        // Display
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == -1) System.out.print("*");
                else System.out.print(field[i][j]);
                if (j == n - 1) System.out.println();
                else System.out.print("  ");
            }
        }


    }
}

