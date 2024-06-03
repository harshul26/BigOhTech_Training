package Day_1_Politics;

public class Commisioner extends Person{
    public Commisioner(String name){
        super(name);
    }

    public boolean canArrest(MP mp , PM pm){
        if(mp instanceof PM){
            return false;
        }
        else if(mp instanceof Ministers){
            if (pm.giveArrestPermission((Ministers) mp)) {
                //System.out.println("Minister can be arrested with PM's permission.");
                return true;
            } else {
                //System.out.println("Minister cannot be arrested without PM's permission.");
                return false;
            }
        }
        else if( mp instanceof MP){
            if(mp.exceedsSpeedLimit()){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
