package hobby.internetms52.robotxtgen.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Utility class for List operations.
 */
public class ListUtil {
    /**
     * Filters out null elements from the input List and retains only String elements.
     *
     * @param list The input List, which can contain elements of any type
     * @return A new List<String> containing only non-null String elements from the original List
     */
    public static List<String> nullFilter(List<?> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(obj -> {
                    return obj instanceof String;
                }).map(obj -> {
                    return (String) obj;
                })
                .collect(Collectors.toList());
    }
}
