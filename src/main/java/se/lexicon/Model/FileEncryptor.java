package se.lexicon.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEncryptor {
    private EncryptionAlgorithm encryptAlgorithm;
    private byte[] key; // Define key variable

    public static byte[] readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    public String encryptFile(String inputFile, String outputFile){
       try {
           byte[] data = FileUtils.readFile(inputFile);
           byte[] encryptedData = encryptAlgorithm.encrypt(data, key);
           FileUtils.writeFile(outputFile, encryptedData);
           return "Encryption successful"; // Add return statement
       } catch (IOException e){
           return "Encryption failed"; // Add return statement
       }
    }

    public String decryptFile(String inputFile, String outputFile){
        try {
            byte[] data = FileUtils.readFile(inputFile);
            byte[] decryptedData = encryptAlgorithm.decrypt(data, key);
            FileUtils.writeFile(outputFile,decryptedData);
            return "Decryption successful"; // Add return statement
        } catch (IOException e){
            return "Decryption failed"; // Add return statement
        }
    }
}