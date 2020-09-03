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

        while(run) {
            System.out.println("Welcome to atomic cross-swaps prototype");
            System.out.println("               ");
            System.out.println("please select one menu entry:");
            System.out.println("               ");
            System.out.println("0 - run swap protocol");
            System.out.println("1 - run transactions per second (tps)");
            System.out.println("2 - run swaps per hour (sph)");
            System.out.println("3 - run wrong secret test");
            System.out.println("4 - exit");


            Scanner scanner = new Scanner(System.in);
            int menuEntry = scanner.nextInt();

            switch (menuEntry) {
                case 0: SwapProtocol swapProtocol = new SwapProtocol();
                        break;
                case 1:     // TODO: run tps here
                        break;
                case 2:     // TODO: run sph here
                        break;
                case 3:     // TODO: run wrong secret here
                        break;
                case 4: run = false;
                        break;
                default: System.out.println("entry not available, please choose a menu entry");
                         break;
            }
        }
    }
}
