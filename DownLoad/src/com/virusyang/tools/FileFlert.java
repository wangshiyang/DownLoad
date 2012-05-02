package com.virusyang.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileFlert {
	static long xxx=0;
	static long yyy=0;
	public static void main(String args[]) throws UnsupportedEncodingException {
		/*
		 * File f=new File("H:\\600w.txt"); File f1=new File("H:\\600w8.txt");
		 * try { FileReader fReader=new FileReader(f); FileWriter fWriter=new
		 * FileWriter(f1); BufferedReader bReader=new BufferedReader(fReader);
		 * BufferedWriter bWriter=new BufferedWriter(fWriter); String string="";
		 * while((string=bReader.readLine())!=null){ if(string.length()==8){
		 * System.out.println(string); bWriter.append(string);
		 * bWriter.newLine(); } } } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		/*
		 * System.out.println("字符转换: "+new
		 * String(("]_^[嬪]脣L$鰽").getBytes(),"gb2312")); int x=0; for(int
		 * i=0;i<0xf;++i){ x=x+i; }
		 */
		
		
		System.out.println("before gc --------------");
		System.out.println("空闲内存为:"+Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
		System.out.println("总内存为:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"MB");
		
		String inputString = "";
		StringBuilder help = new StringBuilder();
		help.append("this is a java-windows application!")
				.append("\r")
				.append("input shutdown will make the system power off in 60 seconds");
		while (!"exit".equals(inputString)) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			
			try {
				inputString = in.readLine();
				Runnable thread=new Runnable() {
					
					@Override
					public void run() {
						xxx=System.currentTimeMillis();
						System.out.println("process begin:"+xxx);
					}
				};
				thread.run();
				String[] string = { "cmd", "/c", inputString };

				StringBuffer proString = new StringBuffer();
				StringBuffer proString1 = new StringBuffer();
				Process process = Runtime.getRuntime().exec(string);
				InputStream inStream = process.getInputStream();
				InputStream errorStream = process.getErrorStream();
				BufferedReader bReader = new BufferedReader(
						new InputStreamReader(inStream, "gb2312"));
				BufferedReader errorReader = new BufferedReader(
						new InputStreamReader(errorStream, "gb2312"));
				int ch;
				
				while ((ch = bReader.read()) != -1) {
					proString.append((char) ch);

				}

				while ((ch = errorReader.read()) != -1) {
					proString1.append((char) ch);
				}
				/*
				 * if(errorReader.ready()){ proString=errorReader.readLine(); }
				 */
				System.out.println(proString.length() > 9 ? proString
						: proString1);
				/*
				 * ProcessBuilder processBuilder=new ProcessBuilder(string);
				 * processBuilder.start();
				 */
				
				
				Runnable thread1=new Runnable() {
					
					@Override
					public void run() {
						yyy=System.currentTimeMillis();
						System.out.println("process end:"+yyy);
						
					}
				};
				thread1.run();
				
				System.out.println("use total time is "+(yyy-xxx)+"ms");
				System.out.println("at gc --------------");
				System.out.println("空闲内存为:"+Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
				System.out.println("总内存为:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"MB");
				if(Runtime.getRuntime().freeMemory()/(1024*1024)<14)
					{Runtime.getRuntime().gc();
				System.out.println("at gc --------------");
				System.out.println("空闲内存为:"+Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
				System.out.println("总内存为:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"MB");}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("after gc --------------");
		System.out.println("空闲内存为:"+Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
		System.out.println("总内存为:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"MB");
	}
	// System.out.println(x);
}
