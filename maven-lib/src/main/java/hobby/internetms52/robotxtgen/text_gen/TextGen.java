package hobby.internetms52.robotxtgen.text_gen;

public interface TextGen<T> {
    String TEXT_GEN_COLON = ":";
    String TEXT_HASH_SIGN = "#";
    String LINE_SEPARATOR = System.lineSeparator();

    String gen(T object);

    default String keyValuePairGenText(String key, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(key);
        stringBuilder.append(TEXT_GEN_COLON);
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }

    default String commentGenText(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TEXT_HASH_SIGN);
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }

}
