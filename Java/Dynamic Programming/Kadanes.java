public class Kadanes {

    static int[] arr = new int[] { 1, 2, -3, -4 };
    static int k = 6;

    int subArrayWithGivenSum(int[] arr, int k) {
        int n = arr.length;
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum = currentSum + arr[i];
            currentSum = Math.max(currentSum, 0);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String args[]) {
        Kadanes s = new Kadanes();
        int output = s.subArrayWithGivenSum(arr, k);
        System.out.println(output);
    }
}