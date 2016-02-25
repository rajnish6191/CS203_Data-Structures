package Assignment7;

public class TestNonrecursive {
	public static void main(String args[])
	{	
		NonRecursiveTraversal<Integer> intTree = new NonRecursiveTraversal<>();
		intTree.insert(2);
		intTree.insert(4);
		intTree.insert(3);
		intTree.insert(1);
		intTree.insert(8);
		intTree.insert(5);
		intTree.insert(6);
		intTree.insert(7);
	
		System.out.println("Inorder output of Tree is:");
		intTree.inOrder();
		System.out.println();
		
		System.out.println("Preorder output of Tree is:");
		intTree.preOrder();
		System.out.println();
		
		System.out.println("Postorder output of Tree is:");
		intTree.postOrder();
		System.out.println();	}
}