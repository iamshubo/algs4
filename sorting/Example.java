import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Example
 * p153 排序类的模板类，为了保证每一个java文件独立运行，并没有将本类抽象为抽象类被其他类继承
 */
public class Example {
    public static void sort(Comparable[] a){
        /**排序算法 */
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