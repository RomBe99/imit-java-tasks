package september_tasks;

public class Vector3D {
    private Point3D coordinates;

    Vector3D(Point3D startPoint) {
        setCoordinates(startPoint);
    }

    Vector3D(int x, int y, int z) {
        this(new Point3D(x, y, z));
    }

    Vector3D() {
        this(0, 0, 0);
    }

    public double length() { // Work
        int X = coordinates.getX();
        int Y = coordinates.getY();
        int Z = coordinates.getZ();

        return Math.sqrt(X * X + Y * Y + Z * Z);
    }

    //TODO Сделай К Р А С И В О
    public boolean equalVectors(Vector3D vector3D) {
        return coordinates.getX() == vector3D.getCoordinates().getX() && coordinates.getY() == vector3D.getCoordinates().getY() && coordinates.getZ() == vector3D.getCoordinates().getZ();
    }

    public static void main(String[] args) {
        System.out.println(new Vector3D(2, 4, 4).length());
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Point3D getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point3D coordinates) {
        this.coordinates = coordinates;
    }
}
