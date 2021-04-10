package dev.samsanders.demo.sillymaps;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SillyMapTests {

    @Test
    void stableMapKey() {
        Map<StableMapKey, String> map = new HashMap<>();
        map.put(new StableMapKey(1), "test-1");
        map.put(new StableMapKey(2), "test-2");
        map.put(new StableMapKey(3), "test-3");
        StableMapKey.EQUALS_INVOCATIONS = 0;

        assertEquals(map.get(new StableMapKey(1)), "test-1");
        assertEquals(map.get(new StableMapKey(2)), "test-2");
        assertEquals(map.get(new StableMapKey(3)), "test-3");
        assertEquals(StableMapKey.EQUALS_INVOCATIONS, 3);
    }

    @Test
    void alwaysCollideMapKey() {
        Map<AlwaysCollideMapKey, String> map = new HashMap<>();
        map.put(new AlwaysCollideMapKey(1), "test-1");
        map.put(new AlwaysCollideMapKey(2), "test-2");
        map.put(new AlwaysCollideMapKey(3), "test-3");
        AlwaysCollideMapKey.EQUALS_INVOCATIONS = 0;

        assertEquals(map.get(new AlwaysCollideMapKey(1)), "test-1");
        assertEquals(map.get(new AlwaysCollideMapKey(2)), "test-2");
        assertEquals(map.get(new AlwaysCollideMapKey(3)), "test-3");
        assertEquals(AlwaysCollideMapKey.EQUALS_INVOCATIONS, 1+2+3);
    }

    @Test
    void singleBucketMapKey() {
        Map<SingleEntryMapKey, String> map = new HashMap<>();
        map.put(new SingleEntryMapKey(1), "test-1");
        map.put(new SingleEntryMapKey(2), "test-2");
        map.put(new SingleEntryMapKey(3), "test-3");

        assertEquals(map.get(new SingleEntryMapKey(1)), "test-3");
        assertEquals(map.get(new SingleEntryMapKey(2)), "test-3");
        assertEquals(map.get(new SingleEntryMapKey(3)), "test-3");
        assertEquals(map.size(), 1);
    }

    @Test
    void cantFindAnyElementKey() {
        Map<CantFindAnythingMapKey, String> map = new HashMap<>();
        map.put(new CantFindAnythingMapKey(1), "test-1");
        map.put(new CantFindAnythingMapKey(2), "test-2");
        map.put(new CantFindAnythingMapKey(3), "test-3");

        assertNull(map.get(new CantFindAnythingMapKey(1)));
        assertNull(map.get(new CantFindAnythingMapKey(2)));
        assertNull(map.get(new CantFindAnythingMapKey(3)));
        assertEquals(map.size(), 3);
    }

    @Test
    void cantFindAnyElementKey_even_by_exact_reference() {
        Map<CantFindAnythingMapKey, String> map = new HashMap<>();
        CantFindAnythingMapKey key = new CantFindAnythingMapKey(1);
        map.put(key, "test-1");

        assertNull(map.get(key));
    }

    @Test
    void unstableMapKey() {
        Map<UnstableMapKey, String> map = new HashMap<>();
        UnstableMapKey unstableMapKey = new UnstableMapKey(1, new Date(11));
        map.put(unstableMapKey, "test-1");
        unstableMapKey.getSomeDate().setTime(222);

        assertNull(map.get(unstableMapKey));
    }

}
