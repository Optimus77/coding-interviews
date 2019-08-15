package Chap4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有全排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 通用的根据输入字符串得到全排列的程序，排序是为了保证字典序
 */
public class $38_1Permutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
           return list;
        }

        collect(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void collect(char[] chars, int begin, ArrayList<String> list) {
        if (begin == chars.length - 1) {
            // 不能存入相同的排列
            String s = String.valueOf(chars);
            if (!list.contains(s)) {
                list.add(s);
                return;
            }
        }

        for (int i = begin; i < chars.length; i++) {
            swap(chars, i, begin);
            collect(chars, begin + 1, list);
            swap(chars, i, begin);
        }

    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    public void  hybegin (String hy) {
        List<String> l   = new ArrayList<>();
        hy (hy.toCharArray(),0,l );
        System.out.println(l.toString());
    }


    public void  hy (char[] hy, int indexbegin , List resultList) {
        if (indexbegin== hy.length-1) {
            System.out.println(hy);
            resultList.add(Arrays.toString(hy));
        }

        for (int i=indexbegin;i<hy.length;i++) {
            int swapend = i;
            swaphy (hy,indexbegin,swapend);
            hy(hy,indexbegin+1,resultList);
            swaphy (hy,indexbegin,swapend);
        }


    }

    public void swaphy (char[] hychar, int swapbegin, int swapend){
        char temp = hychar[swapbegin];
        hychar[swapbegin] = hychar[swapend];
        hychar[swapend] = temp;
    }

    public static void main(String[] args) {
        $38_1Permutation a = new $38_1Permutation();
//        System.out.println(a.permutation("aab"));
        a.hybegin("abc");

    }






}
