package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a binary search tree (BST) data structure.
 *
 * @param <K> the type of keys stored in the BST (must implement Comparable interface)
 * @param <V> the type of values stored in the BST
 */
public class BST<K extends Comparable <K> , V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        /**
         * Inner class representing a node in the BST.
         */
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Inserts a key-value pair into the BST.
     *
     * @param key the key to insert
     * @param val the value associated with the key
     */
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
    }

    /**
     * Retrieves the value associated with the given key in the BST.
     *
     * @param key the key to search for
     * @return the value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.val;
    }

    private Node get(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }

    /**
     * Deletes a key and its associated value from the BST.
     *
     * @param key the key to delete
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node temp = node;
                node = min(temp.right);
                node.right = deleteMin(temp.right);
                node.left = temp.left;
            }
        }

        return node;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * Returns an iterable collection of keys in the BST, in ascending order.
     *
     * @return an iterable collection of keys
     */
    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }

    private void inOrderTraversal(Node node, List<K> keys) {
        if (node != null) {
            inOrderTraversal(node.left, keys);
            keys.add(node.key);
            inOrderTraversal(node.right, keys);
        }
    }


    public int findHeight() {
        return Height(root);
    }
    private int Height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = Height(node.left);
            int rightHeight = Height(node.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1; }
        }
    }
}