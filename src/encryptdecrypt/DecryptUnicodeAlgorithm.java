package encryptdecrypt;

public class DecryptUnicodeAlgorithm implements Algorithm {
    /**
     * Decode the current char by shifting it by the key using unicode table
     *
     * @param data The original message to be decoded.
     * @param key  The key to decode the message.
     * @return The decoded message as a String.
     */
    public String execute(String data, int key) {
        StringBuilder resultCipher = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            resultCipher.append((char) (data.charAt(i) - key));
        }
        return resultCipher.toString();
    }
}
