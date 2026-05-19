package ucr.algoritmos.pg05algoritmos.model.stack;

import org.junit.jupiter.api.Test;

import java.util.Random;

class LinkedStackTest {
    @Test
    void linkedStackTest() {
        LinkedStack<Integer> stack = new LinkedStack<>();

        try{
            for (int i = 0; i < 10; i++) {
                int value = new Random().nextInt(50);
                System.out.println("push( " + value + ")");
                stack.push(value);
            }

            System.out.println("-------------------------");
            System.out.println("Stack size: " + stack.size());
            System.out.println("-------------------------");
            System.out.println("Peek / Top: " + stack.peek());
            System.out.println(stack);
            System.out.println("-------------------------");

            for (int i = 0; i < 5; i++) {

                System.out.println("pop(): " + stack.pop());
                System.out.println(stack);

            }
        }catch (StackException e){
            throw  new RuntimeException(e);
        }
    }

}