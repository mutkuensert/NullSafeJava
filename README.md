# NullSafeJava
A helper object to prevent NullPointerExceptions in Java

```kotlin
object NullSafe {

    /**
     * Prevents [NullPointerException] in java
     */
    @JvmStatic
    fun <T : Any> get(block: () -> T): T? {
        return try {
            block.invoke()
        } catch (e: NullPointerException) {
            null
        }
    }
}

```

## Usage
```Java
NullSafe.get(() -> getSomeObj().getProperty());
```

If **getSomeObj** method returns null, instead of occurence of a NullPointerException, NullSafe::get will return null.
