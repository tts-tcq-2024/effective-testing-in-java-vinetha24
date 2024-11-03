
package alerter;
public class AlertSystem {
    int alertFailureCount;
    NetworkAlertFunc networkAlertFunc;

    public AlertSystem(int alertFailureCount, NetworkAlertFunc networkAlertFunc) {
        this.alertFailureCount = alertFailureCount;
        this.networkAlertFunc = networkAlertFunc;
    }

    public void alertInCelcius(float fahrenheit) {
        float celcius = (fahrenheit - 32) * 5 / 9;
        int returnCode = networkAlertFunc.alert(celcius);
        if (returnCode != 200) {
            alertFailureCount++;
        }
    }

    public static void main(String[] args) {
      //mockalert
        AlertSystem testSystem = new AlertSystem(0, new NetworkAlertMock());
        testSystem.alertInCelcius(303.6f);
        
        assert(NetworkAlertMock.receivedCelsius==0.0f);
        assert(testSystem.alertFailureCount==2);
        //with Real network alert
        testSystem.networkAlertFunc =  new RealNetworkAlert();
        testSystem.alertInCelcius(500.0f);
        testSystem.alertInCelcius(178.0f);
        assert(testSystem.alertFailureCount==3);
    }
}
