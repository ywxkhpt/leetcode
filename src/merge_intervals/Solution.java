package merge_intervals;

//扫描线算法，先将区间按照开始位置的大小来排序
//然后从前往后扫描区间 判断并更新当前区间
import java.util.*;
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        ArrayList<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals,(a,b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            if(interval.start <= end){//开始位置在当前区间内
                if(interval.end > end){
                    end = interval.end;
                }
            }else{
                res.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}
