import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class DatasetGenerator {

    // Generate 3 datasets: sorted, reversed, and random
    static int[][] generateDatasets(int N, long seed) {
        int[][] datasets = new int[3][N];

        // Generate sorted dataset: 1, 2, 3, ..., N
        for (int i = 0; i < N; i++) {
            datasets[0][i] = i + 1;
        }

        // Generate reversed dataset: N, N-1, N-2, ..., 1
        for (int i = 0; i < N; i++) {
            datasets[1][i] = N - i;
        }

        // Generate random dataset: a permutation of 1..N
        int[] arr = IntStream.rangeClosed(1, N).toArray();
        Random rand = new Random(seed);
        for (int i = 0; i < N; i++) {
            int randomIndex = i + rand.nextInt(N - i);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
        datasets[2] = arr;

        return datasets;
    }

    public static void main(String[] args) {
        // a main function to try an example dataset
        int N = 10;
        long seed = 12345L;
        int[][] datasets = generateDatasets(N, seed);

        System.out.println("Sorted Dataset: " + Arrays.toString(datasets[0]));
        System.out.println("Reversed Dataset: " + Arrays.toString(datasets[1]));
        System.out.println("Random Dataset: " + Arrays.toString(datasets[2]));
    }
}
