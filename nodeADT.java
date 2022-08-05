/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author noobrock123-laptop
 */
public interface nodeADT {
    
    public student getLeft();
    public student getRight();
    public void setLeft(student s);
    public void setRight(student s);
    public void setIsRoot(boolean bool);
    public boolean isRoot();
}
