package demo;

public class App {

    public static void main(String[] args) {
        PerformanceComparator comparator = new PerformanceComparator();

        System.out.println("Stage 1:");
        comparator.stage1(100000, 20000);

        System.out.println();
        System.out.println("Stage 2:");
        comparator.stage2(100000, 20000);

        System.out.println();
        System.out.println("Stage 2.5:");
        comparator.stage25(1000000, 200000);

        System.out.println();
        System.out.println("Stage 3:");
        comparator.stage3(100000, 50443);
    }
}
