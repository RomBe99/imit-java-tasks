package ru.omsu.imit.javatasks;

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

    public static Vector3DArray linearCombinationOfVectors(Vector3DArray vector3DArray, double[] numbers) throws Exception {
        int vector3DArrayLength = vector3DArray.getVector3DArrayLength();

        if (vector3DArrayLength != numbers.length) {
            throw new Exception("Arrays are not equal");
        }

        Vector3D[] vector3DS = vector3DArray.getVector3DArray();
        Point3D point3D;

        for (int i = 0; i < vector3DArrayLength; i++) {
            point3D = vector3DS[i].getVectorCoordinates();
            point3D.multiplyByNumber(numbers[i]);
            vector3DS[i].setVectorCoordinates(point3D);
        }

        vector3DArray.setVector3DArray(vector3DS);

        return vector3DArray;
    }
}
