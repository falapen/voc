package org.python.stdlib.datetime;

public class Date extends org.python.types.Object {

    //Constructors
    private Date() {
        super();
    }

    @org.python.Method(
            __doc__ = "Method to represent a date (without time)",
            args = {"year", "month", "day"}
    )
    public Date(org.python.Object year, org.python.Object month, org.python.Object day) {
        //super();
        if(year instanceof org.python.types.Int) {
            if(((org.python.types.Int) year).value > 0 || ((org.python.types.Int) year).value < 10000) {
                this.year = ((org.python.types.Int) year).value;
            } else {
                throw new org.python.exceptions.ValueError("year " + Long.toString(((org.python.types.Int) year).value) + " is out of range");
            }
        } else {
            this.year = 0;
        }
        if(month instanceof org.python.types.Int) {
            this.month = ((org.python.types.Int) month).value;
        } else { 
            this.month = 0;
        }
        if(day instanceof org.python.types.Int) {
            this.day = ((org.python.types.Int) day).value;
        } else {
            this.day = 0;
        }
    }

    //static {
    //    min = org.python.types.Type(org.python.stdlib.datetime.Date.class);
    //    max = org.python.types.Type(org.python.stdlib.datetime.Date.class);
    //}
    @org.python.Attribute
    public static org.python.Object min;
    @org.python.Attribute
    public static org.python.Object max;

    ////Placeholder CONSTANTS
    //private static org.python.types.Int MINYEAR = org.python.types.Int.getInt(1);
    //private static org.python.types.Int MAXYEAR = org.python.types.Int.getInt(9999);
//
    //Instance attributes (read-only) 
    private long year;
    private long month;
    private long day;
    

    //Interface methods
    public org.python.types.Object __getattr__(java.lang.String name) {
        if(name.equals("year")) return org.python.types.Int.getInt(this.year);
        if(name.equals("month")) return org.python.types.Int.getInt(this.month);
        if(name.equals("day")) return org.python.types.Int.getInt(this.day);
        return null;
    };
    
    public void __setattr__(java.lang.String name, org.python.Object value) {
        if(name.equals("year")) {
            if(value instanceof org.python.types.Int) {
                this.year = ((org.python.types.Int) value).value;
            }
        };
        if(name.equals("month")) {
            if(value instanceof org.python.types.Int) {
                this.month = ((org.python.types.Int) value).value;
            }
        };
        if(name.equals("day")) {
            if(value instanceof org.python.types.Int) {
                this.day = ((org.python.types.Int) value).value;
            }
        };
    };

    @org.python.Method(
            __doc__ = "Return repr(self)."
    )
    public org.python.types.Str __repr__() {
        java.lang.StringBuilder buffer = new java.lang.StringBuilder("datetime.date(");
        buffer.append(this.year + ", ");
        buffer.append(this.month + ", ");
        buffer.append(this.day + ")");

        return new org.python.types.Str(buffer.toString());
    }

    @org.python.Method(
            __doc__ = "Returns a string representation of self."
    )
    public org.python.types.Str __str__() {
        java.lang.StringBuilder buffer = new java.lang.StringBuilder("");
        //Build year
        if(this.year < 1000) buffer.append("0");
        if(this.year < 100) buffer.append("0");
        if(this.year < 10) buffer.append("0");
        buffer.append(this.year + "-");
        //Build month
        if(this.month < 10) buffer.append("0");
        buffer.append(this.month + "-");
        //Build day
        if(this.day < 10) buffer.append("0");
        buffer.append(this.day);        
        return new org.python.types.Str(buffer.toString());
    }

    @org.python.Method(
            __doc__ = "timestamp -> local date from a POSIX timestamp (like time.time()).",
            args = {"timestamp"}
    )
    public static org.python.Object fromtimestamp(org.python.Object timestamp) {
        java.util.Date date;
        java.util.Calendar calendar;

        if((timestamp instanceof org.python.types.Int) || (timestamp instanceof org.python.types.Float)) {
            date = new java.util.Date(((org.python.types.Int) timestamp.__int__()).value * 1000L);
            calendar = java.util.Calendar.getInstance();
            calendar.setTime(date);
        } else {
            throw new org.python.exceptions.TypeError("a float is required");
        }

        return new Date(
            org.python.types.Int.getInt(Long.valueOf(calendar.get(java.util.Calendar.YEAR))), 
            org.python.types.Int.getInt(Long.valueOf(calendar.get(java.util.Calendar.MONTH))), 
            org.python.types.Int.getInt(Long.valueOf(calendar.get(java.util.Calendar.DAY_OF_MONTH))));
    }
}