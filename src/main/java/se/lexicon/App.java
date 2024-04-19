package se.lexicon;

import se.lexicon.Model.AESAlgorithm;
import se.lexicon.Model.DESAlgorithm;
import se.lexicon.Model.FileEncryptor;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileEncryptor fileEncryptor = new FileEncryptor();
        fileEncryptor.setEncryptAlgorithm(new AESAlgorithm());
        fileEncryptor.setKey("1234567812345678".getBytes());

        String encryptionResult = fileEncryptor.encryptFile("FILEPATH", "FILEPATH");
        System.out.println(encryptionResult);

        String decryptionResult = fileEncryptor.decryptFile("FILEPATH", "FILEPATH");
        System.out.println(decryptionResult);


        //DES encryption
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        String desOriginalText = "Alvar";
        byte[] desOriginalBytes = desOriginalText.getBytes();
        byte[] desKey = "12345678".getBytes(); // DES requires an 8 byte key

        byte[] encryptedDES = desAlgorithm.encrypt(desOriginalBytes, desKey);
        byte[] decryptedDES = desAlgorithm.decrypt(encryptedDES, desKey);

        System.out.println("Original text: " + desOriginalText);
        System.out.println("Encrypted text: " + new String(encryptedDES));
        System.out.println("Decrypted text: " + new String(decryptedDES));

        //AES encryption
        AESAlgorithm aesAlgorithm = new AESAlgorithm();
        String aesOriginalText = "Hello, World!";
        byte[] aesOriginalBytes = aesOriginalText.getBytes();
        byte[] aesKey = "1234567891011121".getBytes(); //AES requires an 16 byte key

        byte[] encryptedAES = aesAlgorithm.encrypt(aesOriginalBytes,aesKey);
        byte[] decryptedAES = aesAlgorithm.decrypt(encryptedAES,aesKey);
        System.out.println("Original text: " + aesOriginalText);
        System.out.println("Encrypted text: " + new String(encryptedAES));
        System.out.println("Decrypted text: " + new String(decryptedAES));
    }
}

