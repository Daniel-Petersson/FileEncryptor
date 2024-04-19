package se.lexicon;

import org.junit.jupiter.api.Test;
import se.lexicon.Model.AESAlgorithm;

import static org.junit.jupiter.api.Assertions.*;

public class AESAlgorithmTest {

    @Test
    public void encryptAndDecrypt_ShouldReturnOriginalData_WhenGivenValidKeyAndData() {
        AESAlgorithm aesAlgorithm = new AESAlgorithm();
        byte[] key = "1234567812345678".getBytes();
        byte[] data = "Testdata".getBytes();

        byte[] encryptedData = aesAlgorithm.encrypt(data, key);
        byte[] decryptedData = aesAlgorithm.decrypt(encryptedData, key);

        assertArrayEquals(data, decryptedData);
    }

    @Test
    public void encrypt_ShouldReturnEmptyArray_WhenGivenInvalidKey() {
        AESAlgorithm aesAlgorithm = new AESAlgorithm();
        byte[] key = "invalid".getBytes();
        byte[] data = "Testdata".getBytes();

        byte[] encryptedData = aesAlgorithm.encrypt(data, key);

        assertArrayEquals(new byte[0], encryptedData);
    }

    @Test
    public void decrypt_ShouldReturnEmptyArray_WhenGivenInvalidKey() {
        AESAlgorithm aesAlgorithm = new AESAlgorithm();
        byte[] key = "1234567812345678".getBytes();
        byte[] invalidKey = "invalid".getBytes();
        byte[] data = "Testdata".getBytes();

        byte[] encryptedData = aesAlgorithm.encrypt(data, key);
        byte[] decryptedData = aesAlgorithm.decrypt(encryptedData, invalidKey);

        assertArrayEquals(new byte[0], decryptedData);
    }

    @Test
    public void encryptAndDecrypt_ShouldReturnEmptyArray_WhenGivenEmptyData() {
        AESAlgorithm aesAlgorithm = new AESAlgorithm();
        byte[] key = "1234567812345678".getBytes();
        byte[] data = new byte[0];

        byte[] encryptedData = aesAlgorithm.encrypt(data, key);
        byte[] decryptedData = aesAlgorithm.decrypt(encryptedData, key);

        assertArrayEquals(new byte[0], decryptedData);
    }
}