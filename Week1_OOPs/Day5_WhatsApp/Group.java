package Day_5_WhatsApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    Map<Admin , List<Users>> groupOfUsers;
    private int Gid;

    public Group(int id){
        groupOfUsers = new HashMap<>();
        this.Gid = id;
    }

    public void createGroup(Admin admin){
        groupOfUsers.put(admin , new ArrayList<>());
    }

    public boolean addMembersInGroup(Admin admin, Users user){
        if(groupOfUsers.containsKey(admin)){
            if(!groupOfUsers.get(admin).contains(user)){
                groupOfUsers.get(admin).add(user);
                return true;
            }
        }

        return false;
    }

    public boolean removeMembersFromGroup(Admin admin , Users user){

        if(groupOfUsers.containsKey(admin)){
            if(groupOfUsers.get(admin).contains(user)){
                groupOfUsers.get(admin).remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteGroup(Admin admin){
        if(groupOfUsers.containsKey(admin)){
            groupOfUsers.remove(admin);
            return true;
        }
        return false;
    }

    public Map<Admin, List<Users>> getGroupOfUsers() {
        return groupOfUsers;
    }

    public int getGid() {
        return Gid;
    }
    
}
