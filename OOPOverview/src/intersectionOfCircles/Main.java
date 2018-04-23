package intersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstCircleTokens = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] secondCircleTokens = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Circle firstCircle = new Circle(firstCircleTokens[0], firstCircleTokens[1], firstCircleTokens[2]);
        Circle secondCircle = new Circle(secondCircleTokens[0], secondCircleTokens[1], secondCircleTokens[2]);

        if (intersect(firstCircle, secondCircle)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    private static boolean intersect(Circle c1, Circle c2) {
        double distance = Math.sqrt(Math.pow((c2.getX() - c1.getX()), 2) + Math.pow((c2.getY() - c2.getY()), 2));
        return distance < c1.getRadius() + c2.getRadius();
    }
}
