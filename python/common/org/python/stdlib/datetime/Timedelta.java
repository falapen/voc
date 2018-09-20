package org.python.stdlib.datetime;

public class Timedelta extends org.python.types.Object {
    private org.python.types.Int day;

    //Constructors
    public Timedelta() {
        super();
    }

    @org.python.Method(
        __doc__ = "Difference between two datetime values."
    )
    public Timedelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        this.day = (org.python.types.Int) kwargs.get("day");
    }

    public org.python.types.Str __repr__() {
        java.lang.StringBuilder buffer = new java.lang.StringBuilder("datetime.date(");
        buffer.append(this.day.value + ")");

        return new org.python.types.Str(buffer.toString());
    }
}