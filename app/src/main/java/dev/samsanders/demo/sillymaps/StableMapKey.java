package dev.samsanders.demo.sillymaps;

import java.util.Objects;

public class StableMapKey {
    public static int EQUALS_INVOCATIONS = 0;
    private final int someInt;

    public StableMapKey(int someInt) {
        this.someInt = someInt;
    }

    public int getSomeInt() {
        return someInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StableMapKey that = (StableMapKey) o;

        EQUALS_INVOCATIONS++;

        return getSomeInt() == that.getSomeInt();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSomeInt());
    }
}
