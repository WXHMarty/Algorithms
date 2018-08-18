package algorithm;
/**
 * 算法3.4
 * 红黑树的插入算法
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    /**
     * 是不是红树
     */
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }

    /**
     * 左旋转h的右链接
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转h的左链接
     */
    private NOde rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 通过旋转链接的结点来分解4-结点
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left = BLACK;
        h.right = BLACK;
    }

    /**
     * 返回结点的数量
     */
    private int size() { return size(root); }
    private int size(Node x) { return x==null ? 0 : x.N; }

    /**
     * 查找key，找到则更新其值，否则为它创建一个新结点
     */
    private void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    /**
     * 标准插入操作，和父节点用红链接相连
     */
    private Node put(Node h, Key key, Value val) {
        if(h == null) return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);
        
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    
    private class Node {
        // 键
        Key key;
        // 值
        Value val;
        // 左右子树
        NOde left, right;
        // 这棵树中的节点总数
        int N;
        // 由父结点指向它的链接的颜色
        boolean color;

        Node (Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }
}