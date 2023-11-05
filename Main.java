import java.util.Arrays;

public class Main {

    // Function to measure time and memory usage of an algorithm
    static void measureAlgorithm(Runnable algorithm, String algorithmName) {
        // Garbage collector to get accurate memory usage
        System.gc();
        long startMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        // Execute the algorithm
        algorithm.run();

        long endTime = System.currentTimeMillis();
        long endMemory = Runtime.getRuntime().freeMemory();

        long elapsedTime = endTime - startTime;
        long memoryUsage = startMemory - endMemory;

        System.out.println(algorithmName + " - Time: " + elapsedTime + " ms, Memory: " + memoryUsage + " bytes");
    }

    public static void main(String[] args) {
        long seed = 12345L;
        int[] sizes = {1 << 9, 1 << 13, 1 << 16};

        for (int size : sizes) {
            int[][] datasets = DatasetGenerator.generateDatasets(size, seed);
            System.out.println("Size of dataset: " + size);

            // Types of datasets
            String[] types = {"Sorted", "Reversed", "Random"};

            // Measure algorithms on each dataset type
            for (int i = 0; i < datasets.length; i++) {
                int[] dataset_copy1 = datasets[i].clone();
                int[] dataset_copy2 = datasets[i].clone();

                // Algorithm 1
                Runnable algorithm1 = () -> {
                    System.out.println("a");
                    System.out.println("a");
                };
                // Algorithm 2
                Runnable algorithm2 = () -> {
                    System.out.println("a");
                    System.out.println("a");
                };

                System.out.println("Type of dataset: " + types[i]);
                measureAlgorithm(algorithm1, "Algorithm 1" + types[i]);
                measureAlgorithm(algorithm2, "Algorithm 2" + types[i]);
            }

            System.out.println();
        }
    }
}
