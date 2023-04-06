package puzzles.clock;

import puzzles.common.solver.Configuration;

import java.util.ArrayList;
import java.util.Collection;

public class ClockConfig implements Configuration {
    private final int hours;
    private final int start;
    private final int end;

    public ClockConfig(int hours, int start, int end){
        this.hours = hours;
        this.start = start;
        this.end = end;
    }
    @Override
    public boolean isSolution() {
        return start == end;
    }

    @Override
    public Collection<Configuration> getNeighbors() {
        Collection<Configuration> neighborsList = new ArrayList<>();
        int up = start + 1;
        int down = start - 1;
        if(up > hours){
            up = 1;
        } else if(down <= 0){
            down = hours;
        }
        ClockConfig forward = new ClockConfig(hours, up, end);
        ClockConfig backward = new ClockConfig(hours, down, end);
        neighborsList.add(backward);
        neighborsList.add(forward);
        return neighborsList;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof ClockConfig otherClock){
            return this.hours == otherClock.hours
                    && this.start == otherClock.start
                    && this.end == otherClock.end;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.hours + this.start + this.end;
    }

    @Override
    public String toString() {
        return String.valueOf(start);
    }
}
