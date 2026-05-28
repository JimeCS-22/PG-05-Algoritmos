package ucr.algoritmos.pg05algoritmos.model.Tree;

public class AVL<T extends Comparable<T>> extends BST<T>{
    @Override
    public void add(T element) {
        try {
            this.root = add(root, element, "root");
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
    }

    private BTreeNode<T> add(BTreeNode<T> node, T element, String path) throws TreeException {

        if (node == null){
            node = new BTreeNode<>(element, "Added as: " + path);
        }else if (compareElement(element, node.data)<0) node.left = add(node.left, element, "Added as: " + path + " /Left");
        else if (compareElement(element, node.data)>0) node.right = add(node.right, element, "Added as: " + path + " /Right");

        //obtenemos el factor de balanceo de este su ancestro
        int balance = getBalanceFactor(node);
        //una vez obtenido el factor de balanceo , revisamos los 4 casos posibles
        if (balance <1 && compareElement(element, node.left.data)<0) {
            node.path = path + ". Simple Right Rotate";
            return rigthRotate(node);
        }
        if (balance <1 && compareElement(element, node.right.data)<0)
            node.right = add(node.right, element, "Added as: " + path + " /Right");
        return node;
    }

    @Override
    public void remove(T element) throws TreeException {
        super.remove(element);
    }

    //Formula de Balanceo: altura(subarbol_izq) - altura(subarbol derecho)
    private int getBalanceFactor(BTreeNode<T> node) throws TreeException {
        if (node == null) return 0;
        return height(node.left.data) - height(node.right.data);
    }

    private BTreeNode<T> rigthRotate(BTreeNode<T> node) {
        return null;
    }



}
