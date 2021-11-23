public class BandMatrix {
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (n + j >= i && n + i >= j) {
                    if (j == 0) System.out.print("*");
                    else System.out.print(" *");
                } else {
                    if (j == 0) System.out.print("0");
                    else System.out.print(" 0");
                }
                if (j == width - 1) System.out.print("\n");
                else System.out.print(" ");
            }
        }
    }
}
