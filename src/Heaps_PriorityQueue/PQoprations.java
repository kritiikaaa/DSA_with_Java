package Heaps_PriorityQueue;
import java.util.*;

public class PQoprations {
    public static void main(String[] args) {

        // for ascending order priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        System.out.println("Ascending order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

        System.out.println();

        //for descending order priority queue
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(3);
        pq1.add(4);
        pq1.add(1);
        pq1.add(7);
        System.out.println("Descending order:");
        while (!pq1.isEmpty()) {
            System.out.println(pq1.peek());
                pq1.remove();
        }
    }
}
