// Tingyi Yan
// CSE 123 AL
// TA: Andras Marto
// C0: Ciphers
// This class provides functionality to encrypt and decrypt messages using a list of Cipher objects

import java.util.*;
public class MultiCipher extends Cipher{
    private List<Cipher> ciphers;

    /*
     * Constructor for the MultiCipher class.
     * Initializes a new MultiCipher object with the specified list of ciphers.
     * 
     * param- ciphers The list of Cipher objects to use for encryption and decryption.
     * throws- IllegalArgumentException if the list of ciphers is null.
     */
    public MultiCipher(List<Cipher> ciphers){
        if(ciphers == null){
            throw new IllegalArgumentException("cipher lists cannot be null");
        }
        this.ciphers = ciphers;
    }

    /*
     * Encrypts the input message using the list of ciphers.
     * 
     * param- input The message to encrypt.
     * returns- The encrypted message.
     */
    public String encrypt(String input) {
        String result = input;
        for (Cipher cipher : ciphers) {
            result = cipher.encrypt(result);
        }
        return result;
    }

    /*
     * Decrypts the input message using the list of ciphers in reverse order.
     * 
     * param- input The message to decrypt.
     * returns- The decrypted message.
     */
    public String decrypt(String input) {
        String result = input;
        // Decrypt in reverse order
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            result = ciphers.get(i).decrypt(result);
        }
        return result;
    }
} 
