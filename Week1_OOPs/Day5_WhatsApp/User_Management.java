package Day_5_WhatsApp;

import java.util.HashMap;
import java.util.Map;

public class User_Management {
    Map<Long , Users> listOfUsers;
    Group group;

    public User_Management(){
        this.listOfUsers = new HashMap<>();
    }

    public boolean alreadyExistUser(Users user){
        if(listOfUsers.containsKey(user.getPhoneNo())){
            return true;
        }
        return false;
    }

    public boolean addNewUser(Users user){
        if(!alreadyExistUser(user)){
            listOfUsers.put(user.getPhoneNo() , user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Users user){
        if(alreadyExistUser(user)){   
            listOfUsers.remove(user.getPhoneNo());
            return true;
        }
        return false;
    }

    public Map<Long , Users> getAllUsers(){
        return listOfUsers;
    }

    public Map<Long , Contact> getAllContactsOfUser(Users user){
        if(alreadyExistUser(user)){
            return user.getListOfContacts();
        }
        return null;
    }

    public void createNewGroup(int id , Admin admin){
        group = new Group(id);
        group.createGroup(admin);
    }

    public boolean addMembersInGroup(Admin admin , Users user){
        return group.addMembersInGroup(admin, user);
    }

    public boolean removeMembersFromGroup(Admin admin , Users user){
        return group.removeMembersFromGroup(admin, user);
    }

    public boolean deleteGroup(Admin admin){
        return group.deleteGroup(admin);
    }
}

