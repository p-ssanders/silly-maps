#   Silly Maps

This repository demonstrates what happens when Java `Map`s are instantiated with various key implementations, most of
which are silly and should probably never be used.

Review the [tests](app/src/test/java/dev/samsanders/demo/sillymaps/SillyMapTests.java) and corresponding key
implementations to see how map behavior changes.

*   `StableMapKey` -- this map key is "stable" meaning it will always `get` you back what you `put` and will allow the
    map to have generally expected performance characteristics (i.e.: O(1) lookup). Not silly.
    
*   `AlwaysCollideMapKey` -- this silly map key generally works fine, but will cause collisions on every `put` resulting
    in O(n) `get`s.

*   `SingleEntryMapKey` -- this silly map key causes a `Map` to behave like it can only support one entry. Each `put`
    will overwrite the existing entry.
    
*   `CantFindAnythingMapKey` -- this silly map key will cause the map to appear like it loses all its entries because
    it will cause `get`s to return `null`. The entries are there, however. Lookup is O(1) I guess, but you won't ever
    get the value you're looking for, even if you have a reference to the exact key instance that was `put`.
    
*   `UnstableMapKey` -- this silly map key seems OK, until you realize that it's mutable. If the key mutates after it's
    used to `put` you won't be able to find the corresponding entry anymore.
    
##  Test

```shell
./gradlew test
```