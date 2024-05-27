package Queue;

public class CircularQueue {
    static class Queue{
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front =-1;
        }

        //is empty
        public static boolean isEmpty(){
            return front==-1 && rear == -1;
        }
        //is full
        public static boolean isFull(){
           return (rear+1)%size== front;
        }
        //add - O(1)
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //add first element
            if(front==-1){
                front =0;
            }
            rear = (rear+1)%size;
            arr[rear]=data;
        }
        //remove - O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int result = arr[front];
            //remover last element
            if(rear == front){
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }
        //peek O(1)
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
