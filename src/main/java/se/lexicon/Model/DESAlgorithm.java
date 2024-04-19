package se.lexicon.Model;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DESAlgorithm implements EncryptionAlgorithm {
    private Cipher cipher;

    public DESAlgorithm() {
        try {
            this.cipher = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            System.err.println("Error during cipher initialization: " + e.getMessage());
        }
    }

    @Override
    public byte[] encrypt(byte[] data, byte[] key) {
        try {
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data);
            return encryptedData;
        } catch (InvalidKeyException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            System.err.println("Error during encryption: " + e.getMessage());
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            System.err.println("Error during cipher operation: " + e.getMessage());
        }
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] data, byte[] key) {
        try {
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(data);
            return decryptedData;
        } catch (InvalidKeyException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            System.err.println("Error during encryption: " + e.getMessage());
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            System.err.println("Error during cipher operation: " + e.getMessage());
        }
        return new byte[0];
    }
}
