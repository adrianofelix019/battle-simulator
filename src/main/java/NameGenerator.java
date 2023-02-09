import java.util.Random;

public class NameGenerator {
    static private final String[] consonants = "bcdfghjklmnpqrstvwxyz".split("");
    static private final String[] vowels = "aeiou".split("");

    public static String generateName(int length) {
        Random random = new Random();
        String[] name = new String[length];
        boolean toggle = true;

        for (int i = 0;i < length;i++) {
            if (toggle) {
                name[i] = consonants[random.nextInt(0, consonants.length)];
            } else {
                name[i] = vowels[random.nextInt(0, vowels.length)];
            }
            toggle = !toggle;
        }
        name[0] = name[0].toUpperCase();
        return String.join("", name).toUpperCase();
    }
}
