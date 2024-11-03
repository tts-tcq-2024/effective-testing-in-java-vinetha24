class NetworkAlertStub implements NetworkAlertFunc {
    public int alert(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius.");
        return 500;
    }
}
