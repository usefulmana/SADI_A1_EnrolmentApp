package sadi.person;

import sadi.enrollment.StudentEnrolment;
import sadi.iterator.MyIterator;

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
    private StudentList studentList= StudentList.getINSTANCE();
    private int item = 0;


    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        studentList.addStudent(this);
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

    public void subscribe()
    {
        StudentEnrolment.getStudentSubscribers().add(this);
    }

    public void unsubscribe()
    {
        StudentEnrolment.getStudentSubscribers().remove(this);
    }


}
