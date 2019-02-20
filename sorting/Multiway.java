import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Multiway
 */
public class Multiway {
    public static void merge(In[] streams){
        int N = streams.length;
        //初始化一个空的优先队列
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);

        //插入所有带归并序列的地一个元素（即最小元素）
        for(int i = 0; i < N; i++){
            if(!streams[i].isEmpty()){
                pq.insert(i, streams[i].readString());
            }
        }

        while(!pq.isEmpty()){
            StdOut.println(pq.minKey());
            //索引即为sterams下标，代表某节点来自哪个待归并序列
            int i = pq.delMin();
            if(!streams[i].isEmpty()){
                pq.insert(i, streams[i].readString());
            }
        }
    }
    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for(int i = 0; i < N; i++){
            streams[i] = new In(args[i]);
        }    
        merge(streams);
    }
}