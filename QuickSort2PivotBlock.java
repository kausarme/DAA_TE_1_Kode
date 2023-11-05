import java.util.Stack;

public class QuickSort2PivotBlock {
    private static final int QSORT2BLOCKSIZE = 1024;
    public static void twoPivotQuickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int hi = stack.pop();
            int lo = stack.pop();

            if (lo < 0 || hi < 0 || hi >= arr.length || lo >= hi) continue;

            int[] block = new int[QSORT2BLOCKSIZE];
            int p = arr[lo];
            int q = arr[hi];

            if (p > q) {
                swap(arr, lo, hi);
                p = arr[lo];
                q = arr[hi];
            }

            int counter = lo + 1, offset1 = lo + 1, offset2 = lo + 1;
            int num1 = 0, num2 = 0;

            while (counter < hi) {
                int t = Math.min(hi - counter, QSORT2BLOCKSIZE);
                for (int j = 0; j < t; ++j) {
                    block[num2] = j;
                    num2 += (q >= arr[counter + j]) ? 1 : 0;
                }
                for (int j = 0; j < num2; ++j) {
                    swap(arr, offset2 + j, counter + block[j]);
                }
                counter += t;
                for (int j = 0; j < num2; ++j) {
                    block[num1] = j;
                    num1 += (p > arr[offset2 + j]) ? 1 : 0;
                }
                for (int j = 0; j < num1; ++j) {
                    swap(arr, offset1++, offset2 + block[j]);
                }
                offset2 += num2;
                num1 = 0;
                num2 = 0;
            }

            swap(arr, lo, offset1 - 1);
            swap(arr, offset2, hi);

            stack.push(lo);
            stack.push(offset1 - 2);

            if (p != q) {
                stack.push(offset1);
                stack.push(offset2 - 1);
            }

            stack.push(offset2 + 1);
            stack.push(hi);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        twoPivotQuickSort(arr);

        System.out.print("Sorted array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
