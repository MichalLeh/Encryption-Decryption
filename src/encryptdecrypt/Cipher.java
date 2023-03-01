package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {
     private String mode = "enc";
     private String data = "";
     private String in = "";
     private String out = "";
     private String alg = "shift";
     private int key = 0;
     private Algorithm algorithm;
     public Cipher(String[] args) {
         checkIfArgHasValue(args);
         setParameters(args);

         if (data.isEmpty() && !in.isEmpty()) {
             readDataFromFile();
         }

         setAlgorithm();
         getResult();
     }
     /**
     * Check if argument has a value
     */
     private void checkIfArgHasValue(String[] args){
        for (int i = 0; i < args.length - 1; i++){
            if (args[i].contains("-") && args[i + 1].contains("-")){
                System.out.println(args[i] + " has no value");
            }
        }
    }
     /**
     * Get the result of the en(de)cryption process
     */
    public void getResult(){
        String result = algorithm.execute(data, key);
        if (out.isEmpty()){
            System.out.println(result);
        } else {
            writeDataIntoFile(result);
        }
    }
     /**
     * Set an algorithm
     */
    private void setAlgorithm() {
        if (mode.equals("enc") && alg.equals("unicode")) {
            algorithm = new EncryptUnicodeAlgorithm();
        } else if (mode.equals("enc") && alg.equals("shift")) {
            algorithm = new EncryptShiftAlgorithm();
        } else if (mode.equals("dec") && alg.equals("unicode")) {
            algorithm = new DecryptUnicodeAlgorithm();
        } else if (mode.equals("dec") && alg.equals("shift")) {
            algorithm = new DecryptShiftAlgorithm();
        }
    }
     /**
     * Read data
     *
     * @return Data to be processed, otherwise throws an error
     */
    public String readDataFromFile() {
        File file = new File(in);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                data += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }
     /**
     * Write the content to a file.
     *
     * @param result The content to be written into the file.
     */
    public void writeDataIntoFile(String result) {
        File file = new File(out);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(result);
        } catch (IOException e) {
            System.out.printf("File not found");
        }
    }
     /**
     * Check and set parameters
     *
     * @param args Array of parameters to be processed
     */
    private void setParameters(String[] args){
        for (int i = 0; i < args.length - 1; i += 2) {
            if ("-mode".equals(args[i]) && ("enc".equals(args[i + 1]) || "dec".equals(args[i + 1]))) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            } else if ("-in".equals(args[i])) {
                in = args[i + 1];
            } else if ("-out".equals(args[i])) {
                out = args[i + 1];
            } else if ("-alg".equals(args[i]) && ("shift".equals(args[i + 1]) || "unicode".equals(args[i + 1]))) {
                alg = args[i + 1];
            }
        }
    }
}
