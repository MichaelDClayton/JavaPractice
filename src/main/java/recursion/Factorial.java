package recursion;

public class Factorial {

	public static void main(String[] args) {
		/*Queue<Integer> stack = new LinkedList<Integer>();
		for(int i =0;i<5;i++) {
			stack.add(i);
		}
		
		System.out.println(stack);*/
		System.out.println(factorial(5));
	}
	
	
	public static int factorial(int x) {
		
		if(x < 2)
			return 1;
		int g = x-1;
		System.out.println("x:"+x +" factorial("+g+")");
		return x * factorial(g);
		
	}
	
}
