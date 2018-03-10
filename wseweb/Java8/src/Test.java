public class Test{
String para1;
StringBuffer para2;

public void method1(String param){
	para1 = param.replace('j','l');
}

public void method2(StringBuffer param){
	para2 = param.append('c');
}

public static void main(String[] args){
//	Test obj = new Test();
//	obj.method1(new String("java"));
//	obj.method2(new StringBuffer("java"));
//	System.out.println(obj.para1);
//	System.out.println(obj.para2.toString());
	//System.out.println(getValue(2));
	String a = "JAVA";
	System.out.println(a.charAt(2));
	
//	float x;
//	x = 10/4;
//	System.out.println(x);
	
}
public static int getValue(int i) {
    int result = 0;
    switch (i) {
    case 1:
        result = result + i;
    case 2:
        result = result + i * 2;
    case 3:
    	//i=2;
        result = result + i * 3;
    }
    return result;
}
}
class A{
	
}
class C extends A {
	
}