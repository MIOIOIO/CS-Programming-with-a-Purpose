/* *****************************************************************************
 2D random walk. A two-dimensional random walk simulates the behavior
of a particle moving in a grid of points. At each step, the random walker moves
north, south, east, or west with probability equal to 1/4, independent of previous
moves. Write a program RandomWalker that takes an integer command-line
argument n and estimates how long it will take a random walker to hit the boundary of
a 2n-by-2n square centered at the starting point.
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int manhattanX = 0;
        int manhattanY = 0;
        int stepCount = 0;
        if (r != 0) {
            System.out.println("(" + manhattanX + ", " + manhattanY + ")");
            do {
                double step = Math.random();
                if (step <= 0.25) manhattanX--;
                else if (step <= 0.50) manhattanX++;
                else if (step <= 0.75) manhattanY--;
                else manhattanY++;
                stepCount += 1;
                System.out.println("(" + manhattanX + ", " + manhattanY + ")");
            } while (Math.abs(manhattanX) + Math.abs(manhattanY) < r);
        } else System.out.println("(" + manhattanX + ", " + manhattanY + ")");
        System.out.println("steps = " + stepCount);
    }
}
