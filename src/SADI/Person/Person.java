package SADI.Person;


import SADI.Courses.Courses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Person {
    private String id;
    private String name;
    private Date birthday;
    private List<Courses> courses = new ArrayList<>();

    public abstract String getId();
    public abstract String getName();
    public abstract Date getBirthday();
    public abstract List<Courses> getCourses();
}
