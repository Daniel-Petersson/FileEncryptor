package se.lexicon;

import org.junit.jupiter.api.Test;
import se.lexicon.Model.DESAlgorithm;

import static org.junit.jupiter.api.Assertions.*;

public class DESAlgorithmTest {

    @Test
    public void encryptAndDecrypt_ShouldReturnOriginalData_WhenGivenValidKeyAndData() {
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        byte[] key = "12345678".getBytes();
        byte[] data = "Testdata".getBytes();

        byte[] encryptedData = desAlgorithm.encrypt(data, key);
        byte[] decryptedData = desAlgorithm.decrypt(encryptedData, key);

        assertArrayEquals(data, decryptedData);
    }

    @Test
    public void encrypt_ShouldReturnEmptyArray_WhenGivenInvalidKey() {
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        byte[] key = "invalid".getBytes();
        byte[] data = "Testdata".getBytes();

        byte[] encryptedData = desAlgorithm.encrypt(data, key);

        assertArrayEquals(new byte[0], encryptedData);
    }

    @Test
    public void decrypt_ShouldReturnEmptyArray_WhenGivenInvalidKey() {
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        byte[] key = "12345678".getBytes();
        byte[] invalidKey = "invalid".getBytes();
        byte[] data = "Testdata".getBytes();

        byte[] encryptedData = desAlgorithm.encrypt(data, key);
        byte[] decryptedData = desAlgorithm.decrypt(encryptedData, invalidKey);

        assertArrayEquals(new byte[0], decryptedData);
    }

    @Test
    public void encryptAndDecrypt_ShouldReturnEmptyArray_WhenGivenEmptyData() {
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        byte[] key = "12345678".getBytes();
        byte[] data = new byte[0];

        byte[] encryptedData = desAlgorithm.encrypt(data, key);
        byte[] decryptedData = desAlgorithm.decrypt(encryptedData, key);

        assertArrayEquals(new byte[0], decryptedData);
    }
}