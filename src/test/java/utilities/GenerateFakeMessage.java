package utilities;

public class GenerateFakeMessage {

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
}