package edu.ensign.cs235.queue;

public class QueueOnLinkedList {
    //Attributes
    private Node top;
    private Node back;
    private int size;

    QueueOnLinkedList queue_ll;
    //Methods
    private class Node{
        private int data; //Node Data
        private Node next; //Node link

        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    //Method to validate if Queue is empty
    public boolean is_empty(){
        boolean response;
        if(size==0){
            response = true;
        }
        else{
            response = false;
        }
        return response;
    }
    //Method to return size of the Queue
    public int get_size(){
        return size;
    }

    //Method to insert values in the queue
    public void enqueue(int value){
        Node TempNode = new Node(value);
        //This part validates if queue is not empty. If it's, then element is inserted in the top of the queue
        if(is_empty() == true){
            top = TempNode;
            back = TempNode;
        }
        //If queue it's not empty, then element is stored in the back of the queue
        else{
            back.next = TempNode;
            back = TempNode;
        }
        size++; //Increments size
    }
    //Method to delete element of the Queue
    public int dequeue(){
        int output;
        //Validation. If queue is not empty, then it deletes the top element.
        if(is_empty() == false){
        output = top.data;
        top = top.next;
        }
        //If queue is empty, then we throw an error.
        else{
            throw new RuntimeException("Your queue is empty");
        }
        size--; //Decrement size
        return output;
    }
    //Method prints the top value in the queue
    public int peek_front(){
        int output;
        if(is_empty() == false){
            output = top.data;
        }
        else{
        throw new RuntimeException("Your queue is empty");}
        return output;
    }
    //Method prints the rear of the queue
    public int peek_rear(){
        int output;
        if(is_empty() == false){
            output = back.data;
        }
        else{
            throw new RuntimeException("Your queue is empty");}
        return output;
    }
    //Method clears the queue
    public void clear(){
        top = null;
        back = null;
        size = 0; //Size is set to 0 again
    }
    //Method overrides the toString method to print the queue in the required format
    @Override
    public String toString() {
        String output = String.format("[");
        Node current;
        current = top;
        for (int j = 0; j < size; j++) {
            output += String.format("%d, ",current.data);
            current = current.next;
        }
        output += String.format("]");
        return output;
    }
}
