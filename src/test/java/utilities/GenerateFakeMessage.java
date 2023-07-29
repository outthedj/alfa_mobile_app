package utilities;

import com.github.javafaker.Faker;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class GenerateFakeMessage {

    public static String generateFirstName() {
        Faker faker = new Faker();
        return ("auto" + faker.name().firstName());
    }

    public static String generateLastName() {
        Faker faker = new Faker();
        return ("auto" + faker.name().lastName());
    }

    public static String generateLetterifyData(String letterString) {
        Faker faker = new Faker();
        return faker.letterify(letterString);
    }

    public static String generateNumerifyData(String numberString) {
        Faker faker = new Faker();
        return faker.numerify(numberString);
    }

    public static String generateTestsName(String data) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return data + "_automation_" + dateFormat.format(date);
    }

    public static String generateDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String generateDate(Integer days) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return dateFormat.format(calendar.getTime());
    }

    public static String generateDate(int yearShift, int monthShift, int dayShift) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, dayShift);
        calendar.add(Calendar.MONTH, monthShift);
        calendar.add(Calendar.YEAR, yearShift);
        Date date = calendar.getTime();
        return dateFormat.format(date);
    }

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePhrase() {
        Faker faker = new Faker();
        return faker.rickAndMorty().quote();
    }

    public static String generateCity() {
        Faker faker = new Faker();
        return faker.address().city();
    }

    public static String generateAddress() {
        Faker faker = new Faker();
        return faker.address().fullAddress();
    }

    public static String generateFakeEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generateStringOfLength(Integer count, String stringTemplate) {
        StringBuilder stringBuilder = new StringBuilder(count);
        for (int index = 0; index < count; index++) {
            stringBuilder.append(stringTemplate.charAt((int) (stringTemplate.length() * Math.random())));
        }
        return stringBuilder.toString();
    }

    public static String generateStringOfLength(Integer count) {
        String stringTemplate = "ABCDEFGHIJKLMNOPQRSTUVWXYZ.,/'_-abcdefghijklmnopqrstuvwxyz";
        return generateStringOfLength(count, stringTemplate);
    }

    public static String generateMacAddress() {
        Faker faker = new Faker();
        return faker.internet().macAddress();
    }

    public static String generateCreditCardNumber() {
        Random random = new Random(System.currentTimeMillis());
        int randomNumberLength = 11;
        StringBuilder builder = new StringBuilder("4111");
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }
        String stringBuild = builder.toString();
        int sum = 0;
        for (int i = 0; i < stringBuild.length(); i++) {
            int digit = Integer.parseInt(stringBuild.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        int checkDigit = ((mod == 0) ? 0 : 10 - mod);
        builder.append(checkDigit);
        return builder.toString();
    }
}