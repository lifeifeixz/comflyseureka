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
package interview.futurecar.q2;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;

/**
 * @author flysLi
 * @ClassName SalaryApp
 * @Decription TODO
 * @Date 2019/2/20 16:48
 * @Version 1.0
 */
public class SalaryApp {
    private static final int count = 10000000;

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        String path = "D:\\salary.txt";
        SalaryApp app = new SalaryApp();
        //写出文件
        app.writerData(path);
        //读取
        Salary[] salaries = app.convertToSalarys(path);
        Map<String, List<Salary>> listMap = app.groupByPetName(salaries);
        List<TempSalary> tempSalaries = app.sumOfGroup(listMap);
        app.sort(tempSalaries);
        for (int i = 0; i < 10; i++) {
            System.out.println(tempSalaries.get(i).toString());
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000);
    }

    /**
     * 写出数据
     *
     * @param path 文件地址
     */
    public void writerData(String path) {
        long s = System.currentTimeMillis();
        FileWriter out = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileWriter(file, true);
            for (int i = 0; i < count; i++) {
                StringBuffer str = new StringBuffer();
                str.append(randomName());
                str.append(",");
                str.append(new Random().nextInt(100));
                str.append(",");
                str.append(new Random().nextInt(5));
                str.append("\n");
                out.write(str.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long e = System.currentTimeMillis();
        System.out.println("写出文件耗时:" + (e - s) / 1000);
    }

    /**
     * 排序
     *
     * @param tempSalaries
     * @return
     */
    public List<TempSalary> sort(List<TempSalary> tempSalaries) {
        Collections.sort(tempSalaries, (o1, o2) -> o2.getYearSalary().compareTo(o1.getYearSalary()));
        return tempSalaries;
    }

    /**
     * 将数据转换成对象
     *
     * @param row 一行数据
     * @return
     */
    public Salary convertToSalary(String row) {
        if (row != null) {
            String[] arr = row.split(",");
            String name = arr[0];
            //由于名字都控制到了4位以上，所以不用担心下标越界的问题
            String petName = name.substring(0, 2);
            return new Salary(name, petName, Double.valueOf(arr[1]), Double.valueOf(arr[2]));
        }
        return null;
    }

    /**
     * 将文本转换成集合
     *
     * @param text
     * @return
     */
    public List<Salary> convertToSalarysForTxt(String text) {
        return null;
    }

    public String readTxt(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            return new String(data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取文本获取对象列表
     *
     * @param path
     * @return
     */
    public Salary[] convertToSalarys(String path) {
        //读取
        String txt = readTxt(path);
        String[] rows = txt.split("\n");
        long listS = System.currentTimeMillis();
        Salary[] salaries = new Salary[rows.length];
        for (int i = 0; i < rows.length; i++) {
            salaries[i] = convertToSalary(rows[i]);
        }
        long ListE = System.currentTimeMillis();
        System.out.println("集合迭代时间:" + (ListE - listS) / 1000);
        return salaries;
    }


    /**
     * 声明name
     *
     * @return
     */
    public static String generateName() {
        String[] strs = new String[]{
                "a", "b", "c", "d",
                "e", "f", "g", "h",
                "i", "n", "j", "k",
                "l", "m", "n", "o",
                "p", "q", "r", "s",
                "t", "u", "v", "w",
                "x", "y", "z",
        };
        int random1 = new Random().nextInt(25) + 1;
        int random2 = new Random().nextInt(25) + 1;
        int random3 = new Random().nextInt(25) + 1;
        int random4 = new Random().nextInt(25) + 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strs[random1]);
        stringBuffer.append(strs[random2]);
        stringBuffer.append(strs[random3]);
        stringBuffer.append(strs[random4]);
        return stringBuffer.toString();
    }

    public String randomName() {
        StringBuilder name = new StringBuilder(4);
        String chars = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 4; i++) {
            name.append(chars.charAt((int) (Math.random() * 26)));
        }
        return name.toString();
    }

    /**
     * 按照姓名的前两位分组
     *
     * @param salaries
     * @return
     */
    public Map<String, List<Salary>> groupByPetName(Salary[] salaries) {
        Map<String, List<Salary>> petNameMap = new HashMap<>(10000);
        for (Salary salary : salaries) {
            String petName = salary.getPetName();
            if (petNameMap.containsKey(petName)) {
                petNameMap.get(petName).add(salary);
            } else {
                ArrayList<Salary> var1 = new ArrayList<>();
                var1.add(salary);
                petNameMap.put(petName, var1);
            }
        }
        return petNameMap;
    }

    /**
     * 统计各组数据，并排行
     *
     * @return
     */
    public List<TempSalary> sumOfGroup(Map<String, List<Salary>> stringListMap) {
        Set<String> keys = stringListMap.keySet();
        List<TempSalary> tempSalaries = new ArrayList<>(10000);
        for (String key : keys) {
            List<Salary> salaries = stringListMap.get(key);
            double yearSalarySum = cumulativeTempSalary(salaries);
            tempSalaries.add(new TempSalary(key, yearSalarySum, salaries.size()));
        }
        return tempSalaries;
    }

    /**
     * 累加小组薪水
     *
     * @param salaryList
     * @return
     */
    public double cumulativeTempSalary(List<Salary> salaryList) {
        double yearSalary = 0;
        for (Salary salary : salaryList) {
            yearSalary += (salary.getBaseSalary() * 13 + salary.getBonus());

        }
        return yearSalary;
    }
}

/**
 * 小组年薪
 */
class TempSalary {
    private String petName;
    private Double yearSalary;
    private int number;

    public TempSalary(String petName, Double yearSalary, int number) {
        this.petName = petName;
        this.yearSalary = yearSalary;
        this.number = number;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Double getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(Double yearSalary) {
        this.yearSalary = yearSalary;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TempSalary{" +
                "petName='" + petName + '\'' +
                ", yearSalary=" + yearSalary +
                ", number=" + number +
                '}';
    }
}

/**
 * 实体类
 */
class Salary {
    private String name;

    /**
     * 名字前两位
     **/
    private String petName;
    private double baseSalary;
    private double bonus;

    public Salary() {
    }

    public Salary(String name, double baseSalary, double bonus) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public Salary(String name, String petName, double baseSalary, double bonus) {
        this.name = name;
        this.petName = petName;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}


