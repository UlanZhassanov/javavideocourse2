package lambda;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public int id;
    public String name;
    public String surname;
    public int grade;

    public Student(int id, String name, String surname, int grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                '}';
    }
}

class StudentTest{
    public void studentInfo(ArrayList<Student> s, StudentCheck sc){
        for (Student ss: s) {
            if (sc.check(ss)){
                System.out.println(ss);
            }
        }
    }

    public static void main(String[] args) {
        StudentTest stest = new StudentTest();
        ArrayList<Student> studentList = new ArrayList<>();

        Student st1 = new Student(1,"Jack", "Grealish",5);
        Student st2 = new Student(2,"Jack", "Butland",3);
        Student st3 = new Student(3,"Eddie", "Murphy",1);
        Student st4 = new Student(4,"Tomas", "Muller",2);
        Student st5 = new Student(5,"Ilyia", "Ilyin",4);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);

        stest.studentInfo(studentList, s -> {return s.grade>3;});
    }
}

interface StudentCheck{
    boolean check(Student s);
}
