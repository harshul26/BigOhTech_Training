package Day_5_WhatsApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusUploadingmanagement {
    private Map<Long, Map<Long, List<Status>>> uploadStatusByUser;
    private User_Management userManager;
    private Status_Management statusManager;

    public StatusUploadingmanagement(User_Management userManager, Status_Management statusManager) {
        this.userManager = userManager;
        this.statusManager = statusManager;
        this.uploadStatusByUser = new HashMap<>();
        
        for (Long phoneNo : userManager.getAllUsers().keySet()) {
            this.uploadStatusByUser.put(phoneNo, new HashMap<>());
        }
    }

    public boolean sendStatus(Users sender, Status status) {
        if (userManager.alreadyExistUser(sender)) {
            statusManager.addStatus(status);

            Long senderPhoneNo = sender.getPhoneNo();
            for (Users contact : userManager.getAllContactsOfUser(sender).values()) {
                Long contactPhoneNo = contact.getPhoneNo();

                uploadStatusByUser.putIfAbsent(senderPhoneNo, new HashMap<>());
                Map<Long, List<Status>> contactStatuses = uploadStatusByUser.get(senderPhoneNo);
                contactStatuses.putIfAbsent(contactPhoneNo, new ArrayList<>());
                contactStatuses.get(contactPhoneNo).add(status);
            }
            return true;
        }
        return false;
    }
    public boolean removeStatus(Users sender , Status status){
        if(userManager.alreadyExistUser(sender)){
            statusManager.removeStatus(status);

            Long senderPhoneNo = sender.getPhoneNo();
            for(Users contact : userManager.getAllContactsOfUser(sender).values()){
                Long contactPhoneNo = contact.getPhoneNo();

                uploadStatusByUser.remove(senderPhoneNo);
                Map<Long, List<Status>> contactStatuses = uploadStatusByUser.get(senderPhoneNo);
                contactStatuses.get(contactPhoneNo).remove(status);
            }
            return true;
        }
        return false;
    }
    
}
