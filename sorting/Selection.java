import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Selection
 * 算法2.1 选择排序
 * 将一个序列分为两个序列，左侧为有序序列，右侧为无序序列，内循环每次取出最小（大）的元素与无序循环第一个元素交换位置
 * 时间复杂度：o(n²)
 * 空间复杂度：o(1)
 * 特点：
 * 1.运行时间与输入是否有序无关，每一次扫描对后续再一次扫描没有任何帮助。
 * 2.数据移动最少。
 */
public class Selection {
    public static void sort(Comparable[] a){
        /**排序算法 */
        int N = a.length;
        for(int i = 0;i < N;i++){
            //将a[i]和a[i+1..N]中最小的元素交换
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])){
                    min = j;//记录最小元素的位置
                }
            }
            exch(a, i, min);//找到最小元素后，交换当前无序序列第一个元素位置与最小元素位置。
        }
    }

    /**
     * 比较大小
     * @param v
     * @param w
     * @return  true：v<w
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    /**
     * 交换元素位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t =a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private static void show(Comparable [] a){
        //在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] +" ");
        }
        StdOut.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {
        //从标准输入读取字符串，将他们排序输出
        String[] a = In.readStrings(args[0]);
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);   
    }
}