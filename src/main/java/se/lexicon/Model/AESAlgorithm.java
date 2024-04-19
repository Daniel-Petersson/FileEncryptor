package se.lexicon.Model;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class AESAlgorithm implements EncryptionAlgorithm {
    private Cipher cipher;

    public AESAlgorithm() {
        try {
            this.cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            System.err.println("Error during cipher initialization: " + e.getMessage());
        }
    }

    @Override
    public byte[] encrypt(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data);
            return encryptedData;
        } catch (InvalidKeyException e) {
            System.err.println("Invalid Key: " + e.getMessage());
        } catch (BadPaddingException e) {
            System.err.println("Bad Padding: " + e.getMessage());
        } catch (IllegalBlockSizeException e) {
            System.err.println("Illegal Block Size: " + e.getMessage());
        }
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(data);
            return decryptedData;
        } catch (InvalidKeyException e) {
            System.err.println("Invalid Key: " + e.getMessage());
        } catch (BadPaddingException e) {
            System.err.println("Bad Padding: " + e.getMessage());
        } catch (IllegalBlockSizeException e) {
            System.err.println("Illegal Block Size: " + e.getMessage());
        }
        return new byte[0];
    }
}
