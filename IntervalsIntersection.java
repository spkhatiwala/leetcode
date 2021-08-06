import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
       List<Interval> intervalList = new ArrayList<>();
       int i1 = 0;
       int i2 = 0;
       while(i1 < arr1.length && i2< arr2.length){
           Interval interval1 = arr1[i1];
           Interval interval2 = arr2[i2];
           Interval interval = new Interval(Math.max(interval1.start, interval2.start), Math.min(interval1.end, interval2.end));
           intervalList.add(interval);
           if(interval1.end < interval2.end)
               i1++;
           else if(interval2.end < interval1.end)
               i2++;
           else{
               i1++;
               i2++;
           }
       }
       return intervalList.toArray(new Interval[intervalList.size()]);
    }





    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
