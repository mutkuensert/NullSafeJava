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