import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class Pair{
    Interval interval;
    Iterator<Interval> iterator;
    Pair(Interval interval, Iterator<Interval> iterator){
        this.interval = interval;
        this.iterator = iterator;
    }
}
public class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((x,y) -> x.interval.start - y.interval.start);
        for(int i=0; i<schedule.size() ;i++){
            if(! schedule.get(i).isEmpty()){
                List<Interval> list = schedule.get(i);
                Iterator<Interval> iterator = list.iterator();
                Interval interval = iterator.next();
                queue.offer(new Pair(interval, iterator));
            }
        }



        Pair prev = queue.peek();
        while(!queue.isEmpty()){
            Interval prevInterval = prev.interval;
            Pair next = queue.poll();
            Interval nextInterval = next.interval;
            if(prevInterval.end < next.interval.start){
                result.add(new Interval(prev.interval.end, next.interval.start));
                prev = next;
                if(prev.iterator.hasNext())
                    queue.offer(new Pair(prev.iterator.next(), prev.iterator));
            }else{
                if(prevInterval.end >nextInterval.end){
                    if(next.iterator.hasNext())
                        queue.offer(new Pair(next.iterator.next(), next.iterator));
                    prev = prev;
                }else{
                    if(prev.iterator.hasNext())
                        queue.offer(new Pair(prev.iterator.next(), prev.iterator));
                    prev = next;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
