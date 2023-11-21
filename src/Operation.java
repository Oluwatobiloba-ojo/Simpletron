public enum Operation {
    READ(10),
    WRITE(11),
    LOAD(20),
    ADD(30);
    private final int value;

    Operation(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
