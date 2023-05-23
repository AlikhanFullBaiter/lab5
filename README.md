# Binary Search Tree (BST)🧩
The ***Binary Search Tree (BST)*** is a data structure that stores a collection of key-value pairs in a binary tree format. It allows for efficient insertion, deletion, and retrieval operations based on the keys.

# Usage 👨‍💻
The BST implementation provided in this project allows for storing key-value pairs, where the keys must implement the Comparable interface. The BST supports the following operations:

***put(K key, V value):*** Inserts a key-value pair into the BST.

***get(K key):*** Retrieves the value associated with the given key from the BST.

***delete(K key):*** Deletes a key-value pair from the BST.

***iterator():*** Returns an iterable collection of keys in ascending order.

# Example 
```bash
BST<Integer, String> bst = new BST<>();
bst.put(5, "Apple");
bst.put(2, "Banana");
bst.put(7, "Orange");

System.out.println(bst.get(2));  // Output: "Banana"

bst.delete(5);

for (Integer key : bst.iterator()) {
    System.out.println(key);
}
// Output:
// 2
// 7

```
In the example above, i create a BST of Integer keys and String values. We insert key-value pairs using the put() method, retrieve a value using the get() method, delete a pair using the delete() method, and iterate over the keys using the iterator() method.
