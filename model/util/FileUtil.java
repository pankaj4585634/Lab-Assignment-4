package util;

import java.io.*;
import java.util.*;
import model.Student;

public class FileUtil {

    public static List<Student> readStudents(String fileName) {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int roll = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                String course = parts[3];
                double marks = Double.parseDouble(parts[4]);

                list.add(new Student(roll, name, email, course, marks));
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }

    public static void writeStudents(String fileName, List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Student s : students) {
                bw.write(s.toFileFormat());
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void randomAccessDemo(String fileName) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            System.out.println("Random Access Demo (First Line):");
            System.out.println(raf.readLine());
        } catch (Exception e) {
            System.out.println("RandomAccess Error: " + e.getMessage());
        }
    }
}
