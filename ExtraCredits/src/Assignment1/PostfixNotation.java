package Assignment1;

import java.util.Scanner;

public class PostfixNotation extends Stack {
   	public PostfixNotation(int x) {
        super(x);
    }

public String InToPost(String iString) {
    String pString = " ";
        for (int index = 0; index < iString.length(); ++index) {
            char chValue = iString.charAt(index);
            if (chValue == '(') {
                push('(');
            } else if (chValue == ')') {
                Character oper = (Character) peek();
                while (!(oper.equals('(')) && !(isEmpty())) {
                    pString += oper.charValue();
                    pop();
                    oper = (Character) peek();
                }
                pop();
            } else if (chValue == '+' || chValue == '-') {
                if (isEmpty()) {
                    push(chValue);
                } else {
                    Character oper = (Character) peek();
                    while (!(isEmpty() || oper.equals(new Character('(')) || oper.equals(new Character(')')))) {
                        pop();
                        pString += oper.charValue();
                    }
                    push(chValue);
                }
            } else if (chValue == '*' || chValue == '/') {
                if (isEmpty()) {
                    push(chValue);
                } else {
                    Character oper = (Character) peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) && !isEmpty()) {
                        pop();
                        pString += oper.charValue();
                    }
                    push(chValue);
                }
            } else {
                pString += chValue;
            }
        }
        while (!isEmpty()) {
            Character oper = (Character) peek();
            if (!oper.equals(new Character('('))) {
                pop();
                pString += oper.charValue();
            }
        }
        return pString;
    }

public static void main(String[] args) {
		PostfixNotation mystack = new PostfixNotation(10);
		System.out.println("Type an expression:\n");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		System.out.println("Postfix Notation is:\n"+mystack.InToPost(str));
	}
}