public class NotInAlphabetException extends RuntimeException{
  // Fields / DATA members 
  // DATA encapsulated within a class
  public final String msg;
  public final char offender;
  public final Alphabet a; 
  
  // The constructor initializes the data members
  public NotInAlphabetException(String msg, char offender, Alphabet a){
    // Initializes msg, offender, and a 
    this.msg = msg;
    this.offender = offender;
    this.a = a; 
  }
  
  // The constructor initializes the data members 
  public NotInAlphabetException(char offender, Alphabet a){
    // Initializes offender and a
    this.offender = offender;
    this.a = a; 
    msg = String.format("Not in alphabet: '%s' not found in %s.", String.valueOf(offender), a.getSymbols());
  }
  
  // Returns msg
  public String toString(){
    return msg;
  }
}