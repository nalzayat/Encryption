public abstract class SymmetricCipher{
  // The alphabet that this cipher works on 
  protected Alphabet alphabet; 
  
  // The constructor initializes the data member 
  public SymmetricCipher(Alphabet alphabet){
    this.alphabet = alphabet;
  }
  
  // Given an index value that may be outside the range 
  // of valid indexes into the alphabet, wrap it back 
  // around to a valid index
  public int wrapInt(int i){
    // If int i is less than zero
    if(i < 0){
      // Return the length of get symbols on alphabet plus int i
      return (alphabet.getSymbols().length() + (i));
    }
    else{
      return i % (alphabet.length());
    }
  }
  
  // Given an index into the alphabet, rotate it around 
  // to the resulting valid index into alphabet
  public int rotate(int index, int shift){
    // Assigns zero to variable answer
    int answer = 0;
    // If index plus the shift are greater or equal to zero
    if(index + shift >= 0){
      // Answer equals the method wrapInt with parameter of index + shift
      answer = wrapInt(index + shift);
    }
    // If the index plus the shift is less than zero 
    else if(index + shift < 0){
      // The new index of the length of alphabet plus the shift and index module 
      // the length of alphabet
      int newIndex = alphabet.length() + ((index + shift) % alphabet.length() );
      answer = wrapInt(newIndex);
    }
   return answer; 
  }
  
  // Returns alphabet 
  public Alphabet getAlphabet(){
    return alphabet;
  }
  
  // Implement this method based upon the encrypt1 definition, 
  // which encrypts a single character (think of the Caesar 
  // Cipher for an understanding). Throws NotInAlphabetException 
  // if any character is found that isn't in the alphabet
  public String encrypt(String s) throws NotInAlphabetException{
    // Answer is empty string
    String stringAnswer = ("");
    for(int x = 0; x < s.length(); x++){
      // Character E is assigned as calling encrypt1 on string s character
      // at index x
      char charE= encrypt1(s.charAt(x));
      stringAnswer += charE;
    }
    return stringAnswer;
  }
  
 // Implement this method based upon the decrypt1 definition, 
 // which decrypts a single character (think of the Caesar Cipher 
 // for an understanding). Throws NotInAlphabetException if any 
 // character is found that isn't in the alphabet.
  public String decrypt(String s) throws NotInAlphabetException{
    String stringAnswer = ("");
    for(int x = 0; x < s.length(); x++){
      char charD = decrypt1(s.charAt(x));
      stringAnswer += charD;
    }
    return stringAnswer;
  }
  // Abstract methods
  protected abstract char encrypt1(char c);
  protected abstract char decrypt1(char c);
}