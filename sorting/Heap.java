import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Heap 
 * 算法2.7 堆排序
 * 给N个元素构造一个堆，然后逐渐删除堆顶节点。
 * 构造堆时可以从左往右逐一上浮每个结点，也可以从N/2开始从右往左下沉每一个节点，后者更高效
 * 
 */
public class Heap {
    public static void sort(Comparable[] a){
        /**排序算法 */
        int N = a.length-1;
     
        //调整堆
        for(int k = N/2; k>=1 ;k--){
            sink(a,k,N);
        }

        //排序
        while(N > 1){
            exch(a,1,N--);
            sink(a, 1, N);
        }
       
    }

    /** 
     * 堆排序下沉操作
     * 
    */
    private static void sink(Comparable[] a,int k,int N){

        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(a,j ,j+1)){
                j++;
            }
            if(!less(a,k,j)){
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    /**
     * 比较大小
     * @param v
     * @param w
     * @return 
     */
    private static boolean less(Comparable[] a,int v,int w){
        return a[v].compareTo(a[w])<0;
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
            if(less(a,i,i-1)){
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
