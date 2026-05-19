package ucr.algoritmos.pg05algoritmos.model.Tree;

import ucr.algoritmos.pg05algoritmos.model.Tree.Tree;

public class BTreeNode<T> {

        public T data;
        public BTreeNode<T> left, right;
        public String path;//Es la ruta de inserción Ejemplo: RAIZ-IZQUIERDO-DERECHO

        public BTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    public BTreeNode(T data, String path) {
        this.data = data;
        this.path = path;
        this.left = right = null;
    }
}