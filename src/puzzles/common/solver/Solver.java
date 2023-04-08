package puzzles.common.solver;

import java.util.*;


public class Solver{
    private final HashMap<Configuration, Configuration> predecessors = new HashMap<>();
    private final Queue<Configuration> queue = new LinkedList<>();
    private final Configuration start;
    private int totalConfigs = 0;
    private int uniqueConfigs = 0;

    public Solver(Configuration start){
        this.start = start;
    }

    public Collection<Configuration> solve(){
        queue.add(start);
        predecessors.put(start, null);
        uniqueConfigs += queue.size();
        totalConfigs += predecessors.size();
        while(!queue.isEmpty()){
            Configuration current = queue.remove();
            if (current.isSolution()) {
                return constructPath(predecessors, current);
            } else {
                Collection<Configuration> successors = current.getNeighbors();
                totalConfigs += successors.size();
                for (Configuration nbr : successors) {
                    if (!predecessors.containsKey(nbr)) {
                        uniqueConfigs += 1;
                        predecessors.put(nbr, current);
                        queue.add(nbr);
                    }
                }
            }
        }
        return null;
    }

    public Collection<Configuration> constructPath(HashMap<Configuration, Configuration> predecessors,
            Configuration end){
        List<Configuration> path = new LinkedList<>();
        if(predecessors.containsKey(end)) {
            while(end != start){
                path.add(0, end);
                end = predecessors.get(end);
            }
            path.add(0, start);
        }
        return path;
    }

    public int getTotalConfigs() { return totalConfigs; }

    public int getUniqueConfigs() { return uniqueConfigs; }
}

