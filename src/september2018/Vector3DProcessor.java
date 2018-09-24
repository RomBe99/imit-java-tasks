package september2018;

public class Vector3DProcessor {
    public static Vector3D vectorsSum(Vector3D firstVector, Vector3D secondVector) {
        Point3D firstCoordinates = firstVector.getVectorCoordinates();
        Point3D secondCoordinates = secondVector.getVectorCoordinates();

        return new Vector3D(firstCoordinates.getX() + secondCoordinates.getX(),
                firstCoordinates.getY() + secondCoordinates.getY(),
                firstCoordinates.getZ() + secondCoordinates.getZ());
    }

    public static Vector3D vectorsDifference(Vector3D firstVector, Vector3D secondVector) {
        Point3D firstCoordinates = firstVector.getVectorCoordinates();
        Point3D secondCoordinates = secondVector.getVectorCoordinates();

        return new Vector3D(firstCoordinates.getX() - secondCoordinates.getX(),
                firstCoordinates.getY() - secondCoordinates.getY(),
                firstCoordinates.getZ() - secondCoordinates.getZ());
    }

    public static double dotProduct(Vector3D firstVector, Vector3D secondVector) {
        Point3D firstCoordinates = firstVector.getVectorCoordinates();
        Point3D secondCoordinates = secondVector.getVectorCoordinates();

        return firstCoordinates.getX() * secondCoordinates.getX() +
                firstCoordinates.getY() * secondCoordinates.getY() +
                firstCoordinates.getZ() * secondCoordinates.getZ();
    }

    public static Vector3D productOfVectors(Vector3D firstVector, Vector3D secondVector) {
        Point3D firstCoordinates = firstVector.getVectorCoordinates();
        Point3D secondCoordinates = secondVector.getVectorCoordinates();

        return new Vector3D(firstCoordinates.getY() * secondCoordinates.getZ() - firstCoordinates.getZ() * secondCoordinates.getY(),
                -(firstCoordinates.getX() * secondCoordinates.getZ() - firstCoordinates.getZ() * secondCoordinates.getX()),
                firstCoordinates.getX() * secondCoordinates.getY() - firstCoordinates.getY() * secondCoordinates.getX());
    }

    public static boolean vectorsCollinearity(Vector3D firstVector, Vector3D secondVector) {
        double dotProduct = dotProduct(firstVector, secondVector);
        return dotProduct == -1 || dotProduct == 1;
    }

    public static void main(String[] args) {
    }
}
