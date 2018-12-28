package lab9_Ma_Interfaces;

public interface Comparable {

    /* Returns -1 if the current object is "less than" otherObject
     * Returns 1 if the current object is "greater than" otherObject
     * Returns 0 if both objects are "equal" (from a sort perspective)
     * Returns -99 if otherObject is not the same type as the current object. **/
    public int compareTo(Object otherObject);
}
