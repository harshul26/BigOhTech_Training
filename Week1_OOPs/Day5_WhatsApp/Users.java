package Day_5_WhatsApp;

import java.util.HashMap;
import java.util.Map;

public class Users extends Person{

    private Map<Long , Contact> listOfContacts;

    public Users(String name, int age, String gender, Long phoneNo) {
        super(name, age, gender , phoneNo);
        listOfContacts = new HashMap<>();
    }


    public boolean addContact(Contact contact){
        if(listOfContacts.containsKey(contact.getPhoneNo())){
            return false;
        }
        listOfContacts.put(contact.getPhoneNo() , contact);
        return true;
    }

    public Map<Long , Contact> getListOfContacts(){
        return this.listOfContacts;
    }
    
    
}
