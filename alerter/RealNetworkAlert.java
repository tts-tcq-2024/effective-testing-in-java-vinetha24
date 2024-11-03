public class RealNetworkAlert implements NetworkAlertFunc {
    public int alert(float celcius) {
        System.out.println("Sending real alert for temperature: " + celcius + " celcius.");
        return (celcius > 200.0) ? 500 : 200;
    }
}
