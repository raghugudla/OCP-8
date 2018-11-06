package izo809.whizlabs.diagnostic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Que9 {

    public static void main(String... args) {
        List<Student> students = Arrays.asList(
                new Student("A", "Business", 7.0),
                new Student("B", "Business", 9.0),
                new Student("C", "Engineering", 8.0),
                new Student("D", "Engineering", 8.0)
        );

        students.stream()
                .collect(Collectors.partitioningBy(student -> student.getFaculty().equals("Business")))
                .forEach(
                        (a, b) -> System.out.println(a + "-" + b)
                );
    }

    static class Student {
        private String name;
        private String faculty;
        private double mark;

        Student(String name, String faculty, double mark) {

            this.name = name;
            this.faculty = faculty;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public double getMark() {
            return mark;
        }

        public void setMark(double mark) {
            this.mark = mark;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
