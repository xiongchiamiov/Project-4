// This appears in Core Web Programming from
// Prentice Hall Publishers, and may be freely used
// or adapted. 1997 Marty Hall, hall@apl.jhu.edu.

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CgiShow {
  public static void main(String[] args) {
    CgiShow app = new CgiShow("CgiShow", args, "TEST");
    app.printHeaders();
  }

  protected String name;
  protected String[] args;
  protected String type;

  public CgiShow(String name, String[] args,
		 String type) {
    this.name = name;
    this.args = args;
    this.type = type;
  }

  protected void printHeaders() {
    final PrintStream stdout = new PrintStream(System.out);
    ByteArrayOutputStream capturedOutputStream = new ByteArrayOutputStream();
    PrintStream s = new PrintStream(capturedOutputStream);
    System.setOut(s);

    printHeader();
    printBody(args);
    printTrailer();

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
    System.out.println(response
    );
  }

  protected void printHeader() {
    System.out.println
      ("<!DOCTYPE HTML PUBLIC " +
         "\"-//W3C//DTD HTML 3.2//EN\">\n" +
       "<HTML>\n" +
       "<HEAD>\n" +
       "<TITLE>The " + name + " Program</TITLE>\n" +
       "<STYLE>\n" +
       "<!--");
    printStyleRules();
    System.out.println
      ("-->\n" +
       "</STYLE>\n" +
       "</HEAD>\n" +
       "\n" +
       "<BODY>\n" +
       "<H1>The <CODE>" + name + "</CODE> Program" +
       "</H1>");
  }

  protected void printStyleRules() {
    System.out.println
      ("H1 { text-align: center;\n" +
       "     font-family: Arial, sans-serif }");
  }
  
  protected void printBody(String[] data) {
    System.out.println("(Generic CgiShow)");
  }

  protected void printTrailer() {
    System.out.println("</BODY>\n</HTML>");
  }
}
