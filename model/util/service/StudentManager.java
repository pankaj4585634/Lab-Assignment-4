package service;

import java.util.*;
import model.Student;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    public StudentManager(List<Student> loaded) {
        if (loaded != null) students.addAll(loaded);
    }

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student Added Successfully!");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            it.next().display();
        }
    }

    public void searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    public void deleteByName(String name) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Deleted Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted Student List by Marks:");
        viewAllStudents();
    }

    public List<Student> getStudents() {
        return students;
    }
}
