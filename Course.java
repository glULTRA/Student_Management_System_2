import java.util.ArrayList;

public class Course 
{
    private String courses[] = new String[3];

    public void setCourses(String course1, String course2, String course3){
        setCourse1(course1);
        setCourse2(course2);
        setCourse3(course3);
    }

    public void setCourse1(String course1){
        courses[0] = course1;
    }
    public void setCourse2(String course2){
        courses[1] = course2;
    }
    public void setCourse3(String course3){
        courses[2] = course3;
    }

    public String[] getCourses(){
        return courses;
    }

    @Override
    public String toString(){
        return getCourses()[0] + "," + getCourses()[1] + "," + getCourses()[3];
    }
}
