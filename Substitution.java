// Tingyi Yan
// CSE 123 AL
// TA: Andras Marto
// C0: Ciphers
// This class represents a substitution encryption/decryption scheme. This Cipher 
// works by "hiding" the original message at variable locations in the encrypted message.
// This class extends Cipher
import java.util.*;

public class Substitution extends Cipher{
    private String shifter;
    

    /*
     * Constructs a new Substitution. 
     * Parameters:
     *          - none
     * Returns:
     *          - none 
     */
    public Substitution(){
        this.shifter = null;
    }

    /*Constructs a new Substitution instance with the specified shifter.
     * Parameters:
     *          - shifter: a String representing the shifter for the substitution cipher
     * Returns:
     *          - none 
     * Throws:
     IllegalArgumentException if the length of the shifter doesn't match the encodable range,
     if any character in the shifter is out of the encodable range, 
     or if the shifter has repeating characters.
    */
    public Substitution(String shifter){
        setShifter(shifter);
    }

    /*
     * Sets the shifter for the substitution cipher.
     * Parameters:
     *          - shifter: a String representing the shifter for the substitution cipher
     * Returns:
     *          - none 
     * Throws:
     IllegalArgumentException if the length of the shifter doesn't match the encodable range,
     if any character in the shifter is out of the encodable range, 
     or if the shifter has repeating characters.
     */
    public void setShifter(String shifter){
        if(shifter.length() != TOTAL_CHARS){
            throw new IllegalArgumentException("Shifter length must match the encodable range.");
        }
        char test = ' ';
        for (int i = 0; i < shifter.length(); i++){
            if ((int)shifter.charAt(i) < MIN_CHAR || (int)shifter.charAt(i) > MAX_CHAR){
                throw new IllegalArgumentException("Shifter has chars out of the encodable range");
            }
            if(shifter.charAt(i) == test){
                throw new IllegalArgumentException("Shifter has repeating chars");
            }
            test = shifter.charAt(i);
        }
        this.shifter = shifter;
    }

    /*
     * Encrypts the input string using the substitution cipher.
     * Parameters:
     *          - input: a String representing the message to be encrypted
     * Returns:
     *          - a String representing the encrypted message
     * Throws:
     *          - IllegalStateException if the shifter has not been set before encryption
     */
    public String encrypt(String input){
        String result = "";
        if(this.shifter == null){
            throw new IllegalStateException("shifter should be set before encryption");
        }
        for (int i = 0; i < input.length(); i++) {
            result += shifter.charAt((int)input.charAt(i) - MIN_CHAR);
        }
        return result;
    }

    /*
     * Decrypts the input string using the substitution cipher.
     * Parameters:
     *          - input: a String representing the encrypted message
     * Returns:
     *          - a String representing the decrypted message
     * Throws:
     *          - IllegalStateException if the shifter has not been set before decryption
     */
    public String decrypt(String input){
        String result = "";
        if(this.shifter == null){
            throw new IllegalStateException("shifter should be set before decryption");
        }
        for (int i = 0; i < input.length(); i++) {
            for(int j = 0; j < this.shifter.length(); j++){
                if(this.shifter.charAt(j) == input.charAt(i)){
                    result += (char) (j + MIN_CHAR);
                }
            }
        }
        return result;
    }
}
