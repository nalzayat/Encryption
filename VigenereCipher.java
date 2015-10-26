public class VigenereCipher extends SymmetricCipher{
  // The password, used to generate shift values
  protected String password;
  // Records the current location in a String that is being crypted
  protected int passwordPos;
  
  // The constructor initializes the data members. This includes 
  // the data member in the parent class SymmetricCipher
  public VigenereCipher(String password, Alphabet alphabet){
    super(alphabet);
    this.password = password;
  }
  
  // The constructor initializes the data members. 
  // This includes the data member in the parent class SymmetricCipher, which is initialized to the DEFAULT Alphabet
  public VigenereCipher(String password){
    super(Alphabet.DEFAULT);
    this.password = password;   
  }
  
  // Returns password
  public String getPassword(){
    return password;
  }
  
  // Relies upon password and passwordPos to encrypt a single char
  protected char encrypt1(char c){
    // If password position is greater or equal to password length 
    if(passwordPos >= password.length()){
      passwordPos = 0;
    }
    // Variable c is the index of character c in alphabet
    int indexC = alphabet.indexOf(c);
    // indexPasswordPos is the character at the position applied to
    // index of that character in the alphabet 
    int indexPasswordPos = alphabet.indexOf(password.charAt(passwordPos));
    int totalIndex = rotate(indexC ,indexPasswordPos);
    // If the password pos is less than the password length
    if(passwordPos < password.length()){
      passwordPos ++;
    }
    return alphabet.get(totalIndex);
  }
  
  // Relies upon password and passwordPos to decrypt a single char
  protected char decrypt1(char c){
    if(passwordPos >= password.length()){
      passwordPos = 0;
    }
    int indexC = alphabet.indexOf(c);
    int indexPasswordPos = alphabet.indexOf(password.charAt(passwordPos));
    int totalIndex = rotate(indexC ,indexPasswordPos * -1);
    if(passwordPos < password.length()){
      passwordPos ++;
    }
    return alphabet.get(totalIndex);
  }
  
  
  public String encrypt(String s){
    passwordPos = 0;
    return super.encrypt(s);
  }
  
  public String decrypt(String s){
    passwordPos = 0;
    return super.decrypt(s);
  }
  
  // Return a string representation of the cipher in the following format
  public String toString(){
    return String.format("Vigenere Cipher (password='%s')", password);
  }
}