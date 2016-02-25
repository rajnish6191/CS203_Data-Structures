package Assignment8;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    private static int MAXIMUM_CAPACITY = 1 << 30; 
    private int capacity;
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.4f; 
    private float loadFactorThreshold; 
    private int size = 0; 
    MyMap.Entry<K,V>[] table;

    public MyHashMap() {  
      this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);    
    }
    
    public MyHashMap(int initialCapacity) { 
      this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);    
    }
    
    public MyHashMap(int initialCapacity, float loadFactorThreshold) { 
    	if (initialCapacity > MAXIMUM_CAPACITY)
    	      this.capacity = MAXIMUM_CAPACITY;
    	    else
    	      this.capacity = trimToPowerOf2(initialCapacity);
    	    
    	    this.loadFactorThreshold = loadFactorThreshold; 
      table = new MyMap.Entry[capacity];
    }
    
    public void clear() {
      size = 0;
      removeEntries();
    }
    
    public boolean containsKey(K key) {
      if (get(key) != null)
        return true;
      else
        return false;
    }
    
    public boolean containsValue(V value) {
      for (int i = 0; i < table.length; i++)
        if (table[i] != null && table[i].equals(value)) 
          return true;      
      return false;
    }
    
    public java.util.Set<MyMap.Entry<K,V>> entrySet() {
      java.util.Set<MyMap.Entry<K, V>> set = 
        new java.util.HashSet<MyMap.Entry<K, V>>();      
      for (int i = 0; i < capacity; i++) 
        if (table[i] != null) 
          set.add(table[i]); 
      return set;
    }
    
    public V get(K key) {
      int k = hash(key.hashCode());
      int i = k;
      int j = 0;
      while (table[i] != null) {
        if (table[i].key != null && table[i].key.equals(key)) 
          return table[i].value;
        i = Math.abs((k + j) % table.length);
        j++;
      }
      return null;
    }
    
    public java.util.Set<V> getAll(K key) {
      java.util.Set<V> set = new java.util.HashSet<V>(); 
      for (int i = 0; i < capacity; i++) 
        if (table[i] != null && table[i].key.equals(key)) 
          set.add(table[i].value); 
      return set;
    }
    
    public boolean isEmpty() {
      return size == 0;
    }  
    
    public java.util.Set<K> keySet() {
      java.util.Set<K> set = new java.util.HashSet<K>();      
      for (int i = 0; i < capacity; i++) 
        if (table[i] != null) 
          set.add(table[i].key); 
      return set;
    }
    
    public V put(K key, V value) {
      if (size >= capacity * loadFactorThreshold) {
        if (capacity == MAXIMUM_CAPACITY)
          throw new RuntimeException("Exceeding maximum capacity");        
        rehash();
      }
      
      int k = hash(key.hashCode());      
      int j = 0;
      int i = k;
      while (table[i] != null && table[i].key != null) {
        i = Math.abs((k + j) % table.length);
        j++;
      }
      
      table[i] = new MyMap.Entry<K, V>(key, value);
      size++;       
      return value;  
    } 
    
    public void remove(K key) {
      int k = hash(key.hashCode());
      int j = 0;
      int i = k;
      while (table[i] != null && (table[i].key == null || !table[i].key.equals(key))) {
        i = Math.abs((k + j) % table.length);
        j++;
      }

      if (table[i] != null && table[i].key.equals(key)) {
        table[i] = new MyMap.Entry<K, V>(null, null);
        size--;
      }
    }
   
    public int size() {
      return size;
    }
   
    public java.util.Set<V> values() {
      java.util.Set<V> set = new java.util.HashSet<V>();
      
      for (int i = 0; i < capacity; i++) 
        if (table[i] != null) 
          set.add(table[i].value); 
      
      return set;
    }
    
    private int hash(int hashCode) {
      return hashCode % capacity;
    }
    
    private static int supplementalHash(int h) {
      h ^= (h >>> 20) ^ (h >>> 12);
      return h ^ (h >>> 7) ^ (h >>> 4);
    }
    
    private int trimToPowerOf2(int initialCapacity) {
      int capacity = 1;
      while (capacity < initialCapacity) {
        capacity <<= 1;
      }  
      return capacity;
    }
    
    private void removeEntries() {
      for (int i = 0; i < capacity; i++) 
        table[i] = null;
    }
    
    private void rehash() {
      java.util.Set<Entry<K, V>> set = entrySet(); 
      capacity <<= 1; 
      table = new Entry[capacity]; 
      
      size = 0; 
      
      for (Entry<K, V> entry: set) {
        put(entry.getKey(), entry.getValue()); 
      }
    }

    @Override 
    public String toString() {
      StringBuilder builder = new StringBuilder("[");
      
      for (int i = 0; i < capacity; i++) {
        if (table[i] != null && table[i].key != null) 
          builder.append(table[i].toString());
      }  
      return builder.append("]").toString();
    }
}