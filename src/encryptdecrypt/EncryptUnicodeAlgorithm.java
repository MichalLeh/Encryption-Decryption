package encryptdecrypt;

public class EncryptUnicodeAlgorithm implements Algorithm {
    /**
     * Encode the current char by shifting it by the key using unicode table
     *
     * @param data Data to be encoded
     * @param key  Key to encode the message
     * @return The encoded data as a String
     */
    public String execute(String data, int key) {
        StringBuilder resultCipher = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            resultCipher.append((char) (data.charAt(i) + key));
        }
        return resultCipher.toString();
    }
}
