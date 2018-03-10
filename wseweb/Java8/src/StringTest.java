import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringTest {
	static void print(String[] s){
		for(int i=0;i<s.length-1;i++)
			System.out.print(s[i]+" ");
		System.out.println(s[s.length-1]);
	}
	
	public static void main(String[] args) {
		
		String s=(new Scanner(System.in)).nextLine();
		String[] ss=s.split("[\\s]+");
		for(int i=0;i<ss.length;i++){
			String up=(ss[i].charAt(0)+"").toUpperCase();
			StringBuffer sb=new StringBuffer(ss[i]);
			ss[i]=sb.replace(0,1,up)+"";
			Matcher m=Pattern.compile("\\d+").matcher(ss[i]);
			while(m.find()){
				String num=new String(m.group());
				String num2="_"+num+"_";
				ss[i]=ss[i].replace(num,num2);
				if(ss[i].startsWith("_"))
					ss[i]=ss[i].substring(1);
				if(ss[i].endsWith("_"))
					ss[i]=ss[i].substring(0, ss[i].length()-1);
			}
		}
		print(ss);
		
	}
	////you and     me what   2005program
}
