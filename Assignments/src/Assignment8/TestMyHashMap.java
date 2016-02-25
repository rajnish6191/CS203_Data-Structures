package Assignment8;

public class TestMyHashMap {
  public static void main(String[] args) {
	  MyHashMap<Integer, Integer> map = new MyHashMap<>();
	    map.put(1, 10);
	    map.put(2, 256);
	    map.put(3, 62);
	    map.put(4, 211);
	    map.put(5, 98);
	    map.put(6, 98);
	    map.put(6, 102);
	    System.out.println("Entries in map: " + map);
	    System.out.println("Number of elements in set: " + map.size());
	    System.out.println("Is key 2 in the map? " + map.containsKey(2));
	    map.remove(2);
	    System.out.println("Is key 2 in the map? " + map.containsKey(2));
	    System.out.println("Is key 3 in the map? " + map.containsKey(3));
	    System.out.println("key 3 in the map HAVE VALUE 60? " + map.containsValue(60));
	    System.out.println("Entries in map: " + map);
	    System.out.println("Number of elements in set: " + map.size());
  }
}