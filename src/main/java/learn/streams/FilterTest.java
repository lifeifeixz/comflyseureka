/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package learn.streams;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author flysLi
 * @ClassName FilterTest
 * @Decription TODO
 * @Date 2019/2/21 14:05
 * @Version 1.0
 */
public class FilterTest {
    public static void main(String[] args) {
        List<Student> students = initData();
        Double sum = students.stream().filter(student -> student.isFrom("陕西")).mapToDouble(Student::getSalary).sum();
        System.out.println(sum);
    }

    public static List<Student> isFromShannxi(List<Student> students) {
        Objects.requireNonNull(students, "Cannot find students");
        List<Student> shannxiStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isFrom("陕西")) {
                shannxiStudents.add(student);
            }
        }
        return shannxiStudents;
    }


    public static List<Student> initData() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student = new Student("李" + i, "北京", Double.valueOf(i));
            if (i % 6 == 0) {
                student.setAddr("陕西");
            }
            students.add(student);
        }
        return students;
    }
}
