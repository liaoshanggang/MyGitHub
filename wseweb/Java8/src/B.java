
public class B {
	public int add(int a,int b){
		try {
			return a+b;
		} catch (Exception e) {
			System.out.println("catch");
		} finally{
			System.out.println("finally");
		}
		return 0;
	}
	/*public static void main(String[] args) {
		B demo = new B();
		System.out.println("和是："+demo.add(9, 34));
	}*/
}
