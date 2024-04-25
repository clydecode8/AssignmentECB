/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import entity.Tutor;

/**
 *
 * @author deede
 */
public class TutorInitializer {
    public SortedLinkedListInterface<Tutor> initializeTutor(){
        SortedLinkedListInterface<Tutor> tList = new SortedLinkedList<>();
        
        tList.add(new Tutor("TOO1", "Abu","F",30));
        tList.add(new Tutor("TOO2", "Ali","M",40));
        tList.add(new Tutor("TOO3", "Adam","F",50));
        tList.add(new Tutor("TOO4", "Ahman","M",60));
        tList.add(new Tutor("TOO5", "John","F",31));
        
        return tList;
    }



    
}
