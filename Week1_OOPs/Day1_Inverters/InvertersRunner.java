package Day_1_Inverters;

public class InvertersRunner {
    public static void main(String[] args) {
        Inverters pcu = new PCU(10, 240, 85, 500);
        Inverters gti = new GTI(12, 220, 90);
        Inverters regalia = new Regalia(15, 230, 95);
        Inverters simpleHomeInverter = new SimpleHomeInverter(10, 220, 600);
        Inverters icruze = new iCruze(12, 230, 700);

        pcu.displayInfo();
        gti.displayInfo();
        regalia.displayInfo();
        simpleHomeInverter.displayInfo();
        icruze.displayInfo();

    }
    
}
