package Day_5_WhatsApp;

import java.util.HashMap;
import java.util.Map;

public class Messaging_Management {
    Map<Integer , Messages> listOfMessages;
    
    public Messaging_Management(){
        this.listOfMessages = new HashMap<>();
    }

    public void readMessages(){
        System.out.println("Messages are : ");
        for(Map.Entry<Integer , Messages> message : listOfMessages.entrySet()){
            System.out.println(message);
        }
    }

    public void addMessage(Messages message , MessageType typeOfMessage){
        listOfMessages.put(message.getId(), message);
        message.setNormalMessage(message.getMessage() , typeOfMessage);
    }
}
