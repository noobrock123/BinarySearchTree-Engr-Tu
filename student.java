/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author noobrock123-laptop
 */
//Student class is a node
public class student implements nodeADT{
    
    //Variables
    private int ID; //KEY
    private String name;
    private String faculty;
    private boolean isRoot;
    private student left, right;
    
    //Constructors
    public student(int id, String name, String faculty){
        this.ID = id;
        this.name = name;
        this.faculty = faculty;
        isRoot = false;
        left = right = null;
    }
    
    public student(int id, String name){
        this(id, name, "TBC");
    }
    
    public student(int id){
        this(id, "TBC", "TBC");
    }
    
    
    //get, set
    public int getKey() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    @Override
    public student getLeft() {
        return left;
    }
    @Override
    public student getRight() {
        return right;
    }
    @Override
    public void setLeft(student s) {
        left = s;
    }
    @Override
    public void setRight(student s) {
        right = s;
    }
    @Override
    public void setIsRoot(boolean bool) {
        isRoot = bool;
    }
    @Override
    public boolean isRoot() {
        return isRoot;
    }
    
}
