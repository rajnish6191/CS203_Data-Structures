package Assignment6;

  public class MyLinkedList<E> extends MyAbstractList<E> 
  {
    private Node<E> head, tail;
	private int size;    
    public MyLinkedList()
    { }
  
    public MyLinkedList(E[] objects) 
    {
      super(objects);
    }

    public E getFirst() 
    {
      if (size == 0) 
      {
        return null;
      }
      else 
      {
        return head.element;
      }
    }
 
    public E getLast() 
    {
      if (size == 0) 
      {
        return null;
      }
      else
      {
        return tail.element;
      }
    }
    
    public void addFirst(E e) 
    {   
      Node<E> newNode = new Node<E>(e);
      newNode.next = head;
      head = newNode;
      size++; 

      if (tail == null)
        tail = head;
    }
    
    public void addLast(E e) 
    {
      Node<E> newNode = new Node<E>(e); 

      if (tail == null) 
      {
        head = tail = newNode;
      }
      else
      {
        tail.next = newNode;
        tail = tail.next;
      }

      size++; 
    }

    public void add(int index, E e) 
    {  
      if (index == 0) 
      {
        addFirst(e);
      }
      else if (index >= size) 
      {
        addLast(e);
      }
      else
      {
        Node<E> current = head;
        for (int i = 1; i < index; i++) 
        {
          current = current.next;
        }
        Node<E> temp = current.next;
        current.next = new Node<E>(e);
        (current.next).next = temp;
        size++;
      }
    }
    
    public E removeFirst() 
    {
      if (size == 0)
      {
        return null;
      }
      else
      {
        Node<E> temp = head;
        head = head.next;
        size--;
        if (head == null) 
        {
          tail = null;
        }
        return temp.element;
      }
    }
    
    public E removeLast() 
    {
      if (size == 0) 
      {
        return null;
      }
      else if (size == 1) 
      {
        Node<E> temp = head;
        head = tail = null;
        size = 0;
        return temp.element;
      }
      else
      {
        Node<E> current = head;

        for (int i = 0; i < size - 2; i++) 
        {
          current = current.next;
        }

        Node<E> temp = tail;
        tail = current;
        tail.next = null;
        size--;
        return temp.element;
      }
    }

      public E remove(int index) 
      { 
      if (index < 0 || index >= size) 
      {
        return null;
      }
      else if (index == 0) 
      {
        return removeFirst();
      }
      else if (index == size - 1) 
      {
        return removeLast();
      }
      else
      {
        Node<E> previous = head;

        for (int i = 1; i < index; i++) 
        {
          previous = previous.next;
        }

        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
      }
    }

    @Override
    public String toString() 
    {
      StringBuilder result = new StringBuilder("[");

      Node<E> current = head;
      for (int i = 0; i < size; i++) 
      {
        result.append(current.element);
        current = current.next;
        if (current != null) 
        {
          result.append(", ");
        }
        else
        {
          result.append("]"); 
        }
      }

      return result.toString();
    }
    
    public void clear()
    {
    	size=0;
    	head = tail = null;
    }
    
    public boolean contains(E e) 
    {
    	Node<E> current=head;
    	for(int i=0;i<size-1;i++)
    	{
    		if(e.equals(current.element))
    		{
    			return true;
    		}
    		current=current.next;
    	}
    	return false;
	}
    
    public E get(int index)
    {
		if (index < 0 || index >= size) 
		{
			throw new IndexOutOfBoundsException("index = " + index);
		}
		if(index==0)
		{
			return getFirst();
		}
		else if(index==size-1)
		{
			return getLast();
		}
		
		else
		{
			Node<E> p = head;
			for (int i = 1; i <= index; i++) 
			{
				p = p.next;
			}

			return p.element;
		}
	}

	private void checkIndex(int index) 
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException
			("index " + index + " out of bounds");
	}

	public int indexOf(E e) 
	{
		Node p = head;
		int index = 0;
		while (p != null) 
		{
				if (e.equals(p.element)) 
				{
					return index;
				}
			
			p = p.next;
			index++;
		}

		return -1;
	}
    
    public boolean isEmpty() 
    {
		
    	if (this.size()==0)
    		return true;
    	else
    	{
    		return false;
    	}
	}
	public int size() 
	{
		int count = 0;
		Node<E> p = head;
		while (p != null) 
		{
			count++;
			p = p.next;
		}
	
		if (size != count) 
		{
			throw new IllegalStateException("count = " + count + ", size = "
					+ size);
		}
		return size;
	}
    
    public int lastIndexOf(E e) 
    {
    	Node<E> p = head;
		
		
		for (int i = size - 1; i >= 0; i--)
			if (e.equals(p.element))
				return i;

		return -1;
	}
    
    public E set(int index, E e) 
    { 
	
    	 Node<E> current = head;
    	 int i=0;
    	 while(i!=index)
    	 {
    		 current=current.next;
    		 i++;
    	 }
    	 current.element=e;
    	 
    	 return null;
	}

    public java.util.Iterator<E> iterator() 
    {
      return new LinkedListIterator();
    }

    private class LinkedListIterator 
        implements java.util.Iterator<E> 
    {
    	private MyLinkedList<E> list;
    	private Node<E> current = head;
    
      public boolean hasNext() 
      {
        return (current != null);
      }

      public E next()
      {
        E e = current.element;
        current = current.next;
        return e;
      }

      public void remove(E e) 
      { 
    	  MyLinkedList.this.remove(e);
		
      } 
    }
    
    private class Node<E> 
    {
      E element;
      Node<E> next;

      public Node(E element)  
      {
        this.element = element;
      }
    }
  }