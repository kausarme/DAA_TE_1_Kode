public class MergeSort {

    // Merge two sorted subarrays
    private static void merge(int[] arr, int aLeft, int aRight, int bLeft, int bRight) {
        int size = bRight - aLeft + 1;
        int[] temp = new int[size];
        int tIndex = 0, aIndex = aLeft, bIndex = bLeft;

        while (aIndex <= aRight && bIndex <= bRight) {
            if (arr[aIndex] <= arr[bIndex]) {
                temp[tIndex++] = arr[aIndex++];
            } else {
                temp[tIndex++] = arr[bIndex++];
            }
        }

        while (aIndex <= aRight) temp[tIndex++] = arr[aIndex++];
        while (bIndex <= bRight) temp[tIndex++] = arr[bIndex++];

        System.arraycopy(temp, 0, arr, aLeft, size);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr,0, arr.length-1);
    }
    // Recursive Merge Sort function
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, mid + 1, right);
        }
    }



    // Test Small Sample
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);

        System.out.print("Sorted array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
