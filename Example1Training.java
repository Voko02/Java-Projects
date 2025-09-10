import  java.util.Scanner;
public class Example1ReadInupts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String txt = input.nextLine();
		System.out.println(txt);
		for(int i = 1; i <= Integer.parseInt(txt); i++) {
			//System.out.println("Hello");
			//System.out.println("Hello");
			String txt2 = input.nextLine();
			System.out.println(txt2);
			System.out.println(txt2.length());
			String txtNoReplace = txt2.replace(" ", "");
			System.out.println(txtNoReplace);
			String allCaps = txt2.toUpperCase();
			System.out.println(allCaps);
			String allLower = txt2.toLowerCase();
			System.out.println(allLower);
			String x = txt2.substring(2);
			System.out.println(x);
			String z = txt2.substring(2, 5);
			System.out.println(z);
			String k = txt2.substring(txt2.length()-3);
			System.out.print(k);
		}
		String y = "Hello World";
		for (int i = 0; i < y.length(); i ++) {
			System.out.println(y.charAt(i));
		}
	}

}

/*
4
Hello Everyone
h12354
Good Morning
Competition
*/
