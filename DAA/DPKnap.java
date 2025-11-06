import java.util.*;

public class DPKnap {

    // Function to solve 0/1 Knapsack using Dynamic Programming
    public static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int val[] = new int[n];
        int wt[] = new int[n];

        // Input values and weights
        System.out.println("Enter values and weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            val[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            wt[i] = sc.nextInt();
        }

        // Input capacity of knapsack
        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        int maxValue = knapSack(W, wt, val, n);
        System.out.println("\nMaximum value that can be put in the knapsack = " + maxValue);

        sc.close();
    }
}














// import java.util.*;

// public class DPKnap {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] values = null;
//         int[] weights = null;
//         int n = 0;
//         int choice;

//         while (true) {
//             System.out.println("\n=== 0-1 Knapsack Menu ===");
//             System.out.println("1. Enter items (values & weights)");
//             System.out.println("2. Solve 0-1 Knapsack");
//             System.out.println("3. Exit");
//             System.out.print("Enter your choice: ");
//             choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter number of items: ");
//                     n = sc.nextInt();
//                     values = new int[n];
//                     weights = new int[n];

//                     for (int i = 0; i < n; i++) {
//                         System.out.print("Item " + (i + 1) + " value: ");
//                         values[i] = sc.nextInt();
//                         System.out.print("Item " + (i + 1) + " weight: ");
//                         weights[i] = sc.nextInt();
//                     }
//                     break;

//                 case 2:
//                     if (values == null || weights == null || n == 0) {
//                         System.out.println("Please enter items first!");
//                         break;
//                     }

//                     System.out.print("Enter knapsack capacity: ");
//                     int capacity = sc.nextInt();

//                     int[][] dp = buildKnapsackDP(values, weights, n, capacity);
//                     System.out.println("\nDP Table:");
//                     printDPTable(dp, n, capacity);

//                     System.out.println("Maximum value that can be put in knapsack: " + dp[n][capacity]);
//                     break;

//                 case 3:
//                     System.out.println("Exiting program. Goodbye!");
//                     sc.close();
//                     return;

//                 default:
//                     System.out.println("Invalid choice!");
//             }
//         }
//     }

//     // Build DP table
//     private static int[][] buildKnapsackDP(int[] val, int[] wt, int n, int W) {
//         int[][] dp = new int[n + 1][W + 1];

//         for (int i = 0; i <= n; i++) {
//             for (int w = 0; w <= W; w++) {
//                 if (i == 0 || w == 0)
//                     dp[i][w] = 0;
//                 else if (wt[i - 1] <= w)
//                     dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
//                 else
//                     dp[i][w] = dp[i - 1][w];
//             }
//         }
//         return dp;
//     }

//     // Print DP table
//     private static void printDPTable(int[][] dp, int n, int W) {
//         System.out.print("   ");
//         for (int w = 0; w <= W; w++)
//             System.out.printf("%4d", w);
//         System.out.println();

//         for (int i = 0; i <= n; i++) {
//             System.out.printf("%2d ", i);
//             for (int w = 0; w <= W; w++)
//                 System.out.printf("%4d", dp[i][w]);
//             System.out.println();
//         }
//     }
// }