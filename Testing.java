import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assume.assumeTrue;
import java.util.*;

public class Testing {

    @Test
    @DisplayName("Substitution - 'A'-'Z' Shifter")
    public void substitutionCaseTest() {
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));
        Cipher testSubstitution = new Substitution(
            "ZYXWVUTSRQPONMLKJIHGFEDCBA"
        );
        assertEquals("UZW", testSubstitution.encrypt("FAD"));
        assertEquals("BAD", testSubstitution.decrypt("YZW"));
    }

    @Test
    @DisplayName("CaesarKey - 'A'-'Z' Shifter")
    public void caesarKeyCaseTest() {
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));
        Cipher testCaesarKey = new CaesarKey("DEFGH");
        assertEquals("FDG", testCaesarKey.encrypt("CAD"));
        assertEquals("CAD", testCaesarKey.decrypt("FDG"));
    }

    @Test
    @DisplayName("CaesarShift - 'A'-'Z' Shifter")
    public void caesarShiftCaseTest() {
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));
        Cipher testCaesarShift = new CaesarShift(3);
        assertEquals("FDG", testCaesarShift.encrypt("CAD"));
        assertEquals("CAD", testCaesarShift.decrypt("FDG"));
    }

    @Test
    @DisplayName("MultiCipher - 'A'-'Z' Shifter")
    public void multiCipherCaseTest() {
        assumeTrue(Cipher.MIN_CHAR == (int)('A') && Cipher.MAX_CHAR == (int)('Z'));
        List<Cipher> ciphers = new ArrayList<>();
        ciphers.add(new Substitution("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
        ciphers.add(new CaesarKey("DEFGH"));
        MultiCipher testMultiCipher = new MultiCipher(ciphers);

        assertEquals("FDG", testMultiCipher.encrypt("CAD"));
        assertEquals("CAD", testMultiCipher.decrypt("FDG"));
    }
}