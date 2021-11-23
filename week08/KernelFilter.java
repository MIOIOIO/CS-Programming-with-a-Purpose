import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    // private static Picture kernel(Picture picture, double[][] weights)
    // Returns a new picture that applies the identity filter to the given picture.
    private static Picture kernel(double[][] weights, Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rNew = 0.0;
        double gNew = 0.0;
        double bNew = 0.0;

        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rNew += r * weights[i + 1][j + 1];
                        gNew += g * weights[i + 1][j + 1];
                        bNew += b * weights[i + 1][j + 1];
                    }
                }
                int red = (int) Math.round(rNew);
                int green = (int) Math.round(gNew);
                int blue = (int) Math.round(bNew);
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                if (red < 0) red = 0;
                if (green < 0) green = 0;
                if (blue < 0) blue = 0;
                Color newColor = new Color(red, green, blue);
                target.set(col, row, newColor);
                rNew = 0.0;
                gNew = 0.0;
                bNew = 0.0;
            }
        }
        return target;
    }

    public static Picture identity(Picture picture) {
        return picture;
    }


    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = 1.0 / 16.0;
        matrix[0][1] = 2.0 / 16.0;
        matrix[0][2] = 1.0 / 16.0;

        matrix[1][0] = 2.0 / 16.0;
        matrix[1][1] = 4.0 / 16.0;
        matrix[1][2] = 2.0 / 16.0;

        matrix[2][0] = 1.0 / 16.0;
        matrix[2][1] = 2.0 / 16.0;
        matrix[2][2] = 1.0 / 16.0;
        return kernel(matrix, picture);
    }
        // for file in *.rar; do unrar e "$file"; done
    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] matrix = new double[3][3];
        matrix[0][0] =  0.0;
        matrix[0][1] = -1.0;
        matrix[0][2] =  0.0;

        matrix[1][0] = -1.0;
        matrix[1][1] = 5.0;
        matrix[1][2] = -1.0;

        matrix[2][0] =  0.0;
        matrix[2][1] = -1.0;
        matrix[2][2] =  0.0;
        return kernel(matrix, picture);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = -1.0;
        matrix[0][1] = -1.0;
        matrix[0][2] = -1.0;

        matrix[1][0] = -1.0;
        matrix[1][1] =  8.0;
        matrix[1][2] = -1.0;

        matrix[2][0] = -1.0;
        matrix[2][1] = -1.0;
        matrix[2][2] = -1.0;
        return kernel(matrix, picture);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = -2.0;
        matrix[0][1] = -1.0;
        matrix[0][2] =  0.0;

        matrix[1][0] = -1.0;
        matrix[1][1] =  1.0;
        matrix[1][2] =  1.0;

        matrix[2][0] = 0.0;
        matrix[2][1] = 1.0;
        matrix[2][2] = 2.0;
        return kernel(matrix, picture);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] matrix = new double[9][9];
        for (int i = 0; i < 9; i++) {
            matrix[i][i] = 1.0 / 9.0;
        }
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rNew = 0.0;
        double gNew = 0.0;
        double bNew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -4; i < 5; i++) {
                    for (int j = -4; j < 5; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rNew += r * matrix[i + 4][j + 4];
                        gNew += g * matrix[i + 4][j + 4];
                        bNew += b * matrix[i + 4][j + 4];
                    }
                }
                int red   = (int) Math.round(rNew);
                int green = (int) Math.round(gNew);
                int blue  = (int) Math.round(bNew);
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                if (red < 0)     red = 0;
                if (green < 0) green = 0;
                if (blue < 0)   blue = 0;
                Color newcolor = new Color(red, green, blue);
                target.set(col, row, newcolor);
                rNew = 0.0;
                gNew = 0.0;
                bNew = 0.0;
            }
        }
        return target;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);

        Picture id = identity(pic);
        id.show();

        Picture gaussian = gaussian(pic);
        gaussian.show();

        Picture sharpen = sharpen(pic);
        sharpen.show();

        Picture laplacian = laplacian(pic);
        laplacian.show();

        Picture emboss = emboss(pic);
        emboss.show();

        Picture motionBlur = motionBlur(pic);
        motionBlur.show();

    }
}
