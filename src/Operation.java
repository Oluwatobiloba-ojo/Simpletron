public enum Operation {
    READ(10),
    WRITE(11);
    private final int value;

    Operation(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
