package test.app;

import java.util.Scanner;

public class bigNumberSub {

	/**
	 * @param args
	 */
	public String NumberSub(String f,String s){
		System.out.println("减法"+f+"-"+s+"=");
		//讲字符串翻转并转化成字符数组
		char[] a=new StringBuffer(f).reverse().toString().toCharArray();
		char[] b=new StringBuffer(s).reverse().toString().toCharArray();
		int lenA=a.length;
		int lenB=b.length;
		//找到最大长度
		int len=lenA>lenB ? lenA:lenB;
		int result[]=new int[len];
		//表示结果的正负
		char sign='+';
		//判断结果正负
		if(lenA>lenB){
			sign='-';
		}else if (lenA==lenB){
			int i=lenA-1;
			while(i>0&&a[i]==b[i]){
				i--;
				}
			if(a[i]<b[i]){
				sign='-';
			}
		}
		//计算机结果集，如果最终结果为正，那么就是a-b否则就是b-a
		for(int i=0;i<len;i++){
			int aint=i<lenA ?(a[i]-'0'):0;
			int bint=i<lenB ?(b[i]-'0'):0;
			if(sign=='+'){
				result[i]=aint-bint;
			}else{
				result[i]=bint-aint;	
			}
		}
		//如果结果集中某一位小于零，那么久向前一位借一，然后本位加10，其实就是借位减法
		for(int i=0;i<result.length;i++){
			if(result[i]<0){
				result[i+1] -=1;
				result[i] +=10;
			}
		}
		StringBuffer sb=new StringBuffer();
		//如果最后结果为负，就讲符号放在最前面，正号不需要
		if(sign=='-'){
			sb.append(sign);
		}
		//判断是否有前置0
		boolean flag=true;
		for(int i=len-1;i>=0;i--){
			if(result[i]==0&&flag){
				continue;
			}else{
				flag=false;
			}
			 sb.append(result[i]);  
		}
		//如果最终结果集合中没有值，就说明两个值相等，最终反回0
		if(sb.toString().equals("")){
			sb.append("0");
		}
		//返回值
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println("请长度小于100的数:");
		Scanner sc=new Scanner(System.in);
		String f="";
		String s="";
		if(f.length()>100){
			System.out.println("输入的字符串s长度大于了100:");
		}
		
		if(s.length()>100){
			System.out.println("输入的字符串s长度大于了100:");
		}
		 f=sc.next();
		 s=sc.next();
		 bigNumberSub sub=new bigNumberSub();
		String result= sub.NumberSub(f, s);
		System.out.println("两个字符串相互减法的结果是："+result);
		 
	}

}
