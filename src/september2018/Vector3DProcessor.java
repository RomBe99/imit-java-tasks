package september_tasks;
//TODO Возможно можно обойтись без статики?
public class Vector3DProcessor {
    public static Vector3D vectorsSum(Vector3D firstVector, Vector3D secondVector) { // Work
        Point3D pointForFirstVector = firstVector.getCoordinates();
        Point3D pointForSecondVector = secondVector.getCoordinates();

        return new Vector3D(pointForFirstVector.getX() + pointForSecondVector.getX(),
                pointForFirstVector.getY() + pointForSecondVector.getY(),
                pointForFirstVector.getZ() + pointForSecondVector.getZ());
    }

    //TODO Как сделать это с помощью прошлого метода?
    public static Vector3D vectorsDifference(Vector3D firstVector, Vector3D secondVector) { // Work
        Point3D pointForFirstVector = firstVector.getCoordinates();
        Point3D pointForSecondVector = secondVector.getCoordinates();

        return new Vector3D(pointForFirstVector.getX() - pointForSecondVector.getX(),
                pointForFirstVector.getY() - pointForSecondVector.getY(),
                pointForFirstVector.getZ() - pointForSecondVector.getZ());
    }

    public static int dotProduct(Vector3D firstVector, Vector3D secondVector) { // Work
        Point3D firstPoint = firstVector.getCoordinates();
        Point3D secondPoint = secondVector.getCoordinates();

        return firstPoint.getX() * secondPoint.getX() +
                firstPoint.getY() * secondPoint.getY() + firstPoint.getZ() * secondPoint.getZ();
    }

    public static Vector3D productOfVectors(Vector3D firstVector, Vector3D secondVector) { // 50/50
        Point3D firstPoint = firstVector.getCoordinates();
        Point3D secondPoint = secondVector.getCoordinates();

        return new Vector3D(firstPoint.getY() * secondPoint.getZ() - firstPoint.getZ() * secondPoint.getY(),
                - (firstPoint.getX() * secondPoint.getZ() - firstPoint.getZ() * secondPoint.getX()),
                firstPoint.getX() * secondPoint.getY() - firstPoint.getY() * secondPoint.getX());
    }

    public static boolean vectorsCollinearity(Vector3D firstVector, Vector3D secondVector) {
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(productOfVectors(new Vector3D(1, -1, 0), new Vector3D(1, 1, 1)).length()); // sqrt(6)
    }
}
