package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomValue {

    public static String getRandomLogin(int length) {
        String login;
        do {
            login = RandomStringUtils.randomAlphabetic(length / 2) + RandomStringUtils.randomAscii(length / 2);
        } while (!RegexpCompareUtil.matches(login, "^[A-Za-z.,\\/'_ -]{1,50}$"));

        return login;
    }

    public static String getRandomPassword(int length) {
        return RandomStringUtils.randomAlphabetic(length / 2) +  RandomStringUtils.randomAscii(length / 2);
    }
}
