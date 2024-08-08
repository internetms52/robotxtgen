package hobby.internetms52.robotxtgen.text_gen;

import java.util.List;

/**
 * Utility class for validating input values.
 * This class provides methods to validate various potential input types for robots.txt.
 */
public class InputValidationUtil {
    /**
     * Validates whether the input value is valid (non-empty).
     *
     * @param object The input object to validate, which can be various input types for robots.txt.
     * @return true if the input is valid, false otherwise.
     */
    public static boolean isValidInput(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof List) {
            return true;
        }
        if (object instanceof Integer) {
            try {
                Integer.parseInt(String.valueOf(object));
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        if (object instanceof String) {
            return !((String) object).isEmpty();
        }
        return false;
    }
}
