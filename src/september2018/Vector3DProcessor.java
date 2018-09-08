package september2018;
//TODO Возможно можно обойтись без статики?
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

    //TODO Доделать для двух точек
    public static int dotProduct(Vector3D firstVector, Vector3D secondVector) { // 50/50
        Point3D firstPoint = firstVector.getFirstCoordinates();
        Point3D secondPoint = secondVector.getFirstCoordinates();

        return firstPoint.getX() * secondPoint.getX() +
                firstPoint.getY() * secondPoint.getY() + firstPoint.getZ() * secondPoint.getZ();
    }

    //TODO Доделать для двух точек
    /*public static Vector3D productOfVectors(Vector3D firstVector, Vector3D secondVector) { // 50/50
        Point3D firstPoint = firstVector.getFirstCoordinates();
        Point3D secondPoint = secondVector.getFirstCoordinates();

        return new Vector3D(firstPoint.getY() * secondPoint.getZ() - firstPoint.getZ() * secondPoint.getY(),
                - (firstPoint.getX() * secondPoint.getZ() - firstPoint.getZ() * secondPoint.getX()),
                firstPoint.getX() * secondPoint.getY() - firstPoint.getY() * secondPoint.getX());
    }*/

    public static boolean vectorsCollinearity(Vector3D firstVector, Vector3D secondVector) {
        return dotProduct(firstVector, secondVector) == 0;
    }

    public static void main(String[] args) {
        //System.out.println(productOfVectors(new Vector3D(1, -1, 0), new Vector3D(1, 1, 1)).length()); // sqrt(6)
    }
}
