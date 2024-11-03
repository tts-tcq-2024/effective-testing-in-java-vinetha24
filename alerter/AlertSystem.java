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

interface NetworkAlertFunc {
    int alert(float celcius);
}

class NetworkAlertStub implements NetworkAlertFunc {
    public int alert(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius.");
        return 500;
    }
}

class RealNetworkAlert implements NetworkAlertFunc {
    public int alert(float celcius) {
        System.out.println("Sending real alert for temperature: " + celcius + " celcius.");
        return (celcius > 200.0) ? 500 : 200;
    }
}

class NetworkAlertMock implements NetworkAlertFunc {
    static float  receivedCelsius ;
    public int alert(float celcius) {
        receivedCelsius = celcius;
        return 500;
    }
}
