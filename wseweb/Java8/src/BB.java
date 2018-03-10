
 class AA {
	private static AA aa= new AA();
	static{
		System.out.println("static");
	}
	public AA(){
		System.out.println("A");
	}
}
 public class BB extends AA{
	public BB(){
		System.out.println("B");
	}
	public static void main(String[] args) {
		BB bb = new BB();
	}
}
