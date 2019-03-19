package insert_interval;

//第一步：重合前一部分
//第二步：重合的部分
//第三步：重合后一部分
import java.util.*;
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval == null) return intervals;
        ArrayList<Interval> res = new ArrayList<Interval>();
        int i = 0;
        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        res.add(newInterval);
        while(i<intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
