package Lab3;

import java.util.*;
import java.io.*;

public class SetsandMaps {
	public static void main(String[] args) {
		Scanner gs = new Scanner(System.in);
		String gsm = gs.next();
		screen(gsm);
	}

	public static void screen(String gsm) {
		String token[] = gsm.split(","); /// input data with comma
		ArrayList<String> m = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < token.length; i++) {
			m.add(token[i]);
		}
		for (int i = 0; i < m.size() - 1; i++) {
			for (int j = i + 1; j < m.size(); j++) {
				if (m.get(i).equals(m.get(j))) {
					b.add(i);
					break;
				}
			}
		}

		Collections.sort(m);
		for (Integer i : b) {
			String s1 = m.get(i);
			m.remove(s1);
		}
		
		for (int i = 0; i < m.size(); i++) {
			System.out.println(m.get(i));
		}
	}
}