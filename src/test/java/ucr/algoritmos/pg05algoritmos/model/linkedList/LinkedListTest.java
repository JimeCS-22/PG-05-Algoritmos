package ucr.algoritmos.pg05algoritmos.model.linkedList;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    void testReverse() {
        LinkedList<Integer> list = new LinkedList<>();
        int[] values = {16,11,2,28,34,44,14,41,17,14};

        for (int value : values){
            list.add(value);
        }

        System.out.println("Lista normal");
        System.out.println(list);
        System.out.println("__________________________________________________");
        System.out.println("Lista alreves según metodo del examen que me piden");
        list.reverse();
        System.out.println(list);
        System.out.println("__________________________________________________");
    }


}
