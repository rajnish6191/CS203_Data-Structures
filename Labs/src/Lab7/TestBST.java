package Lab7;
public class TestBST {
 public static void main(String[] args) {

 BST<String> tree = new BST<>();
 tree.insert("George");
 tree.insert("Michael");
 tree.insert("Tom");
 tree.insert("Adam");
 tree.insert("Jones");
 tree.insert("Peter");
 tree.insert("Daniel");

 System.out.println("Breadth First Traversal is: " );
 tree.breadthFirstTraversal();
 
 tree.height();
 System.out.println("Height is: "+tree.height());

 System.out.println("\n");
 
Integer[] numbers = {2, 5, 1, 9, 7, 11, 14, 17};
BST<Integer> intTree = new BST<>(numbers);
System.out.println("Breadth First Traversal is: " );
 
intTree.breadthFirstTraversal();
 
intTree.height();
System.out.println("Height is: "+intTree.height());
 
 }
 }