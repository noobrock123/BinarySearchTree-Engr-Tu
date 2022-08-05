
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author noobrock123-laptop
 */
public class mainClass {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int input;
        String name;
        int id;
        mainLoop:while (true) {
            System.out.println("1: Search\n" + "2: Insert\n" +
                    "3: Delete\n" + "4: Show data\n" + "5: Check if empty");
            System.out.print("Please enter: ");
            input = sc.nextInt();
            switch(input) {
                case 1:
                    id = sc.nextInt();
                    System.out.println(bst.search(id));
                    break;
                case 2:
                    System.out.print("Insert id: ");
                    id = sc.nextInt();
                    System.out.print("Insert name: ");
                    name = sc.next();
                    if (name.compareTo("") == 0) {
                        bst.insert(new student(id));
                    }
                    else {
                        bst.insert(new student(id, name));
                    }
                    System.out.println("New student has been added");
                    break;
                case 3:
                    id = sc.nextInt();
                    bst.delete(id);
                    break;
                case 4:
                    if (bst.isEmpty()) {
                        System.err.println("Error: The tree is empty!");
                    }
                    else {
                        bst.inOrderTra(null);
                    }
                    break;
                case 5:
                    System.out.println(bst.isEmpty());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break mainLoop;
                default:
                    System.out.println("Try Again!");
            }
        }
    }
}
