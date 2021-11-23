public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double x1Rad = Math.toRadians(x1);
        double y1Rad = Math.toRadians(y1);
        double x2Rad = Math.toRadians(x2);
        double y2Rad = Math.toRadians(y2);
        double div1 = ((x2Rad - x1Rad) / 2);
        double cosx = (Math.cos(x1Rad) * Math.cos(x2Rad));
        double div2 = ((y2Rad - y1Rad) / 2);
        double sinsqrt1 = (Math.sin(div1) * Math.sin(div1));
        double sinsqrt2 = (Math.sin(div2) * Math.sin(div2));
        double sqrt = Math.sqrt(sinsqrt1 + (cosx * sinsqrt2));
        double radius = 6371.0;
        double distance = (2 * radius * Math.asin(sqrt));
        System.out.println(distance + " kilometers");
    }
}
