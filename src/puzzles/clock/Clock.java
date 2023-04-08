package puzzles.clock;

import puzzles.common.solver.Configuration;
import puzzles.common.solver.Solver;
import java.util.Collection;

/**
 * The main program for the Clock puzzle. It is run on the command line
 * with the number of hours the clock has (hours), the starting hour (start),
 * and the ending hour(end)
 *
 * @author Tiffany Lee
 */
public class Clock{
    /**
     * The main method.
     *
     * @param args command line arguments (hour, start, end)
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(("Usage: java Clock hours start end"));
            System.exit(1);
        } else {
            int hours = Integer.parseInt(args[0]);
            int start = Integer.parseInt(args[1]);
            int end = Integer.parseInt(args[2]);
            ClockConfig clock = new ClockConfig(hours, start, end);
            Solver solver = new Solver(clock);
            int step = 0;
            Collection<Configuration> solved = solver.solve();
            System.out.println("Hours: " + hours + ", Start: " + start + ", End: " + end);
            System.out.println("Total configs: " + solver.getTotalConfigs());
            System.out.println("Unique configs: " + solver.getUniqueConfigs());
            if(solved != null){
                for(Configuration hour : solved){
                    System.out.println("Step " + step + ": " + hour);
                    step += 1;
                }
            } else {
                System.out.println("No solution");
            }
        }
    }
}
