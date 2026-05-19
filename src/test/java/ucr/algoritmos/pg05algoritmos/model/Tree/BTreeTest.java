package ucr.algoritmos.pg05algoritmos.model.Tree;

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

    }


}