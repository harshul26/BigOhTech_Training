package Day_5_WhatsApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatManagement {
    User_Management userManager;
    Messaging_Management messageManager;
    Map<Long , Map<Long , List<Messages>>> sentMessagesPersonal;
    Map<Long , Map<Integer , List<Messages>>> sentMessagesGroup;
    Map<Long , Map<Long , List<Messages>>> recievedMessages;
    Messages messages;

    public ChatManagement(){
        userManager = new User_Management();
        messageManager = new Messaging_Management();
        sentMessagesPersonal = initializeUserMessageMap();
        recievedMessages = initializeUserMessageMap();
        sentMessagesGroup = initializeUserMessageGroupMap();
    }

    private Map<Long, Map<Integer, List<Messages>>> initializeUserMessageGroupMap() {
        Map<Long , Map<Integer , List<Messages>>> groups = new HashMap<>();

        for(Long phoneNo : userManager.getAllUsers().keySet()){
            groups.put(phoneNo, new HashMap<>());
        }

        return groups;
    }

    public Map<Long , Map<Long , List<Messages>>> initializeUserMessageMap(){
        Map<Long , Map<Long , List<Messages>>> manager = new HashMap<>();

        for(Long phoneNo : userManager.getAllUsers().keySet()){
            manager.put(phoneNo, new HashMap<>());
        }

        return manager;
    }

    public boolean conversation_One_on_One(Users sender , Users reciever , Messages message){
        if(userManager.alreadyExistUser(sender)){
            if(!userManager.alreadyExistUser(reciever)){
                userManager.addNewUser(reciever);
            }
            messages = new Messages(message.getId(), message.getMessageType());
            message.setNormalMessage(message.getMessage(), message.getMessageType());

            Map<Long , List<Messages>> listSent = new HashMap<>();
            listSent.put(reciever.getPhoneNo() , new ArrayList<>());
            listSent.get(reciever.getPhoneNo()).add(message);
            sentMessagesPersonal.put(sender.getPhoneNo() , listSent);

            Map<Long , List<Messages>> listRecieved = new HashMap<>();
            listRecieved.put(sender.getPhoneNo() , new ArrayList<>());
            listRecieved.get(sender.getPhoneNo()).add(message);
            recievedMessages.put(reciever.getPhoneNo(), listRecieved);

            return true;
        }

        return false;
    }

    public Map<Long , List<Messages>> readingSentMessagesOfUser(Users user){
        Map<Long , List<Messages>> rSentM = new HashMap<>();
        if(userManager.alreadyExistUser(user)){
            rSentM = sentMessagesPersonal.get(user.getPhoneNo());
        }
        return rSentM;
    }


    public Map<Long , List<Messages>> readingRecievedMessagesOfUser(Users user){
        Map<Long , List<Messages>> rRecievedM = new HashMap<>();
        if(userManager.alreadyExistUser(user)){
            rRecievedM = recievedMessages.get(user.getPhoneNo());
        }
        return rRecievedM;
    }

    public boolean groupConversation(Users sender , Group group , Admin admin , Messages message){
        if(userManager.alreadyExistUser(sender)){
            messages = new Messages(message.getId(), message.getMessageType());
            message.setNormalMessage(message.getMessage(), message.getMessageType());
            List<Users> listOfUser = group.getGroupOfUsers().get(admin);
            for(Users reciever : listOfUser){
                Map<Long , List<Messages>> listRecieved = new HashMap<>();
                listRecieved.put(sender.getPhoneNo() , new ArrayList<>());
                listRecieved.get(sender.getPhoneNo()).add(message);
                recievedMessages.put(reciever.getPhoneNo(), listRecieved);
            }
            Map<Integer , List<Messages>> listSent = new HashMap<>();
            listSent.put(group.getGid() , new ArrayList<>());
            listSent.get(group.getGid()).add(message);
            sentMessagesGroup.put(sender.getPhoneNo() , listSent);
            
            return true;
        }
        return false;
    }

    public Map<Integer , List<Messages>> readingSentMessagesOfUserToGroup(Users user){
        Map<Integer , List<Messages>> rSentMG = new HashMap<>();
        if(userManager.alreadyExistUser(user)){
            rSentMG = sentMessagesGroup.get(user.getPhoneNo());
        }
        return rSentMG;
    }
}

