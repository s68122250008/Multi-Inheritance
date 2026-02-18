public class Main {
    public static void main(String[] args) {

        RescueRobot robot = new RescueRobot("RR-01");

        robot.updatePosition(13, 18);

        robot.takeOff();
        System.out.println(robot.status());
        robot.land();

        robot.startEngine();
        System.out.println("Max speed: " + robot.maxSpeed());
        robot.stopEngine();

        double temp = robot.readTemperatureC();
        System.out.println("Temperature: " + temp);
        System.out.println("Human detected: " + robot.detectHuman(36.5));

        robot.send("Found hotspot...");
    }
}