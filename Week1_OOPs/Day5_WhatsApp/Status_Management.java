package Day_5_WhatsApp;

import java.util.HashMap;
import java.util.Map;

public class Status_Management {
    private Map<Long, Status> statuses;

    public Status_Management() {
        statuses = new HashMap<>();
    }

    public void addStatus(Status newStatus) {
        statuses.put(newStatus.getId(), newStatus);
    }

    public void removeStatus(Status oldStatus) {
        statuses.remove(oldStatus.getId());
    }

    public Status readStatus(Status status) {
        return statuses.get(status.getId());
    }


}
