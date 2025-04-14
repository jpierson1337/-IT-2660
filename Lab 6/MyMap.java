public interface MyMap<K, V> {
    public void clear();
    public boolean containsKey(K key);
    public V get(K key);
    public boolean isEmpty();
    public V put(K key, V value);
    public V remove(K key);
    public int size();
    public java.util.Set<K> keySet();
    public java.util.Set<V> values();
}
