import java.util.Scanner;

public class Simpletron {

    private String[] memory = new String[100];
    private String accumulator = "+0000";
    private int currentMemoryPosition = 0;

    public void checkOperation(String word){
        int operationCode = Integer.parseInt(word.substring(1, 3));
        int memoryLocation = Integer.parseInt(word.substring(3));

        if (operationCode == Operation.READ.getValue()){
            read(memoryLocation);
        } else if (operationCode == Operation.WRITE.getValue()) {
            write(memoryLocation);
        } else if (operationCode == Operation.LOAD.getValue()) {
            load(memoryLocation);
        } else if (operationCode == Operation.ADD.getValue()) {
            add(memoryLocation);
        }

    }

    private void add(int memoryLocation) {
        String wordInMemory = this.memory[memoryLocation];
        int sum = Integer.parseInt(this.accumulator) + Integer.parseInt(wordInMemory);

        String word = String.valueOf(sum);
        if(word.charAt(0) != '-'){
            word = "+" + word;
        }

        int wordLength = word.length();

        if(wordLength < 5){
            word = padWordWithZeros(word);
        } else if (wordLength > 5) {
            word = word.substring(0, 5);
        }

        this.accumulator = word;
    }

    private void load(int memoryLocation) {
        String word = this.memory[memoryLocation];
        this.accumulator = word;
    }

    private void write(int memoryLocation) {
        String word = this.memory[memoryLocation];
        System.out.println(word);
    }

    private void read(int memoryLocation) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!(input.charAt(0) == '+') && !(input.charAt(0) == '-')){
            input = "+" + input;
        }

        int inputLength = input.length();

        if(inputLength < 5){
            input = padWordWithZeros(input);
        } else if (inputLength > 5) {
            System.out.println("Input too long. Max: 4 digits");
            read(memoryLocation);
        }
        memory[memoryLocation] = input;
    }
    private String padWordWithZeros(String word){
        char operator = word.charAt(0);
        word = word.substring(1);
        int wordLength = word.length();

        while (wordLength != 4){
            word = "0" + word;
            wordLength = word.length();
        }

        word = operator + word;
        return word;
    }


}
