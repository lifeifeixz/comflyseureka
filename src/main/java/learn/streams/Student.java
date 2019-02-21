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

/**
 * @author flysLi
 * @ClassName Student
 * @Decription TODO
 * @Date 2019/2/21 14:04
 * @Version 1.0
 */
public class Student {
    private String name;
    private String addr;
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public Student(String name, String addr, Double salary) {
        this.name = name;
        this.addr = addr;
        this.salary = salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Student(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", salary=" + salary +
                '}';
    }

    public boolean isFrom(String addr) {
        return this.addr.equals(addr) ? true : false;
    }
}
