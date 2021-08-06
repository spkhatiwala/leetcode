import java.util.PriorityQueue;

public class NextInterval {

    static class Interval {
        int start = 0;
        int end = 0;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[] findNextInterval(Interval[] intervals) {
        int []  retArray = new int[intervals.length];
        int n = intervals.length;
        PriorityQueue<Integer> maxStartTime = new PriorityQueue<>(n, (a,b) -> intervals[b].start - intervals[a].start);
        PriorityQueue<Integer> maxEndTime = new PriorityQueue<>(n, (a,b) -> intervals[b].end - intervals[a].end);
        for(int i=0; i< intervals.length; i++){
            maxStartTime.add(i);
            maxEndTime.add(i);
        }


        while(!maxEndTime.isEmpty()){
            int x = maxEndTime.poll();
            int endTime = intervals[x].end;
            int idx = -1;
            while(!maxStartTime.isEmpty() && intervals[maxStartTime.peek()].start >= endTime){
                idx = maxStartTime.poll();
            }
            retArray[x] = idx;
        }
        return retArray;
    }



    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
