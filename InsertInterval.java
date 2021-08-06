import java.util.*;

class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
       List<Interval> returnList = new LinkedList<>();
       int i ;
       for(i=0; i<intervals.size(); i++){
           if(intervals.get(i).start > newInterval.start){
               break;
           }
           returnList.add(intervals.get(i));
       }
       returnList.add(newInterval);
       while(i< intervals.size()){
           Interval lastInterval = returnList.get(returnList.size()-1);
           Interval interval = intervals.get(i);
           if(lastInterval.end >= interval.start){
               lastInterval.end = Math.max(lastInterval.end, interval.end);
           }else{
               returnList.add(interval);
           }
           i++;
       }
       return returnList;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
