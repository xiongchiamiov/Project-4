// This appears in Core Web Programming from
// Prentice Hall Publishers, and may be freely used
// or adapted. 1997 Marty Hall, hall@apl.jhu.edu.

public class CgiGet extends CgiShow {
  public static void main(String[] args) {
    CgiGet app = new CgiGet("CgiGet", args, "GET");
    app.printHeaders();
  }
      
  public CgiGet(String name, String[] args,
		String type) {
    super(name, args, type);
  }
  
  protected void printHeader() {
    super.printHeader();
    System.out.println
      ("This program illustrates CGI programs\n" +
       "in Java that receive <TT>" + type +
       "</TT> requests.\n" +
       "<P>");
  }

  protected void printBody(String[] data) {
    //System.out.println("Data was '" + data[0] + "'.");
    System.out.println("Data was:<br />");
    for (String arg : data) {
      System.out.println(arg + "<br />");
    }
  }
}
