package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

class StudentTest {

    //StudentCheck
    public void studentInfo(ArrayList<Student> s, StudentCheck sc) {
        for (Student ss : s) {
            if (sc.check(ss)) {
                System.out.println(ss);
            }
        }
        System.out.println("-------------------------------");
    }


    //Predicate
    public void studentInfoPred(ArrayList<Student> s, Predicate<Student> sc) {
        for (Student ss : s) {
            if (sc.test(ss)) {
                System.out.println(ss);
            }
        }
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        StudentTest stest = new StudentTest();
        ArrayList<Student> studentList = new ArrayList<>();

        Student st1 = new Student(1, "Jack", "Grealish", 5);
        Student st2 = new Student(2, "Jack", "Butland", 3);
        Student st3 = new Student(3, "Eddie", "Murphy", 1);
        Student st4 = new Student(4, "Tomas", "Muller", 2);
        Student st5 = new Student(5, "Ilyia", "Ilyin", 4);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);

        //StudentCheck
        stest.studentInfo(studentList, s -> s.grade > 3);
        StudentCheck sc2 = s -> s.grade == 5;
        stest.studentInfo(studentList, sc2);

        //Predicate
        stest.studentInfoPred(studentList, s -> s.grade > 1);
        Predicate<Student> p1 = student -> student.grade > 2;
        Predicate<Student> p2 = student -> student.grade < 5;

        stest.studentInfoPred(studentList, p1.and(p2));
        stest.studentInfoPred(studentList, p1.or(p2));
        stest.studentInfoPred(studentList, p1.negate());

    }
}

interface StudentCheck {
    boolean check(Student s);
}
