public class Alphabet {
  // Fields / DATA members 
  // DATA encapsulated within a class 
  private String symbols;
  public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890!@#$%^&*()_+-=[]{}\\|;:'\",./?<>");
  
  // Constructor method initializes symbols 
  public Alphabet (String symbols){
    // Initializes symbols 
    this.symbols = symbols;
  }
  
  // Returns the index of char parameter c in string symbols 
  public int indexOf(char c){
    // For loops through symbols
    for(int x = 0; x < symbols.length(); x++){
      // Checks the character at index x and if it is 
      // equal to character c 
      if(symbols.charAt(x) == c){
        return(x);
      }
    }
    // Throws exception
    throw new NotInAlphabetException(c, this);
  }
  
  // Returns the char at position i of symbols 
  public char get(int i){
    // If the length of symbol is less than the variable i
    // and variable i is greater than zero
    if( (symbols.length() > i) && (i >= 0) ){
      return symbols.charAt(i);
    }
    else{
      throw new NotInAlphabetException('a', this);
    } 
  }
  
  // Returns the length of string symbols 
  public int length(){
    return symbols.length();
  }
  
  // Returns symbols 
  public String getSymbols(){
  return symbols;
  }
  
  // String representation 
  public String toString(){
    return String.format("Alphabet(%s)" , symbols);
  }
  
  // Returns true if the other is another alphabet and has the 
  // same characters and ordering as this alphabet 
  public boolean equals(Object other){
    if(this.getClass() == other.getClass()){
       Alphabet aOther = (Alphabet)other;
      if(this.symbols.equals(aOther.symbols)){
        return true;  
      }
    }
    return false;  
  }
}