package ucr.algoritmos.pg05algoritmos.model.Tree;

/**
 * LAB01 y Lexis son la misma persona pero en computadora diferente, una es en la universidad y la otra desde la casa.
 */

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;


class BTreeTest {

    @Test
    public void insert() {
        BTree <Integer> bTree= new BTree();
        bTree.add(10);
        bTree.add(20);
        bTree.add(30);
        bTree.add(40);
        System.out.println(bTree);
        try {
            System.out.println("Tree size: " + bTree.size());
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }

    }


}