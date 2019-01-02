import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法2.3 希尔排序
 * 基于插入排序的一种排序优化算法，又成为缩小增量排序，是一种分组排序算法。
 * 优化了插入排序中，利用将元素插入到正确的位置需要逐步交换较为耗时的特点
 * 将间隔为h的元素分为一组，如h=4时，0,4，8...为一组，组内使用插入排序使组内有序。
 * 不断缩小步长直至步长为1使希尔排序退化为插入排序。
 * 在本段代码中，步长h取3^k+1，k=0,1,2...（逆序，因为步长是逐渐缩小的）
 * 时间复杂度：o(n^(1.3-2))
 * 空间复杂度：o(1)
 * 特点：在比较有序的序列中性能不如插入排序，在随机性较强的序列中性能强于插入排序。
 * 
 */
public class Shell {
    public static void sort(Comparable[] a){
        /**排序算法 */
        int N = a.length;
        int h = 1;//设置h为1
        while(h < N/3){
            h = 3*h + 1; // 选取h为等于(3^k-1)/2且小于N/3的最大的数字
        }
        while(h>=1){
            for(int i = h;i < N; i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for(int j = i; j >= h && less(a[j], a[j-h]);j-=h){//每次移动h个位置
                    exch(a, j, j - h);
                }
            }
            h = h/3;
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