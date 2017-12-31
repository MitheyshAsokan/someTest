// Program.java
public class Program {
    public static void main(String[] args) {
        // Run the experiment
        ArrayListV1<Integer> alist1 = new ArrayListV1<>();
        ArrayListV2<Integer> alist2 = new ArrayListV2<>();

        // warm up code
        measureTimeToAdd(alist1, 10, 10);
        measureTimeToAdd(alist2, 10, 10);

        System.out.println("numToAdd\ta1Time\ta2Time");
        printResults(alist1, alist2, 1, 10, 1);                 // very small input sizes
        printResults(alist1, alist2, 200, 1000, 200);           // still pretty small
        printResults(alist1, alist2, 20000, 100000, 20000);     // larger
        printResults(alist1, alist2, 200000, 1000000, 200000);  // even larger
    }

    private static double measureTimeToAdd(ArrayList<Integer> list, int numToAdd,
            int minSamples) {

        Stopwatch watch = new Stopwatch();
        int numSamples = 0;
        watch.start();
        while (numSamples < minSamples || watch.getElapsedMilliseconds() < 1000) {
            list.reset();
            for (int i = 0; i < numToAdd; ++i) {
                list.add(i);
            }

            ++numSamples;
        }
        watch.stop();
        return watch.getElapsedSeconds() / numSamples;
    }

    public static void printResults(ArrayListV1<Integer> alist1, ArrayListV2<Integer> alist2,
            int min, int max, int increment) {
        for (int numToAdd = min; numToAdd <= max; numToAdd += increment) {
            double a1Time = measureTimeToAdd(alist1, numToAdd, 10);
            double a2Time = measureTimeToAdd(alist2, numToAdd, 10);

            System.out.printf("%d\t%.9f\t%.9f\n", numToAdd, a1Time, a2Time);
        }
    }
}
