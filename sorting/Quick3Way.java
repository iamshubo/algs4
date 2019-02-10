import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/**
 * Quick
 * 算法2.5 三向切分快速排序
 * 快速排序的优化算法
 * 特点：除非和切分元素相等，其他元素都会被交换，
 * 对于存在大量重复元素的序列有更高的效率。
 */
public class Quick3Way {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int lt = lo; //左游标
        int i = lo + 1; //哨兵游标
        int gt = hi;//有游标
        Comparable v = a[lo];//哨兵
        while (i <= gt) {//i从lo+1递增至gt，循环退出
            int cmp = a[i].compareTo(v);//less函数无法判断相等的情况
            if(cmp < 0){
                exch(a, lt++, i++); //a[lt+1..i]为重复元素
            }else if(cmp > 0){
                exch(a,i,gt--);
            }else{
                i++;
            }
        }//循环结束后a[lo..lt-1] < v =a[lt..gt] < a[gt+1..hi]
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static int partition(Comparable[] a,int lo,int hi){
        //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int i = lo;//左扫描指针
        int j = hi + 1;//右扫描指针
        Comparable v = a[lo]; // 待排序序列的第一个元素为哨兵
        while (true) {
            while (less(a[++i],v)) {//先移动左指针位置再比较
                if(i == hi){
                    break;//结束内层循环
                }
            }
            //上面循环结束后左侧元素不大于哨兵
            while (less(v,a[--j])) {//先移动右指针元素再比较
                if(j == lo){
                    break;//结束内层循环
                }     
            }
             //上面循环结束后右侧元素大于哨兵
            if(i >= j){
                break;//结束外层循环
            }
            //上面两个循环结束后，若仍未找到正确的位置,左指停在不小于哨兵的位置，右指针停在不大于哨兵的位置，需要交换左右指针所指向的元素
            exch(a, i, j);
        }
        exch(a, lo, j); //将v = a[j] 放入正确的位置
        return j; //a[j] 左边小于a[j],a[j]右边大于a[j]
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