package september2018;

public class Vector3D {
    private Point3D firstCoordinates;
    private Point3D secondCoordinates;

    public Vector3D(Point3D firstCoordinates, Point3D secondCoordinates) {
        setFirstCoordinates(firstCoordinates);
        setSecondCoordinates(secondCoordinates);
    }

    public Vector3D(int x1, int y1, int z1, int x2, int y2, int z2) {
        this(new Point3D(x1, y1, z1), new Point3D(x2, y2, z2));
    }

    public Vector3D() {
        this(new Point3D(), new Point3D());
    }

    public double length() { // Work
        int X = secondCoordinates.getX() - firstCoordinates.getX();
        int Y = secondCoordinates.getY() - firstCoordinates.getY();
        int Z = secondCoordinates.getZ() - firstCoordinates.getZ();

        return Math.sqrt(X * X + Y * Y + Z * Z);
    }

    public boolean equalVectors(Vector3D vector3D) { // Work
        Point3D vectorFirstCoordinates = vector3D.getFirstCoordinates();
        Point3D vectorSecondCoordinates = vector3D.getSecondCoordinates();

        return firstCoordinates.getX() == vectorFirstCoordinates.getX() &&
                firstCoordinates.getY() == vectorFirstCoordinates.getY() &&
                firstCoordinates.getZ() == vectorFirstCoordinates.getZ() &&
                secondCoordinates.getX() == vectorSecondCoordinates.getX() &&
                secondCoordinates.getY() == vectorSecondCoordinates.getY() &&
                secondCoordinates.getZ() == vectorSecondCoordinates.getZ();
    }

    public void inverse() {
        setFirstCoordinates(new Point3D(-firstCoordinates.getX(), -firstCoordinates.getY(), -firstCoordinates.getZ()));
        setSecondCoordinates(new Point3D(-secondCoordinates.getX(), -secondCoordinates.getY(), -secondCoordinates.getZ()));
    }

    public Point3D vectorCoordinate() {
        return new Point3D(secondCoordinates.getX() - firstCoordinates.getX(),
                secondCoordinates.getY() - firstCoordinates.getY(),
                secondCoordinates.getZ() - firstCoordinates.getZ());
    }

    public static void main(String[] args) {
        System.out.println(new Vector3D(new Point3D(4, 7, 12), new Point3D(8, -5, 1)));
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Point3D getFirstCoordinates() {
        return firstCoordinates;
    }

    public Point3D getSecondCoordinates() {
        return secondCoordinates;
    }

    public void setFirstCoordinates(Point3D firstCoordinates) {
        this.firstCoordinates = firstCoordinates;
    }

    public void setSecondCoordinates(Point3D secondCoordinates) {
        this.secondCoordinates = secondCoordinates;
    }
}
