package Assignment7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NonRecursiveTraversal<E extends Comparable<E>> 
{
	protected TreeNode<E> root;
	protected int size = 0;
	public NonRecursiveTraversal()
	{
	  
	}
  
	public NonRecursiveTraversal(E[] objects) 
	{
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}
  
	public boolean insert(E e) 
	{
		if (root == null)
			root = createNewNode(e);
		else 
		{
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null)
				if (e.compareTo(current.element) < 0) 
				{
					parent = current;
					current = current.left;
				}
				else if (e.compareTo(current.element) > 0) 
				{
					parent = current;
					current = current.right;
				}
				else
					return false; 
      
			if (e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}
	size++;
    return true;
  }
   
  protected TreeNode<E> createNewNode(E e) 
  {
    return new TreeNode<E>(e);
  }

  public void inOrder() 
  {
      if (root == null)
    	  return;

      final Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode node = root;

      while (!stack.isEmpty() || node != null) 
      {
          if (node != null) 
          {
              stack.add(node);
              node = node.left;
          } 
          else 
          {
             node = stack.pop();
             System.out.print(node.element + " "); 
             node = node.right; 
          }
      }
  }
  public void postOrder() 
  {
      if (root == null) 
    	  return;

      final Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode node = root;

      while (!stack.isEmpty() || node != null) 
      {
          while (node != null) 
          {
              if (node.right != null) stack.add(node.right);
              stack.add(node);
              node = node.left;
          }
          node = stack.pop();

          if (node.right != null && !stack.isEmpty() && node.right == stack.peek()) 
          {
              TreeNode nodeRight = stack.pop();
              stack.push(node);
              node = nodeRight;
          }
          else 
          {
              System.out.print(node.element + " ");
              node = null;
          }
      }
  }
  
  public void preOrder()
  {   
      if (root == null) return;

      final Stack<TreeNode> stack = new Stack<TreeNode>();
      stack.add(root);        

      while (!stack.empty()) 
      {
          TreeNode node = stack.pop();           
          System.out.print(node.element + " ");
          // LIFO
          if (node.right != null) stack.push(node.right);
          if (node.left != null) stack.push(node.left);
      }
  }
  
  public static class TreeNode<E extends Comparable<E>> 
  {
    public String data;
	public TreeNode rightNode;
	public Object leftNode;
	E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) 
    {
      element = e;
    }
  }
  
  public int getSize() 
  {
    return size;
  }

  public TreeNode<E> getRoot() 
  {
    return root;
  } 
}