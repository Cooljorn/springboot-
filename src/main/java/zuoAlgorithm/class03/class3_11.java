package zuoAlgorithm.class03;

import java.util.*;
public class class3_11 {
    /*
     * public class Interval {
     *   int start;
     *   int end;
     *   public Interval(int start, int end) {
     *     this.start = start;
     *     this.end = end;
     *   }
     * }
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @param newInterval Interval类
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> insert (ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> newIntervals = new ArrayList<>();
        int i=0;
        for(i=(intervals.size()-1);i>-1;i--){
            //获取合并后的最大newInterval
            if((intervals.get(i).start<=newInterval.start && intervals.get(i).end>=newInterval.start)
                    || (newInterval.start<=intervals.get(i).start && newInterval.end>=intervals.get(i).start)
            ){
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
                intervals.remove(i);
            }
        }
        for(i=0;i<intervals.size();i++){
            //首位置
            if(i==0 && newInterval.end<intervals.get(i).start){
                newIntervals.add(newInterval);
                newIntervals.add(intervals.get(i));
                //末位置
            }else if(i==(intervals.size()-1) && newInterval.start>intervals.get(i).end){
                newIntervals.add(intervals.get(i));
                newIntervals.add(newInterval);
                //中间位置
            }else if(intervals.get(i).end<newInterval.start && i<(intervals.size()-1) && intervals.get(i+1).start>newInterval.end){
                newIntervals.add(intervals.get(i));
                newIntervals.add(newInterval);
            }else {
                newIntervals.add(intervals.get(i));
            }
        }
        if(intervals.size()==0){
            newIntervals.add(newInterval);
        }
        return newIntervals;
    }
    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

