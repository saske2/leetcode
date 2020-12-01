package cd.tij.demo.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName: cd.tij.demo.leetcode.twosum.class
 * @UserAndTime: saske2-2020/6/16-0:43
 * @Descript: xxxxx
 * @Reference: {@link}
 **/
public class Twosum {

    @Test
    public void towsum1(){
        int[] a = new int[9];
        int Target = 13;
        int indx1=0,indx2=0;
        for(int s=0;s<9;s++) a[s]=s;
        System.out.println("method1-------------------");
        HashMap<Integer,Integer> m = new HashMap();
        if(a==null) throw new RuntimeException("nullerror");
        for(int i=0;i<9;i++)
            m.put(a[i],i);
        for(int j=0;j<9;j++){
            if(m.containsKey(Target-a[j])&&m.get(Target-a[j])!=j){
                indx1 = j;
                indx2 = m.get(Target-a[j]);
            }
        }
        System.out.println("method1:"+indx1+"--"+indx2);
        System.out.println("method2-------------------");
        Target=15;
        HashMap<Integer,Integer> m2 = new HashMap();
        for(int k=0;k<9;k++){
            if(m2.containsKey(Target-a[k])){
                indx1 = k;
                indx2 = m.get(Target-a[k]);
            }
            m2.put(a[k],k);
        }
        System.out.println("method2:"+indx1+"--"+indx2);
        throw new IllegalArgumentException("No two sum solution");
    }
}
