package org.python.stdlib.datetime;

public class Timedelta extends org.python.types.Object {
    private org.python.types.Int day;

    //Constructors
    public Timedelta() {
        super();
    }

    @org.python.Method(
        __doc__ = "Difference between two datetime values.",
        args = {"day"}
    )
    public Timedelta(org.python.Object day) {
        super();
        this.day = (org.python.types.Int) day;
    }

    public org.python.types.Str __repr__() {
        java.lang.StringBuilder buffer = new java.lang.StringBuilder("datetime.timedelta(");
        buffer.append(this.day.value + ")");

        return new org.python.types.Str(buffer.toString());
    }
}