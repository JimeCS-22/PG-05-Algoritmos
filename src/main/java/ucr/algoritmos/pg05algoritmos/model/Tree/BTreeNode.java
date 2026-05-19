package ucr.algoritmos.pg05algoritmos.model.Tree;

import ucr.algoritmos.pg05algoritmos.model.Tree.Tree;

public class BTreeNode<T> {

        public T data;
        public BTreeNode<T> left, right;

        public BTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

}