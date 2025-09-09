package Heaps_PriorityQueue;
import java.util.*;

public class PQforObjects {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            // Compare students based on rank
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {

        //Ascending order Priority Queue
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+ " -> "+pq.peek().rank);
            pq.remove();
        }

        System.out.println();

        //Descending order Priority Queue
        PriorityQueue<Student> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(new Student("A", 4));
        pq1.add(new Student("B", 5));
        pq1.add(new Student("C", 2));
        pq1.add(new Student("D", 12));

        while(!pq1.isEmpty()){
            System.out.println(pq1.peek().name+ " -> "+pq1.peek().rank);
            pq1.remove();
        }
    }

}
