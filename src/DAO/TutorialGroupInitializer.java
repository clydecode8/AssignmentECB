/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import entity.Programme;

import entity.TutorialGroup;

/**
 *
 * @author deede
 */
public class TutorialGroupInitializer {
    public SortedLinkedListInterface<TutorialGroup> initializeTutorialGroup(){
        Programme p1 = new Programme("", "");
        SortedLinkedListInterface<TutorialGroup> tgList = new SortedLinkedList<>();
        tgList.add(new TutorialGroup("Group 1", 25, p1));
        tgList.add(new TutorialGroup("Group 2", 25, p1));
        tgList.add(new TutorialGroup("Group 3", 25, p1));
        tgList.add(new TutorialGroup("Group 4", 25, p1));
        
        return tgList;
    }


}
