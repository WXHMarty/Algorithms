
/**
 * 算法3.5
 * 基于拉链法的三列表
 */
public class SeparateChainingHAshST<key, Value> {

    // 健值对总数
    private int N;
    // 散列表的大小
    private int M;
    // 存放列表对象的数组
    private SeparateChainingHAshST<Key, Value>[] st;

    public SeparateChainingHAshST() { this(997); }

    /**
     * 创建M条链表
     */
    public SeparateChainingHAshST(int M) {
        this.M = M;
        st = (SeparateChainingHAshST<Key, Value>[]) new SeparateChainingHAshST[M];
        for (int i=0; i<M; i++) st[i] = new SeparateChainingHAshST(); 
    }

    private int hash(Key key) { return (key.hashCode() & 0x7fffffff) % M; }

    public Value get(Key key) { return (Value) st[hash(key)].get(key); }

    public void put(Key key, Value val) { st[hash(key)].put(key, val); }

    public Iterable<Key> keys() {
        
    }
}