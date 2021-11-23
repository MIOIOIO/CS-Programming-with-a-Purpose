public class RightTriangle {
    public static void main(String[] args) {
        int aSide = Integer.parseInt(args[0]);
        int bSide = Integer.parseInt(args[1]);
        int cSide = Integer.parseInt(args[2]);
        boolean isPositive = (aSide > 0) && (bSide > 0) && (cSide >= 0);
        boolean result = isPositive && (aSide * aSide + bSide * bSide == cSide * cSide
                || aSide * aSide + cSide * cSide == bSide * bSide
                || cSide * cSide + bSide * bSide == aSide * aSide);
        System.out.println(result);
    }
}
