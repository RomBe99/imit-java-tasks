import java.util.Objects;

public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public Point3D() {
        this(0, 0, 0);
    }

    public void printPoint() {
        System.out.printf("X: %f Y: %f Z: %f", x, y, z);
    }

    public void multiplyByNumber(double multiplier) {
        setX(x * multiplier);
        setY(y * multiplier);
        setZ(z * multiplier);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Double.compare(point3D.x, x) == 0 &&
                Double.compare(point3D.y, y) == 0 &&
                Double.compare(point3D.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
