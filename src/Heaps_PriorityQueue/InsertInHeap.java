package Heaps_PriorityQueue;
import java.util.*;

public class InsertInHeap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {  //O(logn) time complexity
            // 1. Add at the last index
            arr.add(data);
            int x = arr.size() - 1;         // Child index
            int par = (x - 1) / 2;           // Parent index

            // 2. Heapify: Maintain heap property (min-heap)
            while (x > 0 && arr.get(x) < arr.get(par)) {
                // Swap elements
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // Update indices
                x = par;
                par = (x - 1) / 2;
            }
        }

        public void printHeap() {
            System.out.println("Heap elements:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Heap minHeap = new Heap();

        // Add elements to the heap
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(10);

        // Print the heap elements
        minHeap.printHeap();
    }
}
