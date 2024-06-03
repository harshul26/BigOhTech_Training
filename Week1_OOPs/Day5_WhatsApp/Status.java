package Day_5_WhatsApp;

public class Status {
    private Long id;
    private StatusType sType;

    public Status(Long id, StatusType sType) {
        this.id = id;
        this.sType = sType;
    }

   

    public Status(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public StatusType getStatusType() {
        return this.sType;
    }
    
}
