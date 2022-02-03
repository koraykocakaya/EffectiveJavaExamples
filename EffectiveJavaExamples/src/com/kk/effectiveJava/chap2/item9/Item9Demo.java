package com.kk.effectiveJava.chap2.item9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Try-finally yerine try with kullanmamizi onermektedir <br>
 * 1. Javada InputStream, SqlConnection gibi objelerin kullanimi tamamlandıktan sonra close() metodu ile kapatilmasi gerekmektedir <br>
 * 2. Bu onceden try finally bloguyla, finally icerisinde objenin close metodu cagrilarak yapilmaktaydi <br> 
 * 3. Java 7 ile gelen try blogu sayesinde artik AutoClosable olan objeler try with icinde kullanildiginda islem sonrasi kapatilabilmektedir <br>
 * 4. Finally karmasasina engellemek acisindan kullanimi saglikli olacaktir <br>
 * 5. try-finally'de iki yerde de exception firlatilabilir, ancak try-with icin tek exception ile cozulebilmektedir <br>
 * 
 * @author korayk
 *
 */
public class Item9Demo {

	private static final int BUFFER_SIZE = 100;
	
	public static void copyWithTryWith(String src, String dst) throws IOException {
		try(InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dst);	){
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		}
	}

	public static void copyWithoutTryWith(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while ((n = in.read(buf)) >= 0)
					out.write(buf, 0, n);
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}
}
