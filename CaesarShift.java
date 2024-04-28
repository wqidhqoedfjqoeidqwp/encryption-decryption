// Tingyi Yan
// CSE 123 AL
// TA: Andras Marto
// C0: Ciphers
// This class provides functionality to encrypt and decrypt messages using the Caesar Shift cipher.

import java.util.*;
public class CaesarShift extends Substitution{

    /**
     * Constructor for the CaesarShift class.
     * Initializes a new CaesarShift object with the specified shift value.
     * 
     * param-
                shift The number of positions to shift each character in the alphabet.
     * throws IllegalArgumentException if the shift value is less than or equal to 0.
     */
    public CaesarShift(int shift){
        String key = "";
        Queue <Character> q = new LinkedList<>();
        if(shift <= 0) {
            throw new IllegalArgumentException("Shift value must be greater than 0.");
        }
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++){
            q.add((char)i);
        }
        for(int i = 0; i < shift; i++){
            char temp = q.remove();
            q.add(temp);
        }
        while(!q.isEmpty()){
            key += q.remove();
        }
        super.setShifter(key);
    }
    
}
