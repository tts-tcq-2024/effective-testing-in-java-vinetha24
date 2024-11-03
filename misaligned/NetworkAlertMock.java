class NetworkAlertMock implements NetworkAlertFunc {
    static float  receivedCelsius ;
    public int alert(float celcius) {
        receivedCelsius = celcius;
        return 500;
    }
}
