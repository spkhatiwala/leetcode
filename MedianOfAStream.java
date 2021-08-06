import java.util.*;

public class MedianOfAStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    MedianOfAStream(){
        maxHeap = new PriorityQueue<>((x,y)->y-x);
        minHeap = new PriorityQueue<>((x,y)->x-y);
    }


    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(maxHeap.size()> minHeap.size()+1)
            minHeap.add(maxHeap.poll());
        else if(minHeap.size()>maxHeap.size())
            maxHeap.add(minHeap.poll());
    /*if(maxHeap.size()> minHeap.size()+1)
      minHeap.add(maxHeap.poll());
    else if(minHeap.size()>maxHeap.size())
      maxHeap.add(minHeap.poll());*/
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
        else
            return maxHeap.peek();
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

