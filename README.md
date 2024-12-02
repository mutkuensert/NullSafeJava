# NullSafeJava
A helper object to prevent NullPointerExceptions in Java

#### Java

```Java
import java.util.function.Supplier;

public class NullSafe {

    /**
     * Prevents NullPointerException
     */
    public static <T> T get(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
```

#### Kotlin

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

## Usage in Java
```Java
NullSafe.get(() -> getSomeObj().getProperty());
```

If **getSomeObj** method returns null, instead of occurence of a NullPointerException, NullSafe::get will return null.
