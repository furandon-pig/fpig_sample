/* SimpleURLRequest.java */

import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SimpleURLRequest {

	StringBuffer buffer;

	SimpleURLRequest() {
		buffer = new StringBuffer();
	}

	public String getData(String url_str) {
		BufferedReader reader = null;
		try {
			URL url = new URL(url_str);
			String line;
			reader = new BufferedReader(
					new InputStreamReader(
						url.openStream()));

			buffer.setLength(0);	// clear the buffer.
			while ( (line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
		} catch (MalformedURLException mue) {
			System.err.println("MalformedURLException.");
			buffer.setLength(0);	// clear the buffer.
		} catch (Exception e) {
			e.printStackTrace();
			buffer.setLength(0);	// clear the buffer.
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	/*
	public static void main(String [] args) {
		SimpleURLRequest sur = new SimpleURLRequest();
		for (int i = 0; i < args.length; i++) {
			System.out.println(sur.getData(args[i]));
		}
	}
	*/
}
