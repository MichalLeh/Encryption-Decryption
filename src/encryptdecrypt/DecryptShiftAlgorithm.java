package encryptdecrypt;

public class DecryptShiftAlgorithm implements Algorithm{
    public String execute(String data, int key) {
        StringBuilder resultCipher = new StringBuilder();
        char endLetter;

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isAlphabetic(c)) {
                endLetter = (Character.isUpperCase(c)) ? 'Z' : 'z';
                resultCipher.append((char) (endLetter - (endLetter - c + key) % 26));
            } else {
                resultCipher.append(c);
            }
        }
        return resultCipher.toString();
    }
}
