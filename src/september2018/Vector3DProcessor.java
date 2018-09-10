package september2018;
public class Vector3DProcessor {
    public static Vector3D vectorsSum(Vector3D firstVector, Vector3D secondVector) { // Work
        Point3D firstVectorFirstCoordinates = firstVector.getFirstCoordinates();
        Point3D firstVectorSecondCoordinates = secondVector.getFirstCoordinates();
        Point3D secondVectorFirstCoordinates = firstVector.getFirstCoordinates();
        Point3D secondVectorSecondCoordinates = secondVector.getFirstCoordinates();

        return new Vector3D(firstVectorFirstCoordinates.getX() + firstVectorSecondCoordinates.getX(),
                firstVectorFirstCoordinates.getY() + firstVectorSecondCoordinates.getY(),
                firstVectorFirstCoordinates.getZ() + firstVectorSecondCoordinates.getZ(),
                secondVectorFirstCoordinates.getX() + secondVectorSecondCoordinates.getX(),
                secondVectorFirstCoordinates.getY() + secondVectorSecondCoordinates.getY(),
                secondVectorFirstCoordinates.getZ() + secondVectorSecondCoordinates.getZ());
    }

    public static Vector3D vectorsDifference(Vector3D firstVector, Vector3D secondVector) { // Work
        secondVector.inverse();

        return vectorsSum(firstVector, secondVector);
    }

    public static int dotProduct(Vector3D firstVector, Vector3D secondVector) { // Work
        Point3D firstPoint = firstVector.vectorCoordinate();
        Point3D secondPoint = secondVector.vectorCoordinate();

        return firstPoint.getX() * secondPoint.getX() +
                firstPoint.getY() * secondPoint.getY() + firstPoint.getZ() * secondPoint.getZ();
    }

    public static Vector3D productOfVectors(Vector3D firstVector, Vector3D secondVector) {
        Point3D firstPointFirstVector = firstVector.getFirstCoordinates();
        Point3D secondPointFirstVector = firstVector.getSecondCoordinates();
        Point3D firstPointSecondVector = secondVector.getFirstCoordinates();
        Point3D secondPointSecondVector = secondVector.getSecondCoordinates();

        return new Vector3D(firstPointFirstVector.getX() * secondPointFirstVector.getX(),
                firstPointFirstVector.getY() * secondPointFirstVector.getY(),
                firstPointFirstVector.getZ() * secondPointFirstVector.getZ(),
                firstPointSecondVector.getX() * secondPointFirstVector.getX(),
                firstPointSecondVector.getY() * secondPointFirstVector.getY(),
                firstPointSecondVector.getZ() * secondPointFirstVector.getZ());
    }

    public static boolean vectorsCollinearity(Vector3D firstVector, Vector3D secondVector) {
        return dotProduct(firstVector, secondVector) == 0;
    }

    public static void main(String[] args) {
    }
}
