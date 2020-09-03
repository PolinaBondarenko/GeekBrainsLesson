import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<Long, String> phoneBook = new HashMap<>();

    public void add(long number, String surname){
        phoneBook.put(number, surname);
    }

    public void get(String surname){
        for (Map.Entry<Long, String> pair: phoneBook.entrySet()){
            if (pair.getValue().equalsIgnoreCase(surname)){
                System.out.println(surname+" : " + pair.getKey());
            }
        }
    }
}
