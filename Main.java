/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buoi3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        long start = System.currentTimeMillis();
        Process pro = new Process();   
        pro.preProcess();
        long end = System.currentTimeMillis();
        long t = end - start;
        System.out.println("Tổng thời gian: " + t + " millisecond");
    }  
}
