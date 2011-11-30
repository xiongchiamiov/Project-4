package babysfirst;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.Scanner;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class BabysFirst {
    private String method;
    private String url;
    private LinkedHashMap<Pattern, String> urlMapping;

    /*public final static void main(String[] args) {
        BabysFirst app = new BabysFirst(args);
        app.run();
    }*/

    public BabysFirst(String[] args, LinkedHashMap<Pattern, String> urlMapping) {
        this.method = args[0];
        this.url = args[1];
        this.urlMapping = urlMapping;
    }

    public final void run() {
        final PrintStream stdout = new PrintStream(System.out);
        ByteArrayOutputStream capturedOutputStream = new ByteArrayOutputStream();
        PrintStream s = new PrintStream(capturedOutputStream);
        System.setOut(s);
        
        String controller = this.mapURL(this.url);
        // Use reflection to call this method and print the output.
        
        System.setOut(stdout);
        final String capturedOutput = capturedOutputStream.toString();
        int contentLength = 0;
        try {
            contentLength = capturedOutput.getBytes("UTF-8").length;
        } catch (java.io.UnsupportedEncodingException e ) {}

        // http://tools.ietf.org/html/rfc2616
        String response = "HTTP/1.1 200 OK\n" + 
            "Cache-Control: private\n" + 
            "Content-Type: text/plain\n" + 
            "Server: bash/2.0\n" + 
            "Connection: Close\n" + 
            "Content-Length: " + contentLength + "\n" +
            "\n" +
            capturedOutput;
        System.out.println(response);
    }

    public final static String render_to_response(String filename, Hashtable<String, Object> values)
    {
        String templateText = "";
        try
        {
            templateText = new Scanner(new File(filename)).useDelimiter("\\A").next();
        }
        catch (java.io.FileNotFoundException e)
        {
            return "";
        }

        StringTemplate template = new StringTemplate(templateText);
        for (Map.Entry<String, Object> value : values.entrySet())
        {
            template.setAttribute("foo", "bar");
        }

        return template.toString();
    }

    private String mapURL(String url)
    {
        // Loop through this.urlMapping and return the string value for the
        // first key that matches url.
        return "";
    }
}

