package com.java7.programming;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.trade.type.Trade;

public class Java7Features {
	public static void main(String[] args) {
		stringInSwitch();
		autoCloseTryCatch();
	}

	void diamondNotRequired() {
		Map<String, List<Trade>> trades = new TreeMap<>();
		trades.put("Str", null);
		trades.keySet().iterator();
	}

	static void stringInSwitch() {
		String str = "Emulator";
		switch (str) {
		case "Emulator":
			System.out.println("Emulator");
		case "IUI":
			System.out.println("IUI");
			break;
		case "TUI":
			System.out.println("TUI");
			break;
		}
	}

	static void autoCloseTryCatch() {
		try (MYClass myc = new MYClass();) {
			myc.doSomething();
			if (true)
				throw new IOException();
			if (true)
				throw new MyException2("");
			throw new MyException("TEST");
		} catch (MyException | IOException e) {
			System.out.println("EXCEPTION");
		} finally {
			System.out.println("finally");
		}

	}

	static void onlyTry() {
		try (MYClass myc = new MYClass();) {
			myc.doSomething();
		}

		/*
		 * try { myc.doSomething(); }
		 */

	}

	static void newNIOClassess()
	{
		/*
		 * It was never easy to work seamlessly across operating systems or
		 * multi-file systems. There were methods such as delete or rename that
		 * behaved unexpected in most cases. Working with symbolic links was
		 * another issue. In an essence, the API needed an overhaul.
		 */
	}
	
	static void watchService(){
		
	}
	
	static void numericLiterals(){
		int i=001_001_001;
		int in=002;
	}

}

class MyException extends Exception {
	MyException(String str) {
		super(str);
	}
}

class MyException2 extends MyException {
	MyException2(String str) {
		super(str);
	}
}

class MYClass implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("close");
	}

	public void doSomething() {
		System.out.println("doSomething");
	}
}