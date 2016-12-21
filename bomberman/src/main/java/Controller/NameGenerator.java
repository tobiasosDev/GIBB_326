package Controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by tobiasluscher on 14.12.16.
 */
public class NameGenerator {

    public String getRandomName(){
        List<String> names = Arrays.asList("Hans", "Peter", "Glückszwerg", "Inrneas", "Coldbringer", "Bemnathaen", "Heartspark", "Hatin", "Autumnshield","Bemanena", "Starsky","Erzen", "Coldstar","Drararon", "Starwalker","Zaeris", "Sunfall","Kreveth", "Autumnflame","Noraeaen", "Brightsprinter","Duaesh", "Autumnsinger");
        int randomInt = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        int randomIntForName = ThreadLocalRandom.current().nextInt(0, 22 + 1);
        int randomIntForLastName = ThreadLocalRandom.current().nextInt(0, 22 + 1);

        return (names.get(randomIntForName) + ' ' + names.get(randomIntForLastName) + randomInt);
    }
}
