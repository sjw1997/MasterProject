import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> {

    private int[] pq;
    private int[] qp;                   // pq[qp[i]] = qp[pq[i]] = i
    private Key[] keys;
    private int n;
    private int maxN;

    public IndexMinPQ(int maxN) {
        if (maxN < 0 ) {
            throw new IllegalArgumentException();
        }
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        keys = (Key[]) new Comparable[maxN + 1];
        n = 0;
        this.maxN = maxN;
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public boolean contains(int k) {
        validate(k);
        return qp[k] != -1;
    }

    public void insert(int k, Key key) {
        validate(k);
        if (contains(k)) {
            throw new IllegalArgumentException("index is already in thr priority queue");
        }
        if (key == null) {
            throw new NullPointerException("call insert() with null");
        }
        n++;
        pq[n] = k;
        qp[k] = n;
        keys[k] = key;
        swim(n);
    }

    public void changeKey(int k, Key key) {
        validate(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        if (key == null) {
            throw new NullPointerException("calls changeKey() with null");
        }
        int index = qp[k];
        keys[k] = key;
        swim(index);
        sink(index);
    }

    public int delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls delMin() with empty priority queue");
        }
        int min = pq[1];
        swap(1, n--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j =  2 * k;
            if (j < n && less(j + 1, j)) {
                j++;
            }
            if (less(j, k)) {
                swap(j, k);
                k = j;
            } else {
                break;
            }
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void validate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index is negative" + i);
        }
        if (i >= maxN) {
            throw new IllegalArgumentException("index >= capacity" + i);
        }
    }
}
