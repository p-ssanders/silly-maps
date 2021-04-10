package dev.samsanders.demo.sillymaps;

public class AlwaysCollideMapKey {
    public static int EQUALS_INVOCATIONS = 0;
    private final int someInt;

    public AlwaysCollideMapKey(int someInt) {
        this.someInt = someInt;
    }

    public int getSomeInt() {
        return someInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlwaysCollideMapKey that = (AlwaysCollideMapKey) o;

        EQUALS_INVOCATIONS++;

        return getSomeInt() == that.getSomeInt();
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
