import java.util.*;

public class Fibonacci {

    // Recursive function to find nth Fibonacci number
    public static int fibRecursive(int n) {
        if (n <= 1)
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Non-recursive (iterative) function to find nth Fibonacci number
    public static int fibIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (term of Fibonacci series): ");
        int n = sc.nextInt();

        // Recursive result
        System.out.println("\nUsing Recursion:");
        System.out.println("Fibonacci(" + n + ") = " + fibRecursive(n));

        // Iterative result
        System.out.println("\nUsing Iteration:");
        System.out.println("Fibonacci(" + n + ") = " + fibIterative(n));

        sc.close();
    }
}
