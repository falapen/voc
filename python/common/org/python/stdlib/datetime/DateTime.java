package org.python.stdlib.datetime;

import org.python.types.Int;

public class DateTime extends org.python.types.Object {
    private org.python.Object year;
    private org.python.Object month;
    private org.python.Object day;

    public DateTime() {
        super();
    }

    @org.python.Method(
            __doc__ = ""
    )
	
    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
    }

    @org.python.Method(
            __doc__ = ""
    )
    public DateTime(org.python.Object year, org.python.Object month, org.python.Object day) {
        super();
	this.year = year;
	this.month = month;
	this.day = day;
    }
}



