package foundation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithms.Quick;
import algorithms.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import exercises.Parentheses;

/**
 * 第一章  基础
 * @author Administrator
 *
 */
public class Foundation {
	
	
	
	private static double[][] binom = new double[100][50];

	/**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static List<String> readTxtFile(String filePath){
        List<String> lineTxtList = null;
        try {
        	String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                lineTxtList = new ArrayList<String>();
                while((lineTxt = bufferedReader.readLine()) != null){
                	System.out.println(lineTxt);
                    lineTxtList.add(lineTxt);
                }
                read.close();
	        }else{
	            System.out.println("找不到指定的txt文件");
	            return null;
	        }
        } catch (Exception e) {
        	System.out.println("读取txt文件内容出错");
            e.printStackTrace();
        }
        return lineTxtList;
    }
	
	/*
	 * 欧几里得算法
	 * 求p和q的最大公约数
	 */
	public static int gcd (int p, int q) {
		if(q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
	
	/*
	 * 二分法查找递归
	 */
	public static int rank(int key, int[] a, int lo, int hi) {
		System.out.println('a');
		if(key > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < mid) return rank(key, a, lo, mid - 1);
		else if(key > mid) return rank(key, a, mid + 1, hi);
		else return mid;
	}
	
	/*
	 * 二分查找
	 */
	public static int rank (int key, int[] a){
		//数组a必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		
		while (lo <= hi) {
			//被查找的key要么不存在要么必然存在于[lo..hi]之中
			int mid = lo + (hi - lo) / 2;
			if(key <= mid) hi = mid - 1;
			else if(key > mid) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	/*
	 * 习题1.1.14
	 */
	public static int lg(int N){
		int i = 0; int s = 1;
		while(s*2 < N){
			s *= 2;
			i ++;
		}
		return i;
	}
	
	/*
	 * 习题1.1.15
	 */
	public static int[] histogram(int[] a, int m) {
		int b[] = new int[m];
		for(int j=0; j<m; j++){
			int s = 0;
			for(int i=0; i<a.length; i++) if(a[i]==j) s++;
			b[j] = s;
		}
		return b;
	}
	
	/*
	 * 习题1.1.21
	 */
	public static void xiti21 (String filePath) {
		File file = new File(filePath);
		if(file == null) return;
		try {
			if(file.isFile() && file.exists()){
				FileInputStream is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String str;
				while ((str = br.readLine()) != null) {
					String  s[] = str.split(" ");
					System.out.println(s[0]+" : "+Integer.parseInt(s[1])+" / "+Integer.parseInt(s[2])
							+" = "+(Integer.parseInt(s[1]) / Integer.parseInt(s[2])));
				}
				br.close();
				isr.close();
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 习题1.1.22
	 */
	public static int xiti22 (int key, int[] a){
		//数组a必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		String s= " ";
		
		while (lo <= hi) {
			System.out.println(s + lo + " " + hi);
			s += " ";
			//被查找的key要么不存在要么必然存在于[lo..hi]之中
			int mid = lo + (hi - lo) / 2;
			if(key <= mid) hi = mid - 1;
			else if(key > mid) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	/*
	 * 习题1.3.4
	 */
	public Boolean testParentheses (String path) {
		Parentheses parentheses = new Parentheses();
		return parentheses.isDoubleBrackets(path);
	}
	
	/* ==================================main===========main=============main================================================= */
	public static void main(String[] args) {
		
//		//求21和15的最大公约数
//		System.out.println(gcd(21, 15));
//
//		//二分法查找3数组a的位置
//		int[] a = {1,2,3,4,5,6,7,8,9,19};
//		System.out.println(rank(3, a, 0, a.length - 1));
//		
//		//二分查找数组中的值
//		int[] whitelist = In.readInts("E:\\data\\algs4-data\\tinyT.txt");
//		Arrays.sort(whitelist);
//		while (!StdIn.isEmpty()) {
//			//读取简直，如果不存在于白名单中则将其打印
//			int key = StdIn.readInt();
//			if(rank(key, whitelist) < 0) StdOut.println(key);
//		}
		
//		int[] a = {1,2,3,4,2,5,7,8,8,9};
//		int b[] = histogram(a, 18);
//		for(int i=0; i< b.length; i++) System.out.println(b[i]);
//		int s = 0;
//		assert s > 4;
//		System.out.println(s);
		
//		Integer[] a = new Integer[5];
//		a[0] = 2; a[1] = 5; a[2] = 8; a[3] = 9; a[4] = 3;
//		Quick q = new Quick();
//		q.sort(a);
//		for(Integer i : a){
//			System.out.println(i);
//		}
		
		
	}

}
