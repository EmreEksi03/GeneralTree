
interface Position {
    int getElement();
}
class TreeNode implements Position {
    private TreeNode parent;
    private TreeNode firstChild;
    private TreeNode nextSibling;
    private int element;

    public TreeNode(TreeNode parent, TreeNode firstChild, TreeNode nextSibling, int element) {
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
        this.element = element;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

}

interface Tree {
    // Returns the position of the root of the tree, or null if the tree is empty.
    Position root();

    // Returns the parent of the given position, or null if it's the root.
    Position parent(Position p) throws IllegalArgumentException;

    // Returns an iterable collection of the children of the given position.
    Iterable<Position> children(Position p) throws IllegalArgumentException;

    // Returns the number of children of the given position.
    int numChildren(Position p) throws IllegalArgumentException;

    // Returns true if the given position is an internal node (has children).
    boolean isInternal(Position p) throws IllegalArgumentException;

    // Returns true if the given position is an external node (a leaf).
    boolean isExternal(Position p) throws IllegalArgumentException;

    // Returns true if the given position is the root of the tree.
    boolean isRoot(Position p) throws IllegalArgumentException;

    // Returns the number of nodes (positions) in the tree.
    int size();

    // Returns true if the tree is empty.
    boolean isEmpty();
}

public class OrderedGeneralTree implements Tree{
    private TreeNode root;
    private int size;
    @Override
    public Position root() {
        return root;
    }

    @Override
    public Position parent(Position p) throws IllegalArgumentException {
        TreeNode n = (TreeNode) p;
        return n.getParent();
    }

    @Override
    public Iterable<Position> children(Position p) throws IllegalArgumentException {
        TreeNode n = (TreeNode) p;
        return (Iterable<Position>) n.getFirstChild();
    }

    @Override
    public int numChildren(Position p) throws IllegalArgumentException {
        int x = 0;
        TreeNode n = (TreeNode) p;
        TreeNode c = n.getFirstChild();
        if (c.getFirstChild() != null)
            while (c.getNextSibling() != null){
                c = c.getNextSibling();
                x++;
            }
        return x;
    }

    @Override
    public boolean isInternal(Position p) throws IllegalArgumentException {
        TreeNode n = (TreeNode) p;
        return n.getFirstChild()!=null;
    }

    @Override
    public boolean isExternal(Position p) throws IllegalArgumentException {
        TreeNode n = (TreeNode) p;
        return n.getFirstChild()==null;
    }

    @Override
    public boolean isRoot(Position p) throws IllegalArgumentException {
        TreeNode n = (TreeNode) p;
        return n==root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public Position addRoot(int e){
        return null;
    }
    public Position addChild(Position p, int e){
        return null;
    }
    public int remove(Position p){
        return 0;
    }
}


