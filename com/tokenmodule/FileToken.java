package com.tokenmodule;

import java.util.StringTokenizer;

public class FileToken {
	static int count = 0;

	public static int calculateToken(String str) {
		int count = new StringTokenizer(str, " ").countTokens();
		return count;
	}

}
