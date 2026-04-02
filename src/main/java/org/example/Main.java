package org.example;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> list2 = Arrays.asList(5,6);
        int i = list2.size();
        for (int o:list1){
            for (int j:list2){
                if (o == j){
                    i --;
                }
            }
        }
        if (i ==0) System.out.println("Ok");
    }
}