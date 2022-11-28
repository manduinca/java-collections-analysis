package demo;

public class App {

    public static void main(String[] args) {
        PerformanceComparator comparator = new PerformanceComparator();

        /**
         * Stage 1:
         * Array List vs Linked List performance
         * Many read operations
         **/
        System.out.println("Stage 1:");
        comparator.stage1(100000, 20000);

        /**
         * Stage 2:
         * Array List vs Linked List performance
         * Many mutate operations
         **/
        System.out.println();
        System.out.println("Stage 2:");
        comparator.stage2(100000, 20000);

        /**
         * Stage 2.5:
         * Array List vs Linked List performance
         * Many mutate operations in loops
         **/
        System.out.println();
        System.out.println("Stage 2.5:");
        comparator.stage25(1000000, 200000);

        /**
         * Stage 3:
         * List vs Set performance
         * Many search operations
         **/
        System.out.println();
        System.out.println("Stage 3:");
        comparator.stage3(100000, 50443);
    }
}
