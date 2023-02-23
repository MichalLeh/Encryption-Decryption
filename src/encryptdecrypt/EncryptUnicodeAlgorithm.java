package encryptdecrypt;

public class EncryptUnicodeAlgorithm implements Algorithm{
    public String execute(String data, int key) {
        StringBuilder resultCipher = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            resultCipher.append((char) (data.charAt(i) + key));
        }
        return resultCipher.toString();
    }
}
