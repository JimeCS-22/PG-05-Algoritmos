package ucr.algoritmos.pg05algoritmos.model.Tree;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void add() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 10; i++) {
            int value = new Random().nextInt(1, 30);
            bst.add(value);
        }
        System.out.println(bst);
        try {
            System.out.println("Tree size: " + bst.size());
            System.out.println("Min value: " + bst.min());
            System.out.println("Min value: " + bst.max());
            for (int i = 0; i < 10; i++) {
                int value = new Random().nextInt(10, 50);
                System.out.println(bst.contains(value) ? "[" + value + "] exists. Height " + bst.height(value) : "[" + value + "] does not exist");


            }
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }

    }
}