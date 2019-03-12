package SADI.Person;

import SADI.Courses.Course;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student{
    private String id;
    private String name;
    private Date birthday;
    private static List<Student> studentList = new ArrayList<>();


    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        studentList.add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.birthday = simpleDateFormat.parse(birthday);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public static Student searchStudent(String studentID)
    {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(studentID))
            {
                return studentList.get(i);
            }
        }
        return null;
    }


    public static void printStudentInfo()
    {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getId() + "         " + studentList.get(i).getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
