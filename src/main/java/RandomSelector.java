import java.util.List;
import java.util.Random;

public abstract class RandomSelector {

    public static <T> T getRandomEntry(List<T> listOfStuff){
        int indexNumber = new Random().nextInt(listOfStuff.size());
        return listOfStuff.get(indexNumber);
    }


}
