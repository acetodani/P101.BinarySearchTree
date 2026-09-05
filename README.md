# P101 - Binary Search Tree

CS400 project. Building a generic binary search tree that implements a
`SortedCollection` interface.

## Files

- `SortedCollection.java` - the interface I'm implementing. Defines `add`,
  `contains`, `size`, `isEmpty`, and `clear`. Given as part of the project.
- `BinaryNode.java` - the node class. Each node stores one value plus
  references to its parent and its left/right children. Also has the two
  traversal helpers (`toLevelOrderString` and `toInOrderString`) that print
  the subtree, which are going to be handy for checking my work later.
- `BinarySearchTree.java` - my implementation. This is the file I'm actually
  working in.

## Where I'm at

Done:

- `add(T data)` - throws a `NullPointerException` on null like the interface
  says, wraps the value in a `BinaryNode`, and either makes it the root if the
  tree is empty or hands it off to the helper.
- `addHelper(newNode, subtree)` - the recursive insert. Compares the new value
  against the current subtree's value: anything less than or equal goes left,
  anything strictly greater goes right. If the child slot on that side is
  empty, it drops the node in and sets the parent pointer; otherwise it
  recurses down that side. Duplicates going left is intentional, the interface
  says duplicates get counted separately.
- `size()` plus a `sizeHelper()` - counts recursively instead of keeping a
  counter field around. Walks the whole tree and returns
  `1 + left + right`. Went this way because there's no counter to forget to
  update later when I add removal, though it does mean size is O(n) instead
  of O(1).
- `isEmpty()` - just checks whether `root` is null.
- `clear()` - sets `root` to null and lets the garbage collector reclaim the
  rest of the nodes, since nothing outside the tree is holding references to
  them.

Still to do:

- `contains(Comparable<T> find)` - stubbed out, returns false right now.
  Plan is a loop (or recursive helper) that walks down comparing values, same
  left/right logic as insert.
- Tests. Need to write the tester class and check the shapes with the
  traversal methods, plus edge cases: empty tree, single node, all duplicates,
  values inserted in already-sorted order.

## Notes to self

The `up` parent pointer isn't strictly needed for insert or search, but it's
there in `BinaryNode` so presumably a later part of the project (removal? or a
red-black tree?) wants it. Making sure to keep it set correctly now so I don't
have to go back and fix it.

Insert is O(height). Balanced that's O(log n), but this is the naive insert so
sorted input degenerates into a linked list and it's O(n). Not handling
balancing in this project.
