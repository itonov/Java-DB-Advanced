import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] firstArr = reader.readLine().replace(" ", "").toCharArray();
        char[] secondArr = reader.readLine().replace(" ", "").toCharArray();

        if (firstArr.length > secondArr.length) {
            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i] > secondArr[i]) {
                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    break;
                } else if (secondArr[i] > firstArr[i]) {
                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    break;
                }

                if (secondArr.length == i + 1) {
                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    break;
                }
            }
        } else if (secondArr.length > firstArr.length) {
            for (int i = 0; i < secondArr.length; i++) {
                if (secondArr[i] > firstArr[i]) {
                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    break;
                } else if (firstArr[i] > secondArr[i]) {
                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    break;
                }

                if (firstArr.length == i + 1) {
                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    break;
                }
            }
        } else {
            for (int i = 0; i < secondArr.length; i++) {
                if (Arrays.equals(firstArr, secondArr)) {
                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    break;
                }
                if (secondArr[i] > firstArr[i]) {
                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    break;
                } else if (firstArr[i] > secondArr[i]) {
                    for (char c : secondArr) {
                        System.out.print(c);
                    }
                    System.out.println();

                    for (char c : firstArr) {
                        System.out.print(c);
                    }
                    break;
                }
            }
        }
    }
}
