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
    }

}