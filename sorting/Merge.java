import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/**
 * Merge
 * 算法2.4 自顶向下的归并排序的递归实现
 * 利用分治思想的典型排序算法
 * 时间复杂度：o(nlogn)
 * 空间复杂度：o(n)
 * 特点：
 */
public class Merge {
    private static Comparable[] aux;//归并所需要的辅助数组

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    /**
     * 自定向下归并排序的递归实现
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a,int lo,int hi){
        // 将数组a[lo..hi]排序
        if(hi <= lo) return;
        int mid = lo + (hi -lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    /**原地归并 */
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo;
        int j = mid+1;
        for(int k = lo;k<=hi;k++){
            aux[k] = a[k];
        }
        for(int k = lo;k <= hi;k++){
            if(i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
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
        String[] a = new In(args[0]).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);   
    }    
}