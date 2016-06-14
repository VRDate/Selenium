import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;

/**
 * YUAN
 * 6/14/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://search.333job.com/");
        InputStream is = url.openStream();
        LineNumberReader lnr = new LineNumberReader(new InputStreamReader(is));
        String line;
        while ((line = lnr.readLine()) != null) {
            System.out.println(line);
        }
        is.close();
    }

}
