package Lab7;
public interface Tree<E extends Comparable<E>> extends Iterable<E> {
  public boolean search(E e);
  public boolean insert(E e);
  public boolean delete(E e);
  public void inorder();
  public void postorder();
  public void preorder();
  public int getSize();
  public boolean isEmpty();
}
