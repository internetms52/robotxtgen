package hobby.internetms52.robotxtgen.text_gen;

public interface TextGen<T> {
    String TEXT_GEN_COLON = ":";

    String gen(T object);

    default String keyValuePairGenText(String key, String value) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(key);
        stringBuffer.append(TEXT_GEN_COLON);
        stringBuffer.append(value);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
    
}
