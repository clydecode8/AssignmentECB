package entity;

import adt.CircularArrayList;
import adt.ListInterface;
import java.util.Objects;

public class CourseProgramme {
    private Course course;
    private Programme programme;
    private static ListInterface<CourseProgramme> courseProgrammeList= new CircularArrayList<>();

    public CourseProgramme() {
        
        course = null;
        programme = null;
    }

    public CourseProgramme(Course course, Programme programme) {
        this.course = course;
        this.programme = programme;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    @Override
    public String toString() {
        return "CourseProgramme{" +
                "course=" + course +
                ", programme=" + programme +
                '}';
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CourseProgramme that = (CourseProgramme) o;
            return Objects.equals(course, that.course) &&
            Objects.equals(programme, that.programme);
       }

    @Override
    public int hashCode() {
        return Objects.hash(course, programme);
    }

    public static ListInterface<CourseProgramme> getCourseProgrammeList() {
        return courseProgrammeList;
    }

    public static void addCourseProgrammeList(CourseProgramme courseProgramme) {
        courseProgrammeList.add(courseProgramme);
    }
    
   public static void removeCourseProgrammeList(CourseProgramme courseProgramme) {
    if (courseProgrammeList.contains(courseProgramme)) {
        courseProgrammeList.remove(courseProgramme);
        }
    }   
   
   

    
}


