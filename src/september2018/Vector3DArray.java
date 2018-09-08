package september2018;

import java.util.Arrays;

public class Vector3DArray {
    private Vector3D vector3DArray[];

    //TODO Сделать бы исключения
    public Vector3DArray(int arraySize) {
        vector3DArray = new Vector3D[arraySize];
    }

    public int arrayLength() {
        return vector3DArray.length;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setVector3DArray(Vector3D[] vector3DArray) {
        this.vector3DArray = vector3DArray;
    }

    //TODO Сделать бы исключения
    public void setArrayElement(int index, Vector3D vector3D) {
        vector3DArray[index] = vector3D;
    }

    public Vector3D[] getVector3DArray() {
        return vector3DArray;
    }

    public double maxLength() {
        double max = 0;
        double length;

        for (Vector3D i : vector3DArray) {
            length = i.length();

            if (length >= max) {
                max = length;
            }
        }

        return max;
    }

    public int find(Vector3D vector3D) {
        int arrayLength = vector3DArray.length;

        for (int i = 0; i < arrayLength; i++) {
            if (vector3DArray[i].equalVectors(vector3D)) {
                return i;
            }
        }

        return -1;
    }

    public Vector3D arraySum() {
        Vector3D temp = new Vector3D();

        for (Vector3D i : vector3DArray) {
            temp = Vector3DProcessor.vectorsSum(i, temp);
        }

        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3DArray that = (Vector3DArray) o;
        return Arrays.equals(vector3DArray, that.vector3DArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector3DArray);
    }
}
