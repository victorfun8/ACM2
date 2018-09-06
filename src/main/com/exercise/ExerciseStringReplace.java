package com.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExerciseStringReplace {
	public static void main(String[] args) {
		ExerciseStringReplace demo = new ExerciseStringReplace();
		demo.testReplaceAll();
//		demo.testString();
	}
	
	public void testString() {
		String s = "abcdefgabcdefgabcdefgabcdefg";
		if (s.contains("b")) {
			System.out.println("there has b!!!!!!");
			String s1 = s.replace("b", "\\b");
//			line.replace("\\0", "a");
			System.out.println("====== " + s + " ======");
			System.out.println("====== " + s1 + " ======");
		}
	}
	
	String filePath = "D:\\waserver-test.log";
	
	public void testReplaceAll() {
		File file = new File(filePath);
		
		if (!file.exists()) {
			System.out.println("file is not exist!!!!!!!!");
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line;
			while ((line = br.readLine()) != null && line.length() > 0) {
				System.out.println("------ " + line + " ------");
				if (line.contains("\0")) {
					System.out.println("there has \\0!!!!!!");
					//line.replaceAll("\\\\\0", "a");
					//line.replace('\0', 'a');
//					line.replace("\0", "a");
					String newLine = line.replace("\0", "a");
					System.out.println("====== " + line + " ======");
					System.out.println("====== " + newLine + " ======");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
