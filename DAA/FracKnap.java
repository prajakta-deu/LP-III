import java.util.*;

public class FracKnap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int val[] = new int[n];
        int weight[] = new int[n];

        // Input values and weights
        System.out.println("Enter values and weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            val[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();
        }

        // Input total capacity
        System.out.print("Enter total capacity of knapsack: ");
        int W = sc.nextInt();

        double ratio[][] = new double[n][2];
        // 0th col = index, 1st col = value/weight ratio

        for (int i = 0; i < n; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sort items by ratio in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalValue = 0;

        // Pick items starting from highest ratio
        for (int i = n - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {
                // include fractional part
                finalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("\nMaximum value obtained = " + finalValue);
        sc.close();
    }
}













// import java.util.*;
// public class FracKnap{

//     public static void main(String args[]){
//         int val[]={60,100,120};
//         int weight[]={10,20,30};
//         int W=50;

//         double ratio[][]=new double[val.length][2];
//         //0th col=idx, 1st col= ratio

//         for(int i=0;i<val.length;i++){
//             ratio[i][0]=i;
//             ratio[i][1]=val[i]/(double)weight[i];
//         }

//         //accending sort
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity=W;
//         int finalValue=0;
//         for(int i=ratio.length-1;i>=0;i--){
//             int idx=(int)ratio[i][0];
//             if(capacity>=weight[idx]){
//                 finalValue+=val[idx];
//                 capacity-=weight[idx];
//             }
//             else{
//                 //include fractional item
//                 finalValue+=(ratio[i][1]*capacity);
//                 capacity=0;
//                 break;
//             }
//         }
//         System.out.println("Final Value = "+finalValue);
//     }
// }