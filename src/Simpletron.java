import java.util.Scanner;

public class Simpletron {

    private String[] memory = new String[100];
    private String accumulator = "+0000";
    private int currentMemoryPosition;

    public void checkOperation(String word){
        int operationCode = Integer.parseInt(word.substring(1, 3));
        int memoryLocation = Integer.parseInt(word.substring(3));

        if (operationCode == Operation.READ.getValue()){
            read(memoryLocation);
        } else if (operationCode == Operation.WRITE.getValue()) {
            write(memoryLocation);
        }

    }

    private void read(int memoryLocation) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!(input.charAt(0) == '+') && !(input.charAt(0) == '-')){
            input = "+" + input;
        }

        int inputLength = input.length();

        if(inputLength < 5){
            char operator = input.charAt(0);
            input = input.substring(1);
            inputLength = input.length();

            while (inputLength != 4){
                input = "0" + input;
                inputLength = input.length();
            }

            input = operator + input;
        }

        memory[memoryLocation] = input;
    }


}
