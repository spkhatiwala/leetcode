import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MedianOfAStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    Map<Integer,Integer> map ;

    public MedianOfAStream(){
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        map = new TreeMap<>();
    }




    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        map.put(num,num);
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else {
            if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                 return (minHeap.peek() + maxHeap.peek()) / 2.0;
            else
                return -1;
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
