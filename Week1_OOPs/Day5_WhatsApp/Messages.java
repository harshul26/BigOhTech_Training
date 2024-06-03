package Day_5_WhatsApp;

public class Messages {
    private int mId;
    private MessageType typeOfMessage;
    private String message;
    private String timeStamp;

    public Messages(int mId , MessageType mT){
        this.mId = mId;
        this.typeOfMessage = mT;
    }

    public int getId(){
        return this.mId;
    }

    public MessageType getMessageType(){
        return this.typeOfMessage;
    }

    public void setNormalMessage(String m , MessageType typeOfMessage){
        this.message = m;
        this.typeOfMessage = typeOfMessage;
    }

    public String getMessage(){
        return message;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public void setTypeOfMessage(MessageType typeOfMessage) {
        this.typeOfMessage = typeOfMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp(){
        return this.timeStamp;
    }
    public void setTimeStamp(String time){
        this.timeStamp = time;
    }
}
