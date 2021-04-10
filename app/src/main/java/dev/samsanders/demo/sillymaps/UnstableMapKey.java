package dev.samsanders.demo.sillymaps;

import java.util.Date;
import java.util.Objects;

public class UnstableMapKey {

    private final int someInt;
    private final Date someDate;

    public UnstableMapKey(int someInt, Date someDate) {
        this.someInt = someInt;
        this.someDate = someDate;
    }

    public int getSomeInt() {
        return someInt;
    }

    public Date getSomeDate() {
        return someDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnstableMapKey that = (UnstableMapKey) o;
        return getSomeInt() == that.getSomeInt() && Objects.equals(getSomeDate(), that.getSomeDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSomeInt(), getSomeDate());
    }
}
