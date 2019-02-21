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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author flysLi
 * @ClassName SalaryTest
 * @Decription TODO
 * @Date 2019/2/21 17:38
 * @Version 1.0
 */
public class SalaryTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/upload/test.txt");
        FileWriter out = new FileWriter(file, true);
        Integer count = 10000000;
        while (true){
            StringBuilder name = new StringBuilder(4);
            String chars = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0 ; i < 4; i++){
                name.append(chars.charAt((int) (Math.random() * 26))) ;
            }
            Salary salary = new Salary();
            salary.setName(name.toString());
            salary.setBaseSalary((int) (Math.random() * 100 + 1));
            salary.setBonus((int) (Math.random() * 5 + 1));
            count --;
//            out.write(JSON.toJSONString(salary));
            out.write("\n");
            if (count ==0){
                out.close();
                return;
            }

        }
    }
}
