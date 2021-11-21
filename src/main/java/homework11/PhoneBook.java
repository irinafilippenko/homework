package homework11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, ArrayList<String>> phoneBook = new HashMap<>();
    private ArrayList<String> phoneNumbers;

    public void add(String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            phoneNumbers = phoneBook.get(lastName);
        } else {
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.add(phoneNumber);
        phoneBook.put(lastName, phoneNumbers);
    }

    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }
}
