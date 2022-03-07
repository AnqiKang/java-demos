package codeTest.keepInMind;

import java.util.Date;

// final class can not be inherited, so no subclasses can override methods.
public final class ImmutableDemo {

    /**
     * all fields final and private
     * final variable can not be referenced
     * private cannot be accessed from outside
     */
    /**
     * immutable : not provide any setter to change its content
     */
    private final Integer immutableField1;
    private final String immutableField2;

    /**
     * mutable: provide setters to change its value
     * variables can be either mutable or immutable.
     * return new objects with copied content for all mutable objects
     */
    private final Date mutableField;


    /**
     * default private constructor will ensure no unplanned construction of class
     */
    public ImmutableDemo(Integer immutableField1, String immutableField2, Date date) {
        this.immutableField1 = immutableField1;
        this.immutableField2 = immutableField2;
        this.mutableField = new Date(date.getTime());
    }

    /**
     * Factory method to store object creation in single place
     */
    public static ImmutableDemo createNewInstance(Integer i1, String i2, Date date) {
        return new ImmutableDemo(i1, i2, date);
    }

    /**
     * no setters
     * immutable variables' getters
     */
    public Integer getImmutableField1() {
        return immutableField1;
    }

    public String getImmutableField2() {
        return immutableField2;
    }

    /**
     * mutable : should not return the reference of original instance variable
     * instead a new Date obj, with content copied to it, should be returned
     */
    public Date getMutableField() {
        return new Date(mutableField.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableDemo{" +
                "immutableField1=" + immutableField1 +
                ", immutableField2=" + immutableField2 +
                ", mutableField=" + mutableField +
                '}';
    }
}
