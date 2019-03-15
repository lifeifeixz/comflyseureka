package interview.futurecar.q2;


import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

@SuppressWarnings("All")
public class SalaryApp {
    private static final int count = 10000000;
    private List<Salary> salaries;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String path = "D:\\salary.txt";
        SalaryApp app = new SalaryApp();

        /*写文件*/
        app.writer(path);

        /*读文件*/
        String txt = app.read(path);

        /*转换成Salary集合*/
        Salary[] salaries = app.concurrentConvertToSalarys(txt);

        /*分组(根据名称的前两个字母)*/
        Map<String, List<Salary>> listMap = app.groupByPetName(salaries);

        /*累加每组的年薪、人数*/
        List<TempSalary> tempSalaries = app.sumOfGroup(listMap);

        /*排序*/
        app.sort(tempSalaries);

        /*输出前十*/
        for (int i = 0; i < 10; i++) {
            TempSalary tempSalary = tempSalaries.get(i);
            System.out.println(tempSalary.getPetName()
                    + "," + tempSalary.getYearSalary()
                    + "万," + tempSalary.getNumber() + "人");
        }
        long end = System.currentTimeMillis();
        System.out.println("共计耗时:" + (end - start) / 1000 + "秒");
    }

    /**
     * 写出数据
     *
     * @param path 文件地址
     */
    public void writer(String path) {
        FileWriter out = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileWriter(file, true);
            StringBuffer str = new StringBuffer(10);
            for (int i = 0; i < count; i++) {
                str.append(randomName());
                str.append(",");
                str.append(new Random().nextInt(100));
                str.append(",");
                str.append(new Random().nextInt(5));
                str.append("\n");
            }
            out.write(str.toString());
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
     * 读取文本
     *
     * @param path
     * @return
     */
    public String read(String path) {
        String txt = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            txt = new String(data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    /**
     * 将数据转换成对象
     *
     * @param row 一行数据
     * @return
     */
    public Salary convertToSalary(String row) {
        if (row != null && row.trim().length() > 0) {
            Salary salary = new Salary();
            StringTokenizer tokenizer = new StringTokenizer(row, ",");
            int i = 0;
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (i == 0) {
                    salary.setName(token);
                } else if (i == 1) {
                    salary.setBaseSalary(Integer.valueOf(token));
                } else {
                    salary.setBonus(Integer.valueOf(token));
                }
                i++;
            }
            return salary;
        }
        return null;
    }

    /**
     * 读取文本获取对象列表
     *
     * @param path
     * @return
     */
    public Salary[] convertToSalarys(String txt) {
        //读取
        String[] rows = txt.split("\n");
        Salary[] salaries = new Salary[rows.length];
        for (int i = 0; i < rows.length; i++) {
            salaries[i] = convertToSalary(rows[i]);
        }
        return salaries;
    }

    /**
     * 并发获取列表
     *
     * @param path
     * @return
     */
    public Salary[] concurrentConvertToSalarys(String txt) {
        String[] rows = txt.split("\n");
        Salary[] salaries = new Salary[rows.length];
        int threadNumber = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        int j = 0;
        for (; j < threadNumber; j++) {
            int finalJ = j;
            new Thread(() -> {
                int s = 0;
                for (int i = 0; i < (rows.length / threadNumber); i++) {
                    int index = i + (finalJ * (rows.length / threadNumber));
                    salaries[index] = convertToSalary(rows[index]);
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return salaries;
    }

    /**
     * 随机生成姓名
     *
     * @return
     */
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
            if (salary != null) {
                String petName = salary.getName().substring(0, 2);
                if (petNameMap.containsKey(petName)) {
                    petNameMap.get(petName).add(salary);
                } else {
                    ArrayList<Salary> var1 = new ArrayList<>();
                    var1.add(salary);
                    petNameMap.put(petName, var1);
                }
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
            Integer yearSalarySum = cumulativeTempSalary(salaries);
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
    public Integer cumulativeTempSalary(List<Salary> salaryList) {
        Integer yearSalary = 0;
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
    private Integer yearSalary;
    private int number;

    public TempSalary(String petName, Integer yearSalary, int number) {
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

    public Integer getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(Integer yearSalary) {
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
    private Integer baseSalary;
    private Integer bonus;

    public Salary() {
    }

    public Salary(String name, Integer baseSalary, Integer bonus) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

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
}