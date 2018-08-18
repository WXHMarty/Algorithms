package exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import algorithms.Stack;
/**
 * 练习题1.3.4
 * 判断文本中的括号是否完整
 * @author Administrator
 *
 */
public class Parentheses {

	/*
	 * 括号完整返回true
	 * 括号不完整返回false
	 */
	public Boolean isDoubleBrackets (String path) {
		// 读取文本
		File file = new File(path);
		String text = "";
		if(file.exists() && file.isFile()){
			try {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String str;
				while((str = br.readLine()) != null) text += str;
				br.close();
				isr.close();
				fis.close();
			} catch (Exception e) { e.printStackTrace(); }
		}
		
		// 开始判断是否有不配对的括号
		if("".equals(text) || text == null) return true;
		char[] texts = text.toCharArray();
		Stack<Character> st = new Stack<Character>();
		for(char c : texts){
			if(c == '}'){
				Character ch = getLeftBracketInStack(st);
				if(ch != '{') return false;
			} else if(c == ']'){
				Character ch = getLeftBracketInStack(st);
				if(ch != '[') return false;
			} else if(c == ')'){
				Character ch = getLeftBracketInStack(st);
				if(ch != '(') return false;
			} else st.push(c);
		}
		return true;
	}
	
	/*
	 * 在栈中找出左括号
	 * 到最后返回null
	 */
	private Character getLeftBracketInStack (Stack<Character> stack) {
		if(stack.size() == 0) return null;
		Character c = stack.pop();
		while (!(c == '}' || c == ']' || c == ')' || c == null)) c = stack.pop();
		return c;
	}
}
