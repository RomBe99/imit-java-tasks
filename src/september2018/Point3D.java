package september2018;

import java.util.Objects;

public class Point3D {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public Point3D() {
        this(0, 0, 0);
    }

    public void printPoint() {
        System.out.printf("X: %d Y: %d Z: %d", x, y, z);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return x == point3D.x &&
                y == point3D.y &&
                z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public static void main(String[] args) { // Сравнивать ссылки или что?
        Point3D firstPoint = new Point3D(2, 1, 3);
        Point3D secondPoint = new Point3D();
    }
}
