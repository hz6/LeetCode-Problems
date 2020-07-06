import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));// sort the intervals according to the upper limit

        int upperLimit = intervals[0][1];// interval with smallest upper limit
        int count = 1;// number of non-overlapping interval, initially 1

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < upperLimit) {
                // lower limit of this interval is smaller than upper of previous
                // interval(overlapped)
                continue;
            }
            count++;
            upperLimit = intervals[i][1];
        }

        return intervals.length - count;
    }
}