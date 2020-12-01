package cd.tij.demo.leetcode;

import edu.princeton.cs.algs4.Merge;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: cd.tij.demo.leetcode
 * @UserAndTime: saske2-2020/12/1-23:07
 * @Descript: 归并两个有序的数组
 * @Reference: {@link Merge}
 **/
public class MergeTwoArrays {

    public int[] MergeTwoSeqArrays(int[] a, int[] b){
        if(a==null)
            return b;
        if(b==null)
            return a;
        int length = a.length+b.length;
        int[] aux = new int[length];
        int a_index = 0;
        int b_index = 0;
        int index = 0;
        while(a_index<a.length&&b_index<b.length){
            if(a[a_index]<b[b_index]){
                aux[index++]=a[a_index++];
            }else{
                aux[index++]=b[b_index++];
            }
            if(a_index>=a.length)
                aux[index++]=b[b_index++];
            if(b_index>b.length)
                aux[index++]=a[a_index++];
        }
        return aux;
    }

    @Test
    public void testmergetwoarrays(){
        int[] sa = {1,4,6,7,11,13};
        int[] sa1 = {3,5,6,9,11,20};
        Arrays.stream(MergeTwoSeqArrays(sa,sa1)).forEach(System.out::println);
    }

}
