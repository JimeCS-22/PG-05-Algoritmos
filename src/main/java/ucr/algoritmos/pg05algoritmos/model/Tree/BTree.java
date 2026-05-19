package ucr.algoritmos.pg05algoritmos.model.Tree;

public class BTree<T extends Comparable<T>> implements Tree {
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
    public boolean contains(Object element) throws TreeException {
        return false;
    }

    @Override
    public void add(Object element) {
        this.root = add(root, element);
    }

    private BTreeNode<T>add(BTreeNode<T>, Object element){

        if(this.root == null){

        }

    }

    @Override
    public void remove(Object element) throws TreeException {

    }

    @Override
    public int height(Object element) throws TreeException {
        return 0;
    }

    @Override
    public int height() throws TreeException {
        return 0;
    }

    @Override
    public Object min() throws TreeException {
        return null;
    }

    @Override
    public Object max() throws TreeException {
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
