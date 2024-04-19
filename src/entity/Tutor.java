package entity;

import java.util.Objects;
import adt.SortedLinkedListInterface;
import adt.SortedLinkedList;

public class Tutor implements Comparable<Tutor> {
    private String tutorId;
    private String tutorName;
    private String gender;
    private int age;
    private static SortedLinkedListInterface<Tutor> tutorList = new SortedLinkedList<>();

    public Tutor(){
        
    }
    public Tutor(String tutorId, String tutorName, String gender, int age) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.gender = gender;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   


    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public SortedLinkedListInterface<Tutor> getTutorList() {
        return tutorList;
    }

    public void setTutorList(Tutor tutor) {
        tutorList.add(tutor);
    }
    

    

    @Override
    public int compareTo(Tutor o) {
        // Implement comparison logic based on tutorId or tutorName
//        return this.tutorId.compareTo(o.tutorId);
       return 1;
    }

  
}