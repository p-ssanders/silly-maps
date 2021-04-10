package dev.samsanders.demo.sillymaps;

public class SingleEntryMapKey {

    private final int someInt;

    public SingleEntryMapKey(int someInt) {
        this.someInt = someInt;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
