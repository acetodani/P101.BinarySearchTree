public class BinarySearchTree<T extends Comparable<T>> implements SortedCollection<T> {

    protected BinaryNode<T> root = null;

    public BinarySearchTree() {
    }

    // add()
    public void add(T data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        BinaryNode<T> newNode = new BinaryNode<T>(data);

        if (root == null) {
            root = newNode;
        } else {
             addHelper(newNode, root);
        }
        size++;
    }

    // contains()
    public boolean contains(Comparable<T> find) {
        return false;
    }

    // size()
    public int size() {
        return 0;
    }

    // isEmpty()
    public boolean isEmpty() {
        return false;
    }

    // clear()
    public void clear() {

    }

    /**
     * Performs the naive binary search tree insert algorithm to recursively
     * insert the provided newNode (which has already been initialized with a
     * data value) into the provided tree/subtree. When the provided subtree
     * is null, this method does nothing.
     */
    protected void addHelper(BinaryNode<T> newNode, BinaryNode<T> subtree) {
        if (subtree == null) {
            return;
        }
        // newNode is less than or equal to subtree's value must go left
        if (newNode.entry.compareTo(subtree.getEntry()) <= 0) {
            if (subtree.downLeft() == null) {
                subtree.setLeft(newNode);
                newNode.setUp(subtree);
            } else {
                addHelper(newNode, subtree.downLeft());
            }
            // newNode is strictly greater than subtree's value must go right
        } else if (subtree.downRight() == null) {
            subtree.setRight(newNode);
            newNode.setUp(subtree);
        } else {
            addHelper(newNode, subtree.downRight());
        }
    }
}
