/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructersproject;

import java.util.ArrayList;

/**
 *
 * @author Ali Haydar
 */
public class BinarySearchTree {

    Node root;
    ArrayList<String> list;

    public BinarySearchTree() {
        list = new ArrayList<String>();
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    //This method inserts into binary tree in alphabetical order
    void insert(String data) {

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {

            Node temp = root;

            while (temp != null) {

                int compare = compareWords(data, temp.data);
                if (compare < 0) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return;
                    }
                    temp = temp.right;
                } else if (compare > 0) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return;
                    }
                    temp = temp.left;
                } else if (compare == 0) {
                    return;
                }
            }

        }

    }

    //This method searching the word in binary tree. And if word have been found
    //it returns true. If the word haven't been found 
    //Words with a levinstein distance of less than 3 are listed
    boolean search(String data) {

        if (root.data.equals(data)) {
            return true;
        } else {
            Node temp = root;

            while (temp != null) {
                int compare = compareWords(data, temp.data);

                if (temp.data.equals(data)) {
                    return true;
                }

                if (levenshteinDistance(data, temp.data) < 3 && temp.data != "") {
                    list.add(temp.data);
                }

                if (compare < 0) {
                    temp = temp.right;
                } else if (compare > 0) {
                    temp = temp.left;
                }

            }
        }

        return false;

    }

    
    //This method updates the word in binary search tree.
    void update(String key, String value) {
        Node node = updateSearch(this.root, key);
        if (node != null) {
            node.data = key;
        }
    }

    Node updateSearch(Node node, String key) {
        if (node == null || node.data.equals(key)) {
            return node;
        }
        if (compareWords(key,  node.data) < 0) {
            return updateSearch(node.right, key);
        }
        return updateSearch(node.left, key);
    }

    //This methods deletes the node from tree.
     void delete(String key) {

        Node parent = null;
        Node current = root;

        while (current != null && current.data != key) {

            parent = current;

            if (compareWords(key, current.data) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }

        }

        if (current == null) {
            return;
        }

        // case 1: leaf node
        if (current.left == null && current.right == null) {

            if (current == root) {
                root = null;
            } else {
                if (current == parent.left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

        } // case 2: has one child
        else if (current.left == null || current.right == null) {

            Node child;

            if (current.left != null) {
                child = current.left;
            } else {
                child = current.right;
            }

            if (current == root) {
                root = null;
            } else {
                if (current == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }

        } // case 2: has two children
        else {

            Node successor = current.right;
            Node successorParent = current;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.data = successor.data;
            successorParent.left = successor.right;

        }
    }

    //That recursive methods prints the tree.
    void printTree() {
        printTreeHelper(root);
    }

    void printTreeHelper(Node node) {
        if (node == null) {
            return;
        }

        printTreeHelper(node.left);
        System.out.print(node.data + " ");
        printTreeHelper(node.right);
    }

    //This method removing array list.
    public void removeArrayList() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            list.remove(0);
        }
    }

    //This method compares the words alphabetical order.
    public int compareWords(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            if (word1.charAt(i) < word2.charAt(i)) {
                return -1;
            } else if (word1.charAt(i) > word2.charAt(i)) {
                return 1;
            }
        }

        if (word1.length() < word2.length()) {
            return -1;
        } else if (word1.length() > word2.length()) {
            return 1;
        } else {
            return 0;
        }
    }

    //This method measures levenshtein distance.
    public static int levenshteinDistance(String str1, String str2) {
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j <= str2.length(); j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1), distance[i - 1][j - 1] + cost);
            }
        }

        return distance[str1.length()][str2.length()];
    }

}
