package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpCompareUtil {
    private RegexpCompareUtil() {
    }

    public static boolean matches(String value, String regexp) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
