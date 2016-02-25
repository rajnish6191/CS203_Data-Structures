package Assignment5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Assignment5 extends Application {
    TextArea tfOutput = new TextArea(" "); 
    TextField tf = new TextField(); 
	
	 public void start(Stage primaryStage) {
		    HBox paneForButtons = new HBox(20);
		    Button btBubble  = new Button("Bubble" );
		    Button btMerge  = new Button("Merge" );
		    Button btHeap  = new Button("Heap" );
	        paneForButtons.getChildren().addAll(btBubble,btMerge,btHeap);
		    paneForButtons.setAlignment(Pos.CENTER);
		    paneForButtons.setStyle("-fx-border-color: green");
		    BorderPane paneForTextField = new BorderPane();
		    paneForTextField.setPadding(new Insets(5, 5, 5, 5)); 
		    paneForTextField.setStyle("-fx-border-color: green");
		    paneForTextField.setLeft(new Label("Enter Input element: "));
		    tf.setAlignment(Pos.BOTTOM_LEFT);
		    paneForTextField.setCenter(tf);
		    BorderPane paneForOuputTextField = new BorderPane();
		    paneForOuputTextField.setPadding(new Insets(5, 5, 5, 5)); 
		    paneForOuputTextField.setStyle("-fx-border-color: green");
		    paneForOuputTextField.setLeft(new Label(" Output element: "));
		    
		    tfOutput.setPrefColumnCount(15);
		    tfOutput.setPrefRowCount(5);
		    tfOutput.setEditable(false);
		    tfOutput.setWrapText(true);
		    tfOutput.setStyle("-fx-text-fill: red");
		    tfOutput.setFont(Font.font("Times", 20));
		    paneForOuputTextField.setCenter(tfOutput);
		    
		    BorderPane pane = new BorderPane();
		    pane.setBottom(paneForButtons);
		    pane.setTop(paneForTextField);
		    pane.setCenter(paneForOuputTextField);
		   
		    btBubble.setOnAction(this::searchList);
		    btMerge.setOnAction(this::searchList1);
		    btHeap.setOnAction(this::searchList2);
		    Scene scene = new Scene(pane, 450, 200);
		    primaryStage.setTitle("Sorting"); 
		    primaryStage.setScene(scene); 
		    primaryStage.show(); 
			  }
	 
	 public static <E extends Comparable<E>> void bubbleSort(E[] list) {
	    	boolean needNextPass = true;
		    for (int k = 1; k < list.length && needNextPass; k++) {
		      needNextPass = false;
		      
		      for (int i = 0; i < list.length - k; i++) {
		        if (((Comparable)list[i]).compareTo(list[i + 1])>0 ) {
		          E temp = list[i];
		          list[i] = list[i + 1];
		          list[i + 1] = temp;
		          needNextPass = true;
		        }
		      }
		    }
		  }
	 
	 public void searchList(ActionEvent e)  {
		    String[] numbers = tf.getText().split("\\s+");
			Integer[] list = new Integer[numbers.length];			
			try {
				for(int i = 0; i < numbers.length; i++){
					list[i] = Integer.parseInt(numbers[i]);
				}	
				bubbleSort(list);
				tfOutput.appendText("Output elment is :-" );
				for(int i = 0; i < list.length; i++){
					tfOutput.appendText(list[i].toString());
					tfOutput.appendText(" ");
				}
			} catch(Exception ex){
			}
		}

	 public static <E extends Comparable<E>> void mergeSort(E[] list) {
		    if (list.length > 1) {
		      E[] firstHalf = (E[])new Comparable[list.length / 2];
		      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
		      mergeSort(firstHalf);
		      int secondHalfLength = list.length - list.length / 2;
		      E[] secondHalf = (E[])new Comparable[secondHalfLength];
		      System.arraycopy(list, list.length / 2,
     	        secondHalf, 0, secondHalfLength);
	     	      mergeSort(secondHalf);
		      E[] temp = merge(firstHalf, secondHalf,list);
		      System.arraycopy(temp, 0, list, 0, temp.length);
		    }
		  }

	public static<E extends Comparable<E>> E[]
	    merge(E[] list1, E[] list2, E[] temp) {
		    int current1 = 0; 
		    int current2 = 0; 
		    int current3 = 0; 
		    while (current1 < list1.length && current2 < list2.length) {
		      if (list1[current1].compareTo(list2[current2]) < 0 )
		        temp[current3++] = list1[current1++];
		      else
		        temp[current3++] = list2[current2++];
		    }

		    while (current1 < list1.length)
		      temp[current3++] = list1[current1++];

		    while (current2 < list2.length)
		      temp[current3++] = list2[current2++];

		    return temp;
		  }
	 
	 public void searchList1(ActionEvent e)  {
		 	String[] numbers = tf.getText().split("\\s+");
		 	Integer[] list = new Integer[numbers.length];
			try {
				for(int i = 0; i < numbers.length; i++){
					list[i] = Integer.parseInt(numbers[i]);
				}
				mergeSort(list);
				tfOutput.appendText("Output elment is :-" );
				for(int i = 0; i < list.length; i++){
					tfOutput.appendText(list[i].toString());
					tfOutput.appendText(" ");
				}
			} catch(Exception ex){
			}
		}
	
	 public static <E extends Comparable<E>> void heapsort(E[] list)
	    {
	        for( int i = list.length / 2; i >= 0; i-- ) 
	            shiftDown( list, i, list.length );
	        for( int i = list.length - 1; i > 0; i-- )
	        {
	            swapReferences( list, 0, i );           
	            shiftDown( list, 0, i );
	        }
	    }
 
	 private static int leftChild( int i )
	    {
	        return 2 * i + 1;
	    }
	    private static <E> void shiftDown( E[] list, int i, int n )
	    {
	        int childRight;
	        Comparable tmp;
	        for( tmp = (Comparable) list[ i ]; leftChild( i ) < n; i = childRight )
	        {
	        	childRight = leftChild( i );
	            if( childRight != n - 1 && ((Integer) list[ childRight ]).compareTo( (Integer) list[ childRight + 1 ] ) < 0 )
	            	childRight++;
	            if( tmp.compareTo( list[ childRight ] ) < 0 )
	            	list[ i ] = list[ childRight ];
	            else
	                break;
	        }
	        list[ i ] = (E) tmp;
	    }
	 
	    public static final void swapReferences( Object [ ] a, int index1, int index2 )
	    {
	        Object tmp = a[ index1 ];
	        a[ index1 ] = a[ index2 ];
	        a[ index2 ] = tmp;
	    }
       
	    public void searchList2(ActionEvent e)  {
		 	String[] numbers = tf.getText().split("\\s+");
		 	Integer[] list = new Integer[numbers.length];
			try {
				for(int i = 0; i < numbers.length; i++){
					list[i] = Integer.parseInt(numbers[i]);
				}
				heapsort(list);
				tfOutput.appendText("Output elment is :-" );
				for(int i = 0; i < list.length; i++){
					tfOutput.appendText(list[i].toString());
					tfOutput.appendText(" ");
				}
			} catch(Exception ex){
			}
		}
			  public static void main(String[] args) {
			    launch(args);
			  }
			}