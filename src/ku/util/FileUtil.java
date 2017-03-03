package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * FileUtil is a class which is used to copy one text file to another
 * text file by using different types of methods.
 * 
 * @author Sirasath Piyapootinun
 * @version 2017.03.03
 *
 */
public class FileUtil {
	
	/**
	 * Copies an InputStream file to an OutputStream file one byte 
	 * at a time.
	 * 
	 * @param in is the InputStream file to be copied.
	 * @param out is the OutputStream file to be copy to.
	 * @throws RuntimeException when it catches IOException.
	 */
	public static void copy (InputStream in, OutputStream out) {
		int count;
		try {
			while((count = in.read()) != -1){
				out.write(count);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				//ignore
			}
		}
	}
	
	/**
	 * Copies an InputStream file to an OutputStream file using a byte
	 * array of a specified size.
	 * 
	 * @param in is the InputStream file to be copied.
	 * @param out is the OutputStream file to be copy to.
	 * @param blocksize is the size of the file to be copied per time.
	 * @throws RuntimeException when it catches IOException.
	 */
	public static void copy(InputStream in, OutputStream out, int blocksize){
		byte[] buffer = new byte[blocksize];
		int length;
		try {
			while((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);	
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				//ignore
			}
		}
	}
	
	/**
	 * Copies file using BufferedReader to read the InputStream and
	 * the PrintWriter to write the OutputStream by reading and writing
	 * one line at a time.
	 * 
	 * @param in is the InputStream file to be copied.
	 * @param out is the OutputStream file to be copy to.
	 * @throws RuntimeException when it catches IOException.
	 */
	public static void bcopy(InputStream in, OutputStream out) {
		BufferedReader buffer = null;
		PrintWriter writer = null;
		try {
			buffer = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(out);
			String data;
			// String s = buffer.readLine();
			while ((data = buffer.readLine()) != null) {
				writer.println(data);
			}
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		} finally {
			if (writer != null)
				writer.close();
			if (buffer != null)
				try {
					buffer.close();
				} catch (IOException e) {
					//ignore
				}
		}
	}
	
	/**
	 * Copies file using BufferedReader to read the InputStream and it
	 * uses BufferedWriter to write the OutputStream with an array of char.
	 * It reads and write one char at a time.
	 * 
	 *  @param in is the InputStream file to copy.
	 *  @param out is the OutputStream file to be copy to.
	 *  @throws RuntimeException when it catches IOException.
	 */
	public static void bcopyChar(InputStream in, OutputStream out) {
		BufferedReader buffer = null;
		BufferedWriter writer = null;
		char[] c = new char[10000];
		try {
			buffer = new BufferedReader(new InputStreamReader(in));
			writer = new BufferedWriter(new OutputStreamWriter(out));
			int length;
			while((length = buffer.read(c)) != -1) {
				writer.write(c, 0, length);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			writer.close();
			buffer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
