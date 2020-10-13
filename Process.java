/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buoi3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author T460
 */
public class Process {
    final static String specialCharacters = ".,<>?';:`~!@#$%^&*()_-+|/[]— \" \n";// Những kí tự đặc biệt cần loại
    // kiểm tra kí tự thừa trong file
    public static String standarString(String s) {
        // Kiểm tra đến khi nào không có kí tự thừa ở 2 đầu
        while (specialCharacters.contains(Character.toString(s.charAt(0))) || specialCharacters.contains(Character.toString(s.charAt(s.length() - 1)))) {
            // Nếu đầu chuỗi chứa kí tự đặc biệt thì xóa đi
            if (specialCharacters.contains(Character.toString(s.charAt(0)))) {
                s = remove(s, 0);
            }
            if (s.equals("")) {
                return s;
            }
            // Nếu cuối chuỗi chứa kí tự đặc biệt thì xóa đi
            if (specialCharacters.contains(Character.toString(s.charAt(s.length() - 1)))) {
                s = remove(s, s.length() - 1);
            }
            if (s.equals("")) {
                return s;
            }
        }
        // Chuyển hết về chữ thường.
        return s.toLowerCase();
    }

    // xóa kí tự đầu và cuối trong file
    public static String remove(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    // kiểm tra chuổi có hợp lệ không
    public static boolean checkStringValid(String s) {
        if (specialCharacters.contains(s) == false && s.equals("") == false) {
            return true;
        }
        return false;
    }

    // đọc ghi data trong file
    public static void preProcess() {
        HashMap<String, Long> dataList = new HashMap<String, Long>();

        try {
            // đọc file
            FileReader file = new FileReader("D:\\2020\\TopRate\\Buoi2\\input.txt");
            BufferedReader readFile = new BufferedReader(file);
            // ghi file
            FileWriter fileOut = new FileWriter("D:\\2020\\TopRate\\Buoi2\\output.txt");
            BufferedWriter writeOutput = new BufferedWriter(fileOut);

            String i;
            while ((i = readFile.readLine()) != null) {
                System.out.println(i);
                // Nếu chuỗi không rỗng và không phải kí tự đặc biệt
                if (checkStringValid(i)) {

                    // Tách thành từng mảng string con.
                    String[] words = i.split(" ");

                    // Đẩy từng từ vào hasmap
                    for (int j = 0; j < words.length; j++) {
                        if (checkStringValid(words[j].trim())) {
                            // Chuẩn hóa từ
                            words[j] = words[j].trim();
                            String temp = standarString(words[j].trim());
                            if (temp.equals("") == false && specialCharacters.equals(temp) == false && temp.equals(" ") == false && temp != null) {
                                // Nếu chưa có thì thêm vào
                                if (dataList.get(temp) == null) {
                                    dataList.put(temp, (long) 1);
                                } else {// Nếu có rồi thì cộng thêm số lượng
                                    dataList.put(temp, dataList.get(temp) + 1);
                                }
                            }
                        }
                    }
                }
            }
            readFile.close();
            file.close();
            // in ra gia tri và key của file
            for (Map.Entry<String, Long> entry : dataList.entrySet()) {
                fileOut.write(entry.getKey() + " " + entry.getValue() + "\n");
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            writeOutput.close();
            fileOut.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
