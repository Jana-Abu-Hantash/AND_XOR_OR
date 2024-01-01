import java.util.Arrays;
import java.util.Scanner;

public class BitwiseMaximizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int N = scanner.nextInt();

        // Initialize the array
        int[] A = new int[N];

        // Read the array elements
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Find and print the maximum possible value of Si
        System.out.println(findMaximumSi(A));

        scanner.close();
    }

    private static int findMaximumSi(int[] A) {
        // Sort the array
        Arrays.sort(A);

        int maxSi = 0;

        // Iterate over the array to find the maximum Si
        for (int i = 0; i < A.length - 1; i++) {
            // M1 is the smallest, M2 is the next smallest element in the pair
            int M1 = A[i];
            int M2 = A[i + 1];

            // Calculate Si using the given bitwise operations
            int Si = (((M1 & M2) ^ (M1 | M2)) & (M1 ^ M2));

            // Update maxSi if we've found a larger Si
            maxSi = Math.max(maxSi, Si);
        }

        return maxSi;
    }
}
