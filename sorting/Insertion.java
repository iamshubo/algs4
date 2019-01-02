import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法 2.2 插入排序
 * 将序列分为两个有序和无序两个序列，初始化有序序列为空，每次找出无序序列第一个元素位置，将插入有序序列正确位置。
 * 时间复杂度：o(n²)
 * 空间复杂度：o(1)
 * 特点：较有序序列排序会比随机序列排序要快的多。   1
 */
public class Insertion {
    public static void sort(Comparable[] a){
        /**排序算法 */
        int N = a.length;
        for(int i = 1; i < N; i++){
            /**将无序序列第一个元素插入到正确的位置 */
            for(int j = i ; j > 0 ; j--){
                if(less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }else{
                    break;//将待插入元素插入到正确的位置后则结束内循环
                }
            }
        }
    }

    /**
     * 比较大小
     * @param v
     * @param w
     * @return 
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
        sort(a);
        assert isSorted(a);
        show(a);   
    }
}