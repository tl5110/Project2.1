package puzzles.strings;

import puzzles.common.solver.Configuration;
import puzzles.common.solver.Solver;
import java.util.Collection;

/**
 * The main program for the Strings puzzle. It is run on the command line
 * with the starting string (start) and the finish string (finish)
 *
 * @author Tiffany Lee
 */
public class Strings {
    /**
     * The main method.
     *
     * @param args command line arguments (start, finish)
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(("Usage: java Strings start finish"));
        } else {
            String start = args[0];
            String finish = args[1];
            StringsConfig string = new StringsConfig(start, finish);
            Solver solver = new Solver(string);
            int step = 0;
            Collection<Configuration> solved = solver.solve();
            System.out.println("Start: " + start + ", End: " + finish);
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
