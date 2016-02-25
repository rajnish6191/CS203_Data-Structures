package Lab7;

import java.util.ArrayList;
import java.util.List;

public class BST<E extends Comparable<E>> 
    extends AbstractTree<E> {
  protected TreeNode<E> root;
  protected int size = 0;

  public BST() {
  }

  public BST(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }
  
  @Override 
  public boolean search(E e) {
    TreeNode<E> current = root; 

    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else 
        return true; 
    }

    return false;
  }

  @Override 
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); 
    else {
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
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

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<>(e);
  }

  @Override
  public void inorder() {
    inorder(root);
  }

  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

  @Override 
  public void postorder() {
    postorder(root);
  }

  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  @Override 
  public void preorder() {
    preorder(root);
  }

  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public void breadthFirstTraversal(){
	  List<TreeNode<E>> list=new
              ArrayList<TreeNode<E>>();
	  if(root != null)
      list.add(root);

	  		TreeNode<E> current;
	  		while(!list.isEmpty()){
	  		current= (TreeNode<E>)list.remove(0);
	  		System.out.print(current.element + " ");
     
	  		if(current.left != null)
              list.add(current.left);
	  		if(current.right != null)
              list.add(current.right);               
	  		}
  }
//Find and return the height of the tree
	public int height()
		{
		return height(root);
		}
	private int height(TreeNode<E> root)
	{
		if(root ==null)
		{
		        return 0;
		}
		else
		{
		        return 1 + Math.max(height(root.left),height(root.right));
		}
	}
  public static class TreeNode<E extends Comparable<E>> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public TreeNode(E e) {
      element = e;
    }
  }

  @Override 
  public int getSize() {
    return size;
  }

  public TreeNode<E> getRoot() {
    return root;
  }

  public java.util.ArrayList<TreeNode<E>> path(E e) {
    java.util.ArrayList<TreeNode<E>> list =
      new java.util.ArrayList<>();
    TreeNode<E> current = root; 

    while (current != null) {
      list.add(current); 
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else
        break;
    }

    return list; 
  }

  public java.util.ArrayList<TreeNode<E>> get(E e) {
	    java.util.ArrayList<TreeNode<E>> list =
	      new java.util.ArrayList<>();
	    TreeNode<E> current = root; 

	    while (current != null) {
	      list.add(current); 
	      if (e.compareTo(current.element) < 0) {
	        current = current.left;
	      }
	      else if (e.compareTo(current.element) > 0) {
	        current = current.right;
	      }
	      else
	        break;
	    }

	    return list; 
	  }
  
  @Override 
  public boolean delete(E e) {
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; 
    }

    if (current == null)
      return false; 

    if (current.left == null) {
      if (parent == null) {
        root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; 
      }
      current.element = rightMost.element;
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        parentOfRightMost.left = rightMost.left;     
    }

    size--;
    return true; 
  }

  @Override 
  public java.util.Iterator<E> iterator() {
    return new InorderIterator();
  }
  private class InorderIterator implements java.util.Iterator<E> {
    private java.util.ArrayList<E> list =
      new java.util.ArrayList<>();
    private int current = 0; 
    public InorderIterator() {
      inorder(); 
    }

    private void inorder() {
      inorder(root);
    }

    private void inorder(TreeNode<E> root) {
      if (root == null)return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    @Override 
    public boolean hasNext() {
      if (current < list.size())
      return true;
      return false;
    }

    @Override 
    public E next() {
      return list.get(current++);
    }

    @Override 
    public void remove() {
      delete(list.get(current)); 
      list.clear(); 
      inorder(); 
    }
  }

  public void clear() {
    root = null;
    size = 0;
  }
}