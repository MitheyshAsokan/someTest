
import java.util.ArrayList;
import java.util.Collections;

public class Program {
    public static void x2(int x) {
        int count = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < x; ++j) {
                count = count + 1;
                noop();
            }
        }
    }

    // modified from http://www.cse.yorku.ca/~oz/hash.html , the djb2 algorithm
    // unknown if it works well for unicode strings. It was written for single
    // bytes.
    public static long hashString(String str) {
        long hash = 5381;
        for (int i = 0; i < str.length(); ++i) {
            int ch = str.charAt(i);
            hash = ((hash << 5) + hash) + ch; // hash * 33 + c
            noop();
        }
        return hash;
    }

    // Analyse this algorithm using powers of 2 as input, i.e. value = 2^k
    public static int howManyTimesCutInHalf(int value) {
        int count = 0;
        while (value > 1) {
            value = value / 2; // integer division, will throw away remainder
            ++count;
            noop();
        }
        return count;
    }

    static String makeString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append('a');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        // Change the following line to a 2 to do problem 2, etc.
        int exercise = 1;
        if (exercise == 1) {
            x2(8);

            hashString("12345678");

            howManyTimesCutInHalf(8);
        } else if (exercise == 2) {
            int i = 0x1 << 16; // 2^16

            x2(i);

            hashString(makeString(i));

            howManyTimesCutInHalf(i);
        } else if (exercise == 3) {
            int numBids = 8;
            // System.out.println("numSensors\tnumBids\tTime\tnumExpanded\tmaxDepth");
            while (numBids < 20) {
                numBids += 2;
                int numSensors = 8;
                while (numSensors < 20) {
                    numSensors += 2;

                    // System.out.printf("%d\t%d\t\n", numSensors, numBids);
                    Problem problem = new Problem("random", numSensors, numBids);
                    problem.createRandom();
                    Node solutionNode = solveProblem(problem);
                }
            }
        }

        Thread.sleep(3000); // need to add this to overcome a current bug in
                            // profiler
    }

    static Node solveProblem(Problem problem) {
        Stopwatch sw = new Stopwatch();
        sw.start();
        // DateTime start = DateTime.Now;

        // init the fringe with each bid
        ArrayList<Node> fringe = new ArrayList<>();
        for (int i = 0; i < problem.getBids().length; ++i) {
            Node node = new Node(problem.getBids()[i], null, problem);
            fringe.add(node);
        }

        int numExpanded = 0;
        int maxDepth = 0;
        Node solutionNode = null;
        while (true) {
            if (fringe.size() == 0) {
                break;
            }
            Collections.sort(fringe);
            Node nodeToConsider = fringe.get(fringe.size() - 1);
            fringe.remove(fringe.size() - 1);
            if (nodeToConsider.getDepth() > maxDepth) {
                maxDepth = nodeToConsider.getDepth();
            }
            if (nodeToConsider.getFringeBids().length == 0) // found the
                                                            // solution
            {
                solutionNode = nodeToConsider;
                break;
            }
            expandNode(nodeToConsider, problem, fringe);
            ++numExpanded;
            // Console.Write( "maxDepth: {0} depth: {1} expanded: {2} fringe:
            // {6} f(n): {4} g(n): {3} h(n): {5}\n",
            // maxDepth, nodeToConsider.Depth, numExpanded, nodeToConsider.Cost,
            // nodeToConsider.Cost + nodeToConsider.Heuristic,
            // nodeToConsider.Heuristic,
            // fringe.Count ) ;
        }

        // DateTime end = DateTime.Now;
        sw.stop();
        // TimeSpan span = end.Subtract(start);

        System.out.println(
                sw.getElapsedMilliseconds() + "\t" + numExpanded + "\t" + maxDepth);

        return solutionNode;
    }

    static void outputSolution(Problem problem, Node solutionNode) {
        if (solutionNode == null) {
            System.out.println("Failure.  No solution found.");
        } else {
            System.out.printf("For problem %s the optimal bids are:\n", problem.getId());
            outputBids(solutionNode, 0);
            System.out.println();
        }
    }

    static void outputBids(Node node, int sum) {
        if (node == null) {
            System.out.printf("Total amount: %d\n", sum);
            return;
        }
        System.out.printf("Bid: %s with amount %d\n", node.getBid().getId(),
                node.getBid().getAmount());
        outputBids(node.getParent(), node.getBid().getAmount() + sum);
    }

    static void expandNode(Node node, Problem problem, ArrayList openList) {
        for (int i = 0; i < node.getFringeBids().length; ++i) {
            Node fringeNode = new Node(node.getFringeBids()[i], node, problem);
            openList.add(fringeNode);
        }
    }

    private static void noop() {
    }
}
