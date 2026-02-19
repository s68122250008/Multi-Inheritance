public class RescueRobot implements Flyable, Drivable, ThermalSensor, Communicable {

    private final String id;
    private final Battery battery;
    private final GPSTracker gps;
    private final ThermalCamera thermal;

    public RescueRobot(String id) {
        this.id = id;
        this.battery = new Battery(100);
        this.gps = new GPSTracker();
        this.thermal = new ThermalCamera();
    }

    @Override
    public String status() {
        return "ROBOT: " + Flyable.super.status() + " + " + Drivable.super.status();
    }

    // Flyable
    @Override
    public void takeOff() {
        battery.drain(5);
        System.out.println("Take off");
    }

    @Override
    public void land() {
        battery.drain(2);
        System.out.println("Land");
    }

    // Drivable
    @Override
    public void startEngine() {
        battery.drain(3);
        System.out.println("Engine started");
    }

    @Override
    public void stopEngine() {
        battery.drain(1);
        System.out.println("Engine stopped");
    }

    @Override
    public double maxSpeed() {
        return 80;
    }

    // ThermalSensor
    @Override
    public double readTemperatureC() {
        battery.drain(1);
        return thermal.readTemperatureC();
    }

    // ThermalSensor
    @Override
    public boolean detectHuman(double thresholdC) {
        battery.drain(2);
        return thermal.detectHuman(thresholdC);
    }

    // Communicable
    @Override
    public void send(String message) {
        battery.drain(1);
        System.out.println("ID=" + id + " POS=" + gps.currentPosition() + " MSG=" + message);
    }

    @Override
    public String getDeviceId() {
        return id;
    }

    public void updatePosition(double lat, double lon) {
        gps.updatePosition(lat, lon);
    }

    @Override
    public double maxAltitude() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}