/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Internet {

    public static void parseListHTML(List<String> listFilePath, List<String> listUri) {
        Writer writer = null;
        boolean check = false;
        int count = 1;

        try {
            for (int i = 0; i < listUri.size(); i++) {
                count = 1;
                URL url = new URL(listUri.get(i).toString());
                URLConnection con = url.openConnection();
                con.addRequestProperty("User-agent", "Chrome/61.0.3163.100 (compatible; MSIE 6.0; Windows NT 5.0)");
                InputStream is = con.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String inputLine;
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(listFilePath.get(i).toString()), "UTF-8"));
                while((inputLine = in.readLine()) != null) {
                    count += 1;
                    if ((!inputLine.contains("script") && !inputLine.contains("noscript")
                            && !inputLine.contains("meta") && !inputLine.contains("--")
                            && !inputLine.contains("height=1") && !inputLine.contains("<input type=")
                            && !inputLine.contains("data-interval") && !inputLine.contains("nbsp")
                            && !inputLine.contains("footer") && !inputLine.contains("<link"))) {
                        writer.write(inputLine + "\n");
                    }
                    
                    if (inputLine.contains("</html>")) {
                        break;
                    }
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Internet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Internet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Internet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
