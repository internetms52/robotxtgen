package hobby.internetms52.robotxtgen.text_gen;

public interface TextGen<T> {
    String TEXT_GEN_COLON = ":";
    String TEXT_HASH_SIGN = "#";
    String LINE_SEPARATOR = System.lineSeparator();

    String gen(T object);

    /**
     * Generates a formatted string representation of a key-value pair.
     * This method creates a string with the following format:
     * "[key]: [value]" followed by a line separator.
     *
     * @param key The key of the pair. Should not be null.
     * @param value The value associated with the key. Should not be null.
     * @return A formatted string representation of the key-value pair.
     *
     * @throws NullPointerException if either key or value is null.
     */
    default String keyValuePairGenText(String key, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(key);
        stringBuilder.append(TEXT_GEN_COLON);
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }

    /**
     * Generates a formatted comment string.
     * This method creates a string with the following format:
     * "# [value]" followed by a line separator.
     *
     * @param value The content of the comment. Should not be null.
     * @return A formatted string representation of the comment.
     *
     * @throws NullPointerException if value is null.
     *
     */
    default String commentGenText(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TEXT_HASH_SIGN);
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }

}
