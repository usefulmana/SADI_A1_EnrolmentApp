package sadi.person;

public class StudentFactory {
    public static Student createStudent(String id,String name)
    {
        return new Student(id,name);
    }
}
