/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import adt.SortedLinkedList;
import adt.SortedLinkedListInterface;
import entity.Course;


public class CourseInitializer {
    public SortedLinkedListInterface<Course> initializeCourse(){
        SortedLinkedListInterface<Course> cList = new SortedLinkedList<>();
                cList.add(new Course("English", "C001", "cd1"));
                cList.add(new Course("Discrete Math", "C002", "cd2"));
                cList.add(new Course("Science","C003","cd3"));
                cList.add(new Course("Information Security", "C004", "cd4"));
                cList.add(new Course("Research", "C005", "cd5"));
                cList.add(new Course("Graphic", "C006", "cd6"));
 

        return cList;
    }
    
}
