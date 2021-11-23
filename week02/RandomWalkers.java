public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int manhattanX = 0;
        int manhattanY = 0;
        int stepCount = 0;
        double sumSteps = 0;
        for (int i = 0; i < trials; i++) {
            do {
                double step = Math.random();
                if (step <= 0.25 && r != 0) manhattanX--;
                else if (step <= 0.50 && r != 0) manhattanX++;
                else if (step <= 0.75 && r != 0) manhattanY--;
                else if (r != 0) manhattanY++;
                if (r != 0) stepCount += 1;
            } while (Math.abs(manhattanX) + Math.abs(manhattanY) < r);
            sumSteps += stepCount;
            stepCount = 0;
            manhattanX = 0;
            manhattanY = 0;
        }
        double averageSteps = sumSteps / trials;
        System.out.println("average number of steps = " + averageSteps);
    }
}
