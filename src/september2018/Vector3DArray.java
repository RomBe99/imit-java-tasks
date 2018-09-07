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
