package dev.samsanders.demo.sillymaps;

import java.util.Objects;
import java.util.UUID;

public class CantFindAnythingMapKey {
    private final int someInt;

    public CantFindAnythingMapKey(int someInt) {
        this.someInt = someInt;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID.randomUUID());
    }
}
