package ucr.algoritmos.pg05algoritmos.model.Tree;

import java.util.Random;

public class BTree<T extends Comparable<T>> implements Tree<T> {
    private BTreeNode<T> root; //representa la unica entrada al árbol

    //Constructor
    public BTree(){
        this.root =null;
    }
    @Override
    public int size() throws TreeException {
        return 0;
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return  this.root == null;
    }

    @Override
    public boolean contains(T element) throws TreeException {
        return false;
    }


    @Override
    public void add(T element) {
        this.root = add(root, element);
    }


    @Override
    public int height(T element) throws TreeException {
        return 0;
    }

    private BTreeNode<T>add(BTreeNode<T> node, T element){

        if(node == null){

            node = new BTreeNode<>(element);

        }else{
            //debemos establecer algún criterio para insertar elementos
            int value = new Random().nextInt(10);
            if (value % 2==0) //si el valor es para enserte por la izquierda
                node.left = add(node.left, element);
            else node.right = add(node.right, element);
        }

        return node;

    }

    @Override
    public void remove(T element) throws TreeException {

    }


    @Override
    public int height() throws TreeException {
        return 0;
    }

    @Override
    public T min() throws TreeException {
        return null;
    }

    @Override
    public T max() throws TreeException {
        return null;
    }

    @Override
    public String preOrder() throws TreeException {
        return "";
    }

    @Override
    public String inOrder() throws TreeException {
        return "";
    }

    @Override
    public String postOrder() throws TreeException {
        return "";
    }

    @Override
    public String nodeHeight() throws TreeException {
        return "";
    }
}
