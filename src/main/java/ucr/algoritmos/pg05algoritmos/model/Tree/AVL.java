package ucr.algoritmos.pg05algoritmos.model.Tree;

public class AVL <T extends Comparable<T>> extends BST<T> {

    @Override
    public void add(T element) {
        this.root = add(root, element, "root");
    }

    private BTreeNode<T> add(BTreeNode<T> node, T element, String path) {
        if (node == null) {
            node = new BTreeNode<>(element, "Added as: " + path);
        } else if (compareElement(element, node.data) < 0) {
            node.left = add(node.left, element, "Added as: " +path + "/left");
        } else if (compareElement(element, node.data) > 0) {
            node.right = add(node.right, element, "Added as: " +path + "/right");
        }
        //Obtener el factor de balanceo de este ancestro
        int balance = getBalanceFactor(node);
        //Una vez obtenido el factor de balanceo, revisamos los cuatro casos posibles
        if (balance > 1 && compareElement(element, node.left.data) < 0) {
            node.path = path+". Simple Right Rotate";
        //    return rightRotate(node);
        }
        return node;
    }

    private int getBalanceFactor(BTreeNode<T> node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }



    @Override
    public void remove(T element) throws TreeException {
        super.remove(element);
    }
}
