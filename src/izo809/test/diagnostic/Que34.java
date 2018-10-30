package izo809.test.diagnostic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Que34 {

    public static void main(String... args) {
        List<Student> students = Arrays.asList(
                new Student("A", "Business", "F"),
                new Student("B", "Engineering", "F"),
                new Student("C", "Business", "M"),
                new Student("D", "Engineering", "M")
        );

        System.out.println(
                students.stream()
                        .collect(Collectors.groupingBy(Student::getGender, Collectors.groupingBy(Student::getFaculty)))
        );
    }

    static class Student {
        private String name;
        private String faculty;
        private String gender;

        Student(String name, String faculty, String gender) {

            this.name = name;
            this.faculty = faculty;
            this.gender = gender;
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

        public String getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
