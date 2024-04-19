package se.lexicon.Model;

public interface EncryptionAlgorithm {
    byte[] encrypt(byte[] data, byte[] key);
    byte[] decrypt(byte[] data, byte[] key);
}
