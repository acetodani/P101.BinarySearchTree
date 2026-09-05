# P101 Binary Search Tree

CS400 project. Generic BST that implements the `SortedCollection` interface.

## Files

- `SortedCollection.java` - the interface (given)
- `BinaryNode.java` - node class with parent/left/right refs, plus the
  traversal print methods (given)
- `BinarySearchTree.java` - my implementation

## Progress

Done: `add`, `addHelper`, `size`, `isEmpty`, `clear`

Todo: `contains`, and write the tester

Went with a recursive `size()` instead of a counter field so there's nothing
to keep in sync. Makes it O(n) but I'd rather not forget to update a counter
later.
