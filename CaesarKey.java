// Tingyi Yan
// CSE 123 AL
// TA: Andras Marto
// C0: Ciphers
// This class provides functionality to encrypt and decrypt messages using the Caesar Cipher
// with a specified key.
import java.util.*;
/**
     * Constructor for the CaesarKey class.
     * Initializes a new CaesarKey object with the specified key.
     * 
     * param-  key The key to use for the Caesar Cipher.
     * throws IllegalArgumentException if the key is null or empty.
     */

public class CaesarKey extends Substitution{

    public CaesarKey(String key){
        super();
        if(key == null || key.isEmpty()){
            throw new IllegalArgumentException("key can't be empty");
        }
        for (int j = MIN_CHAR; j < MAX_CHAR; j++){
            for(int i = 0; i < key.length(); i++){
                if((int)key.charAt(i) != j){
                  key += (char) j;
                }
            }
        }
        super.setShifter(key);
    }
}
