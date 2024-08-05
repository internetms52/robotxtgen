package hobby.internetms52.robotxtgen.text_gen;

import java.util.List;

public class InputValidationUtil {
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
