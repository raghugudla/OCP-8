package izo809.test.diagnostic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Que2 {

    public static void main(String... args) {
        List<Student> students = Arrays.asList(
                new Student("A", "Business", 7.0),
                new Student("B", "Business", 9.0),
                new Student("C", "Engineering", 8.0),
                new Student("D", "Engineering", 8.0)
        );

        ToDoubleFunction<Student> markFunc = Student::getMark;

        Map<String, List<Student>> stringListMap = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty));

        stringListMap
                .forEach(
                        (a, b) -> System.out.println(a + "-" + b.stream().collect(Collectors.averagingDouble(markFunc)))
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
    }
}
