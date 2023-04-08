package puzzles.strings;

import puzzles.common.solver.Configuration;
import java.util.ArrayList;
import java.util.Collection;

public class StringsConfig implements Configuration {
    private final String start;
    private final String finish;
    public StringsConfig(String start, String finish){
        this.start = start;
        this.finish = finish;
    }
    @Override
    public boolean isSolution() { return start.equals(finish); }

    @Override
    public Collection<Configuration> getNeighbors() {
        Collection<Configuration> neighborsList = new ArrayList<>();
        for(int i = 0; i < start.length(); i++){
            char up = (char) (start.charAt(i)+1);
            char down = (char) (start.charAt(i)-1);
            if(up > 'Z'){
                up = 'A';
            } else if(down < 'A'){
                down = 'Z';
            }
            StringBuilder upStr = new StringBuilder(start);
            StringBuilder downStr = new StringBuilder(start);
            upStr.setCharAt(i, up);
            downStr.setCharAt(i, down);
            StringsConfig forward = new StringsConfig(upStr.toString(), finish);
            StringsConfig backward = new StringsConfig(downStr.toString(), finish);
            neighborsList.add(backward);
            neighborsList.add(forward);
        }
        return neighborsList;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof StringsConfig otherString){
            return this.start.equals(otherString.start)
                    && this.finish.equals(otherString.finish);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.start.hashCode() + this.finish.hashCode();
    }

    @Override
    public String toString() {
        return start;
    }
}
