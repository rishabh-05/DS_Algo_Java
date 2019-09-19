package First;

public class Test123 {
static int count  = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1; 
		int s = 1;
		while(s<1000) {
			i++;
			s = s+i;
			System.out.println(count++ +"  " +i +"  "+ s);
		}
		
	}

}
