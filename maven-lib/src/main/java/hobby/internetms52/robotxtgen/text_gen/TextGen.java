package hobby.internetms52.robotxtgen.text_gen;

public interface TextGen<T> {
    String TEXT_GEN_COLON = ":";
    String LINE_SEPARATOR = System.lineSeparator();

    String gen(T object);

    default String keyValuePairGenText(String key, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(key);
        stringBuilder.append(TEXT_GEN_COLON);
        stringBuilder.append(value);
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

}
