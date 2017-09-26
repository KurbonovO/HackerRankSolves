package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;
import java.util.Stack;

/*A queue is an abstract data type that maintains the order in which elements were added to it,
allowing the oldest elements to be removed from the front and new elements to be added to the rear.
This is called a First-In-First-Out (FIFO)
A basic queue has the following operations: Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.

In this challenge, you must first implement a queue using two stacks. Then process q queries, where each query is one of the following 3 types:
1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
*/

public class DATASTRUCTURES_Queues_TaleOfTwoStacks <E> {
  //Two stacks that simulate a Queue:
    Stack<E> stack1;
    Stack<E> stack2;
    
    public DATASTRUCTURES_Queues_TaleOfTwoStacks() {
        this.stack1 = new Stack<E>();
        this.stack2 = new Stack<E>();
    }
    
    public void push(E x) {
        stack1.push(x);
    }
    
    public void pop() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }
    
    public Object peek() {
        Object peek;
        
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public static void main(String[] args) {
    	DATASTRUCTURES_Queues_TaleOfTwoStacks <Integer> queue = new DATASTRUCTURES_Queues_TaleOfTwoStacks <Integer> ();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        // Process each query:
        for(int i = 0; i < q; i++) {
            
        	int queryType = scanner.nextInt();
            
            if(queryType == 1) {
                int x = scanner.nextInt();
                queue.push(x);
            }
            
            else if(queryType == 2) {
                queue.pop();
            }
            
            else { //queryType == 3, print first value
                System.out.println( queue.peek() );
            }
        }
        scanner.close();
    }
}

/*
Sample Input
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
Sample Output
14
14

Explanation:
Enqueue 42; queue={42}.
Dequeue the value at the head of the queue, 42; queue={}.
Enqueue 14; queue={14}.
Print the value at the head of the queue, 14; queue={14}.
Enqueue 28; queue={14 <- 28}.
Print the value at the head of the queue, 14; queue={14 <- 28}.
Enqueue 60; queue={14 <- 28 <- 60}.
Enqueue 78; queue={14 <- 28 <- 60 <- 78}.
Dequeue the value at the head of the queue, 14; queue={28 <- 60 <- 78}.
Dequeue the value at the head of the queue, 28; queue={60 <- 78}.
 */