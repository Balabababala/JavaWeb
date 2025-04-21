package case02;

import java.util.*;

public class GuestBookMain {
	
	private static List<GuestBook> guestbooks =new ArrayList();

	public  static void main (String[] args) {
		
		GuestBook g1=new GuestBook("hello 大家好");
		guestbooks.add(g1);
		System.out.printf("%s",guestbooks);
		
		
		GuestBook g2=new GuestBook("好像下雨了");
		guestbooks.add(g2);
		System.out.printf("%s",guestbooks);
		
		
		
		
	}
}
