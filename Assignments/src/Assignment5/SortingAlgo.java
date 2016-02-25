package Assignment5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingAlgo extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 500, HEIGHT = 300;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	static TextArea text = new TextArea(" ");
	Integer[] list = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox();		
		vBox.getChildren().addAll(new Label("Please Enter Numbers in a list to be sorted. "),
							tf, new Label("Please Enter a Sorting Method: 1[Bubble Sort] / 2[Merge Sort] / 3[Heap Sort] "), keyField);				
		keyField.setOnAction(this::searchList);
		bp.setBottom(vBox);
		bp.setCenter(text);
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("SortingAlgo)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static <E extends Comparable<E>> void heapsort(E[] list) 
	{
		text.setText("");
		String strI="";
		StringBuilder sb = new StringBuilder();
	   Heap<E> heap=new Heap<>();
	    for (int i = 0; i < list.length; i++)
	      heap.add(list[i]);
	    for (int i = list.length - 1; i >= 0; i--)
	      list[i] = heap.remove(); 
	    for(int i=0;i<list.length;i++)
		{
			sb.append(" ");
			sb.append(list[i]);
			strI = sb.toString();
		}
	    text.appendText("Heap Sort output is:"+strI);
	}

	public static <E extends Comparable<E>> void mergesort(E[] list) 
    {
		text.setText("");
		String strI="";
		StringBuilder sb = new StringBuilder();
    	mergesort(list, 0, list.length-1);
    	for(int i=0;i<list.length;i++)
		{			
			sb.append(" ");
			sb.append(list[i]);
			strI = sb.toString();
		}
    	text.appendText("Merge Sort output is:"+strI);
    }
	
    private static <E extends Comparable<E>> void mergesort (E[] list, int i, int j) 
    {
    	if (j-i < 1) return;
    	int mid = (i+j)/2;
    	mergesort(list, i, mid);
    	mergesort(list, mid+1, j);
    	merge1(list, i, mid, j);
    }

    private static <E extends Comparable<E>> void  merge1(E[] list, int p, int mid, int q) 
    {

    	Object[] tmp = new Object[q-p+1]; 
    	int i = p;
    	int j = mid+1;
    	int k = 0;
    	while (i <= mid && j <= q) 
    	{
    		if (list[i].compareTo(list[j])<=0)
    			tmp[k] = list[i++];
    		else
    			tmp[k] = list[j++];
    			k++;
    	}
    	if (i <= mid && j > q) 
    	{
    		while (i <= mid) 
    			tmp[k++] = list[i++];
    	}
    	else
    	{
    		while (j <= q)
    			tmp[k++] = list[j++];
    	}
    	for (k = 0; k < tmp.length; k++) 
    	{
	    list[k+p] = (E)(tmp[k]); 
    	}
    }

	public static <E extends Comparable<E>> void bubblesort(E[] list) 
	{
		text.setText("");
		String strI="";
		StringBuilder sb = new StringBuilder();
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++)
        {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) 
            {
                if ((list[i].compareTo(list[i+1])) > 0) 
                {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
              
                    needNextPass = true;             
                }
            }
        }
		for(int i=0;i<list.length;i++)
		{
			
			sb.append(" ");
			sb.append(list[i]);
			strI = sb.toString();
		}
		text.appendText("Bubble Sort output is:"+strI);   
	}
	
	public void searchList(ActionEvent e) 
	{		
		String[] numbers = tf.getText().split("\\s");
		int key; 
		list = new Integer[numbers.length];
		try {
				for(int i = 0; i < numbers.length; i++)
				{
				list[i] = Integer.parseInt(numbers[i]);
				}
			
				key = Integer.parseInt(keyField.getText());
			
				if(key==1)
				{
					bubblesort(list);
				}
				else if(key==2)
				{
					mergesort(list);
				}
				else if(key==3)
				{
					heapsort(list);
				}
				else
				{
					text.setText("");
					text.appendText("please enter a number from only 1 or 2 or 3");
				}
		} 
		catch(Exception ex)
		{	
			text.appendText("Please enter numbers without leading space. ");
		}
	}
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}