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
        if(isEmpty()) throw new TreeException("Binary Tree is empty");
        return size(root);
    }

    private int size(BTreeNode<T> nodo){
        if(nodo == null) return 0;
        return size(nodo.left) + size(nodo.right) + 1;
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
        if (isEmpty()) throw new TreeException("Binary Tree is empty");
        return binarySearch(this.root, element);
    }

    public boolean binarySearch( BTreeNode<T> node, T element){
        if (node == null) return false;
        else if (equals(node.data, element)) return true;
        else return  binarySearch(node.left, element) || binarySearch(node.right, element);
    }


    @Override
    public void add(T element) {
        this.root = add(root, element, "root");
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

    private BTreeNode<T>add(BTreeNode<T> node, T element, String path){

        if(node == null){

            node = new BTreeNode<>(element, path);

        }else{
            //debemos establecer algún criterio para insertar elementos
            int value = new Random().nextInt(10);
            if (value % 2==0) //si el valor es para enserte por la izquierda
                node.left = add(node.left, element,  path + " /left");
            else node.right = add(node.right, element,   path + " /right");
        }

        return node;

    }


    @Override
    public int height(T element) throws TreeException {
        return 0;
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
        if(isEmpty()) throw new TreeException("Binary Tree is empty");
        return min(root);
    }

    private T min(BTreeNode<T> node){

        if(node.left != null && node.right != null)//Caso 1. Cuando el nodo tiene los dos hijos
            return minElement(node.data,minElement(min(node.left), min (node.right)));
         else if (node.left != null) //Caso 2. Cuando el nodo tiene un solo hijo izquierdo
            return minElement(node.data, min(node.left));
        else if (node.right != null) //Caso 3. Cuando el nodo tiene un solo hijo derecho
            return minElement(node.data, min(node.right));
        else
        return node.data;// es una hoja
    }

    private T minElement(T a, T b){

        if(a == null) return b;
        else if(b == null) return a;
        return compareElement(a,b) <= 0 ? a : b;

    }



    @Override
    public T max() throws TreeException {
        return null;
    }

    @Override
    public String preOrder() throws TreeException {
        if(isEmpty()) throw new TreeException("Binary Tree is empty");
        return preOrder(root);
    }

    //Recorrido: N-L-R
    private String preOrder(BTreeNode<T> node){
        String result = "";
        if(node != null) {
            result  = node.data + "( " + node.path + " ) ";
            result += preOrder(node.left);
            result += preOrder(node.right);

        }
        return result;
    }

    @Override
    public String inOrder() throws TreeException {
        if(isEmpty()) throw new TreeException("Binary Tree is empty");
        return inOrder(root);
    }

    //Recorrido: L-N-R
    private String inOrder(BTreeNode<T> node){
        String result = "";
        if(node != null) {
            result  = inOrder(node.left);
            result += node.data + ", " ;
            result += inOrder(node.right);
        }
        return result;
    }

    @Override
    public String postOrder() throws TreeException {
        if(isEmpty()) throw new TreeException("Binary Tree is empty");
        return postOrder(root);
    }

    //Recorrido: L-R-N
    private String postOrder(BTreeNode<T> node){
        String result = "";
        if(node != null) {
            result  = postOrder(node.left);
            result += postOrder(node.right);
            result += node.data + ", " ;

        }
        return result;
    }


    @Override
    public String nodeHeight() throws TreeException {
        return "";
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Binary Tree is empty";
        String result = "Binary Tree Tour\n";
        result += "PreOrder (N-L-R): " + preOrder(root) + "\n";
        result += "InOrder (L-N-R): "  + inOrder(root) + "\n";
        result += "PostOrder (L-R-N): "  + postOrder(root) + "\n";
        return result;
    }

    /**Metodos de ayuda**/
    private boolean equals(T a, T b)  {
        return a==null ? b==null : a.equals(b);
    }

    //metodo generico de comparacion
    private int compareElement(T a, T b) {
        return a.compareTo(b);
    }



}
