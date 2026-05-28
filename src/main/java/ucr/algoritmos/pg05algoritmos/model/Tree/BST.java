package ucr.algoritmos.pg05algoritmos.model.Tree;

import java.util.Random;

public class BST<T extends Comparable<T>> extends BTree<T> {

    @Override
    public void add(T element) {
        this.root = add(root, element);
    }

    //Inicialmente el arbol estará apuntando a Null, luego pasará ser (Null, [Valor]), luego de eso se agregará
    //Despues se llama recursivamente para seguir con el mismo proceso con todos los elementos
    private BTreeNode<T>add(BTreeNode<T> node, T element){

        if(node == null){
            node = new BTreeNode<>(element);
        }else if(compareElement(element, node.data) < 0){
           node.left = add(node.left, element);
        } else if(compareElement(element, node.data) > 0){
            node.right = add(node.right, element);
        }
        return node; //Retorna el árbol modificado

    }


    @Override
    public boolean contains(T element) throws TreeException {
        return super.contains(element);
    }

    @Override
    public void remove(T element) throws TreeException {
        super.remove(element);
    }

    @Override
    public T min() throws TreeException {
        return super.min();
    }

    @Override
    public T max() throws TreeException {
        return super.max();
    }

    @Override
    public String preOrder() throws TreeException {
        if(isEmpty()) throw new TreeException("Binary Search Tree is empty");
        return preOrder(root);
    }

    //Recorrido: N-L-R
    private String preOrder(BTreeNode<T> node){
        String result = "";
        if(node != null) {
            result  = node.data + ", ";
            result += preOrder(node.left);
            result += preOrder(node.right);

        }
        return result;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Binary Search Tree is empty";
        String result = "Binary Tree Tour\n";
        try {
        result += "PreOrder (N-L-R): " + preOrder() + "\n";
        result += "InOrder (L-N-R): "  + inOrder() + "\n";
        result += "PostOrder (L-R-N): "  + postOrder() + "\n";

        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
