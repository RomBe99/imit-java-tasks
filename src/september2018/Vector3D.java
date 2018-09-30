package september2018;

import java.util.Objects;

public class Vector3D {
    private Point3D vectorCoordinates;

    public Vector3D(Point3D vectorCoordinates) {
        setVectorCoordinates(vectorCoordinates);
    }

    public Vector3D(double x, double y, double z) {
        this(new Point3D(x, y, z));
    }

    public Vector3D() {
        this(new Point3D());
    }

    public double length() {
        double X = vectorCoordinates.getX();
        double Y = vectorCoordinates.getY();
        double Z = vectorCoordinates.getZ();

        return Math.sqrt(X * X + Y * Y + Z * Z);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setVectorCoordinates(Point3D vectorCoordinates) {
        this.vectorCoordinates = vectorCoordinates;
    }

    public Point3D getVectorCoordinates() {
        return vectorCoordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Objects.equals(vectorCoordinates, vector3D.vectorCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vectorCoordinates);
    }
}
