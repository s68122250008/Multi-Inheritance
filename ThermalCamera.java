
import java.util.Random;

public class ThermalCamera {
    private final Random temp = new Random();

    public double readTemperatureC() {
        return 30 + temp.nextDouble() * 10;
    }

    public boolean detectHuman(double thresholdC) {
        return readTemperatureC() >= thresholdC;
    }
}
