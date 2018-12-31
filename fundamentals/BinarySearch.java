/**
 * BInarySearch
 * 1.1.10 
 * % java BinaeySearch tinyW.txt < tinyT.txt
 */

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class BinarySearch {
    public static int rank(int key,int []a){
        //数据必须保证有序
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            // 被查找的键存在与a[lo..hi]之中。
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]){
                hi = mid - 1;
            }else if(a[mid] < key){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            //读取键值，如果不存在与白名单则打印 
            int key = StdIn.readInt();
            if(rank(key,whitelist) < 0){
                StdOut.println(key);
            }
        }
    }
    
}