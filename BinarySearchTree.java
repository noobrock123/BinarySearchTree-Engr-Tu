/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author noobrock123-laptop
 */
public class BinarySearchTree implements bstADT {
    
    private student treeRoot;
    
    public BinarySearchTree(student s){
        treeRoot = s;
    }
    
    public BinarySearchTree() {
        this(null);
    }
    
    @Override
    public int search(int key) {
        if (isEmpty()) {
            System.err.println("No student has been inserted yet!");
            return -1;
        }
        else {
            student curr = treeRoot;
            while (true) {
                if (curr == null) {
                    return -1;
                }
                else if (curr.getKey() == key) {
                    System.out.println(curr.getName());
                    return key;
                }
                else if (curr.getKey() > key) {
                    System.out.println("Going to left subtree");
                    curr = curr.getLeft();
                }
                else {
                    System.out.println("Going to right subtree");
                    curr = curr.getRight();
                }
            }
        }
    }
    
    @Override
    public void insert(student s) {
        if (treeRoot == null) {
            treeRoot = s;
        }
        else {
            student curr = treeRoot;
            student parent;
            int key = s.getKey();
            while (true) {
                parent = curr;
                if (curr.getKey() > key) {
                    curr = curr.getLeft();
                    if (curr == null) {
                        parent.setLeft(s); break;
                    }
                }
                else {
                    curr = curr.getRight();
                    if (curr == null) {
                        parent.setRight(s); break;
                    }
                }
            }
        }
    }
    
    @Override
    public void delete(int key) {
        if (isEmpty()) {
            System.err.println("No students in this tree!");
        }
        else {
            student curr = treeRoot;
            student parent = treeRoot;
            while (true) {
                if (curr == null) {
                    System.out.println("Not found."); break;
                }
                if (curr.getKey() > key) {
                    parent = curr;
                    curr = curr.getLeft();
                }
                else if (curr.getKey() < key) {
                    parent = curr;
                    curr = curr.getRight();
                }
                else {
                    //If the node is a leaf
                    if (curr.getLeft() == null && curr.getRight() == null) {
                        if (curr == treeRoot) {
                            treeRoot = null;
                            System.out.println(curr.getName() + " has been removed.");
                        }
                        else if (parent.getKey() > key){
                            System.out.println("Removing " + parent.getLeft().getName());
                            parent.setLeft(null);
                        }
                        else if (parent.getKey() < key) {
                            System.out.println("Removing " + parent.getRight().getName());
                            parent.setRight(null);
                        }
                    }
                    //Otherwise
                    else {
                        //In-order successor
                        student inorder;
                        boolean whichTree; //0 = left subtree, 1 = right subtree
                        if (parent.getKey() > key) {
                            inorder = curr.getLeft();
                            whichTree = false;
                        }
                        else {
                            inorder = curr.getRight();
                            whichTree = true;
                        }
                        //Sub loop
                        while (true) {
                            if (inorder.getLeft() == null || inorder.getRight() == null) {
                                System.out.println(inorder.getName() + " is the order successor");
                                if (parent.getKey() > key){
                                    parent.setLeft(inorder);
                                }
                                else if (parent.getKey() < key) {
                                    parent.setRight(inorder);
                                }
                                break;
                            }
                            if (!whichTree) {
                                if (inorder.getLeft() == null) {
                                    inorder = inorder.getRight();
                                    whichTree = true;
                                }
                                else {
                                    inorder.getLeft();
                                    whichTree = false;
                                }
                            }
                            else {
                                if (inorder.getRight() == null) {
                                    inorder = inorder.getLeft();
                                    whichTree = false;
                                }
                                else {
                                    inorder.getLeft();
                                    whichTree = true;
                                }
                            }
                        }
                    }
                    break; //Out from main loop
                }
            }
        }
    }
    
    @Override
    public void inOrderTra(student s) {
        //Initialize
        student curr = (s == null) ? treeRoot : s;
        //If it has a child or children
        if (curr.getLeft() != null) {
            inOrderTra(curr.getLeft());
        }
        System.out.print(curr.getKey() + ": " + curr.getName() + " ");
        if (curr.getRight() != null) {
            inOrderTra(curr.getRight());
        }
        
    }
    
    @Override
    public boolean isEmpty(){
        return (treeRoot == null);
    }
}
