package encryptdecrypt;

public class EncryptShiftAlgorithm implements Algorithm{
    public String execute(String data, int key) {
        StringBuilder resultCipher = new StringBuilder();
        char startLetter;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isAlphabetic(c)) {
                startLetter = (Character.isUpperCase(c)) ? 'A' : 'a';
                resultCipher.append((char) (startLetter + (c - startLetter + key) % 26));
            } else {
                resultCipher.append(c);
            }
        }
        return resultCipher.toString();
    }
}
