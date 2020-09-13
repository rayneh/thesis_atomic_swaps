package swaps;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        boolean run = true;

        System.out.println("----------------------------------");
        System.out.println("Welcome to atomic cross-swaps prototype");
        System.out.println("IMPORTANT NOTICE: all three chains need to be running and mining!");
        System.out.println("               ");

        while(run) {
            System.out.println("               ");
            System.out.println("please select one menu entry:");
            System.out.println("               ");
            System.out.println("0 - run swap protocol");
            System.out.println("1 - run transactions per second (tps)");
            System.out.println("2 - run swaps per hour (sph) - (print pre-measured testing results!)");
            System.out.println("3 - exit");
            System.out.println("----------------------------------");

            Scanner scanner = new Scanner(System.in);
            int menuEntry = scanner.nextInt();

            switch (menuEntry) {
                case 0: long startTime = System.nanoTime();
                        SwapProtocol swapProtocol = new SwapProtocol();
                        long endTime = System.nanoTime() - startTime;
                        System.out.println("time in nanos: " + endTime);
                        break;
                case 1: Evaluation evaluation = new Evaluation();
                        evaluation.runTPS();
                        break;
                case 2: long run0 = 377392865700L;
                        long run1 = 435784403900L;
                        long run2 = 423182624900L;
                        long average = (run0 + run1 + run2) / 3;
                        long oneHour = 3600000000000L;

                        System.out.println("----------------------------------");
                        System.out.println("Test run #1 result in ns: " + run0);
                        System.out.println("Test run #2 result in ns: " + run1);
                        System.out.println("Test run #3 result in ns: " + run2);
                        System.out.println("Average time in ns: " + average);
                        System.out.println("  ");
                        System.out.println("Swaps per Hour (SPH): " + (oneHour / average));
                        System.out.println("----------------------------------");
                        break;
                case 3: run = false;
                        break;
                default: System.out.println("entry not available, please choose a menu entry");
                         break;
            }
        }
    }
}
