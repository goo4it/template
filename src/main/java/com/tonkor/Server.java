package com.tonkor;

import com.jfinal.core.JFinal;

public class Server {
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8088, "/", 0);
	}
}
