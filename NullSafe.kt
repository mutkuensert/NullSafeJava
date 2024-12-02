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
