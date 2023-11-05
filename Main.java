public class Main {
    // Function to measure time and memory usage of an algorithm
    static void measureAlgorithm(Runnable algorithm, String algorithmName) {
        // Garbage collector to get accurate memory usage
        System.gc();
        long startMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        // Execute the algorithm
        algorithm.run();

        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().freeMemory();

        long elapsedTime = endTime - startTime;
        long memoryUsage = startMemory - endMemory;


        System.out.println(String.format("%-40s",algorithmName) + " - Time: " + elapsedTime/1000000.0 + " ms, Memory: " + memoryUsage + " bytes");
    }

    public static void main(String[] args) {
        long seed = 987654L;
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
                Runnable algorithm1 = () -> MergeSort.mergeSort(dataset_copy1);
                // Algorithm 2
                Runnable algorithm2 = () -> QuickSort2PivotBlock.twoPivotQuickSort(dataset_copy2);

                System.out.println("Type of dataset: " + types[i]);
                measureAlgorithm(algorithm1, "Merge Sort -" + types[i]);
                measureAlgorithm(algorithm2, "Block QuickSort 2 Pivot - " + types[i]);
                System.out.println();
            }

            System.out.println();
        }
    }
}
