package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main{
    ArrayList nums=new ArrayList<Integer>();
    int ugly(int n){
        if(n==1){
            return 1;
        }
        int index=1;
        int i=2;
        for( ;index<n&&n<30;i++) {
            Set list = new HashSet<Integer>();
            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    list.add(j);
                }
            }
            if (list.contains(2) || list.contains(5) || list.contains(3)) {
                if (list.contains(2))
                    list.remove(2);
                if (list.contains(3))
                    list.remove(3);
                if (list.contains(5))
                    list.remove(5);
                if (list.isEmpty()) {
                    index++;
                    nums.add(i);
                    list.clear();
                }
            }
        }
        return i;
    }
    public static void main(String[] args){
        Main main =new Main();
        int resoult=main.ugly(6);
        System.out.println(resoult);
    }
}