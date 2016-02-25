//Team Members: Rajnish Kumar(CIN:304470392) & Jay Purohit(CIN:304455065)
package Lab7;

import java.util.Scanner;
public class TestAVLTree {
public static void main(String[] args) {
Integer[] numbers = {2, 5, 1, 9, 7, 11, 14, 17};
AVLTree<Integer> tree = new AVLTree<>(numbers);
System.out.println("List contains:2,5,1,9,7,11,14,17");
Scanner input = new Scanner(System.in);
System.out.print("Enter k: ");
int k=input.nextInt();
System.out.println("The " + k + "th smallest number is: " +tree.find(k));

}
}
