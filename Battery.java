public class Battery {
    private double percent;

    public Battery(double percent) {
        this.percent = percent;
    }

    public void drain(double amount) {
        percent = Math.max(0, percent - amount);
    }

    public void charge(double amount) {
        percent = Math.min(100, percent + amount);
    }

    public double getPercent() {
        return percent;
    }
}
