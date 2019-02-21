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
package interview.futurecar.other;


/**
 * @author flysLi
 * @ClassName Salary
 * @Decription TODO
 * @Date 2019/2/21 17:39
 * @Version 1.0
 */
public class Salary {
    private String name; //员工姓名
    private Integer baseSalary; //基础工资
    private Integer bonus; //奖金

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                '}';
    }
}
