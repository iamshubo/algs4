/**
 * 算法2.6 基于堆的优先队列
 * MaxPQ
 * 二叉堆是一个完全二叉树，可使用数组结构存储
 * 大顶堆满足父节点不小于子节点，小顶堆满足父节点不大于子节点
 */
public class MaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;//基于堆的完全二叉树
    private int N = 0;//存储于pq[1...N]中。pq[0]没有使用

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];//从根节点得到最大元素
        exch(1,N--);//将跟节点与最后一个节点交换
        pq[N+1] = null;//防止对象游离
        sink(1);
        return max;
    }

    //辅助函数

    /**
     * 将节点k上浮
     * @param k
     */
    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }

    }

    /**
     * 将节点k下沉
     * @param k
     */
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k; //将j切换到k的左子节点
            if(j < N && less(j, j+1)){//将j切换到子节点中较大的一个
                j++;
            }
            if(!less(k,j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * 比较大小
     * @param v
     * @param w
     * @return 
     */
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    /**
     * 交换元素位置
     * @param a
     * @param i
     * @param j
     */
    private void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    
    
}