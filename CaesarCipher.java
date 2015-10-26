public class CaesarCipher extends SymmetricCipher{
  // The shift that this cipher uses to adjust characters during 
  // encryption/decryption
  protected int shift; 
  
  // Encrypts and returns a single character based on the 
  // shift and the alphabet in use
  public char encrypt1(char c){
      // Initializes index char  with the index of character c in alphabet 
      int indexChar = alphabet.indexOf(c);
      // Initializes completeshift with calling the method rotate
      int completeShift = rotate(indexChar,shift);
      char newChar = alphabet.getSymbols().charAt(completeShift);
      return newChar;
    }
  
  // Decrypts and returns a single character based on the shift and the alphabet in use 
  public char decrypt1(char c){
    // Initializes indexChar with the index of character c
    int indexChar = alphabet.indexOf(c);
    // Initializes completeShift with calling the rotation on the two 
    // parameters
    int completeShift = rotate(indexChar,-1*shift);
    char newChar = alphabet.getSymbols().charAt(completeShift);
    return newChar;
  }
  
  // The constructor stores the shift and alphabet
  public CaesarCipher(int shift, Alphabet alphabet){
    super(alphabet);
    this.shift = shift;
  }
  
  // This constructor stores the shift and uses the 
  // default Alphabet found in Alphabet.DEFAULT
  public CaesarCipher(int shift){
    super(Alphabet.DEFAULT);
    this.shift = shift;   
  }
  
  // Shifts each character by the shift amount and 
  // returns the newly encoded string. Inherited implementation
  public String encrypt(String s){
    // Initializes the variables a and b as character
    char a;
    char b;
    // Initializes variable c as an empty string
    String c = ("");
    for(int x = 0; x < s.length(); x++){
      // Assigns the character at index x to a 
      a = s.charAt(x);
      // Assigns call of method encrypt1 with parameter a
      // to variable b 
      b = encrypt1(a);
      c += b;
    }
    return c;
  }
  
  // Shifts each character in the opposite direction by 
  // the shift amount, which will recover the original secret 
  // messag - Inherited implementation
  public String decrypt(String s){
    char a;
    char b;
    String c = ("");
    for(int x = 0; x < s.length(); x++){
      a = s.charAt(x);
      b = decrypt1(a);
      c += b;
    }
    return c;
  }
  
  // Return a string representation of the cipher in the following forma
  public String toString(){
    return String.format("Caesar Cipher (shift=%d)", shift);
  }
 
}