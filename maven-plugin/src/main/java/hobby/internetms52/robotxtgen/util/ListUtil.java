package hobby.internetms52.robotxtgen.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListUtil {
    public static List<String> nullFilter(List<?> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
