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
    {  /*
    Encryptfile
    //Todo: Create method
    try {
        // Läs filen som en byte array
        byte[] fileData = Files.readAllBytes(Paths.get("/home/daniel/Documents/Js odin.odt"));

        // Skapa en ny instans av DESAlgorithm
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        byte[] key = "12345678".getBytes(); // DES requires an 8 byte key

        // Kryptera fildata
        byte[] encryptedData = desAlgorithm.encrypt(fileData, key);

        // Skriv den krypterade datan till en ny fil
        Files.write(Paths.get("/home/daniel/Documents/encrypted.odt"), encryptedData);
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
    */
        //Todo: Create method
        //decryptFile
        try {
            // Read the encrypted file as a byte array
            byte[] encryptedData = Files.readAllBytes(Paths.get("/home/daniel/Documents/encrypted.odt"));

            // Create a new instance of DESAlgorithm
            DESAlgorithm desAlgorithm = new DESAlgorithm();
            byte[] key = "12345678".getBytes(); // DES requires an 8 byte key

            // Decrypt the file data
            byte[] decryptedData = desAlgorithm.decrypt(encryptedData, key);

            // Write the decrypted data to a new file
            Files.write(Paths.get("/home/daniel/Documents/decrypted.odt"), decryptedData);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


        //DES encryption
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        String desOriginalText = "Hello, World!";
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

