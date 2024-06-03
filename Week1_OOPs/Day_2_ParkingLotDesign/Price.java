package Day_2_ParkingLotDesign;

import java.util.List;

class Price {
    private int firstHourFee;
    private double secondThirdHourFee;
    private double remainingHourFee;

    public Price() {
        this.firstHourFee = 4;
        this.secondThirdHourFee = 3.5;
        this.remainingHourFee = 2.5;
    }

    public List<Double> fees() {
        return List.of((double) firstHourFee, secondThirdHourFee, remainingHourFee);
    }

    public int charge(int checkIn, int checkOut) {
        int hours = checkOut - checkIn;
        int fee = 0;
        while(hours > 0){
            if(hours > 3){
                fee += remainingHourFee;
                hours--;
            }
            else if(hours > 1){
                fee += secondThirdHourFee;
                hours--;
            }
            else if(hours == 1){
                fee += firstHourFee;
                hours--;
            }
        }
        return fee;
    }
}

