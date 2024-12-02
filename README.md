# SafeCallJava
A simple class to prevent NullPointerExceptions in Java

#### Java

```Java
import java.util.function.Supplier;

public class SafeCall {

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
object SafeCall {

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
SafeCall.get(() -> getSomeObj().getProperty());
```

If **getSomeObj** method returns null, instead of occurence of a NullPointerException, SafeCall::get will return null.
