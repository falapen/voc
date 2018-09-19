package org.python.stdlib.datetime;

public class Date extends org.python.types.Object {

    //Constructors
    public Date() {
        super();
    }

    @org.python.Method(
        __doc__ = "",
        default_args = {"year", "month", "day"}
    )
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        if (args[0] != null) {
            if(args[0] instanceof org.python.types.Int) {
                if(((org.python.types.Int) args[0]).value > 0 || ((org.python.types.Int) args[0]).value < 10000) {
                    this.year = ((org.python.types.Int) args[0]).value;
                } else {
                    throw new org.python.exceptions.ValueError("year " + Long.toString(((org.python.types.Int) args[0]).value) + " is out of range");
                }
            }
        }

        if (args[1] != null) {
            if(args[1] instanceof org.python.types.Int) {
                if(((org.python.types.Int) args[1]).value > 0 || ((org.python.types.Int) args[1]).value < 10000) {
                    this.month = ((org.python.types.Int) args[1]).value;
                } else {
                    throw new org.python.exceptions.ValueError("month " + Long.toString(((org.python.types.Int) args[1]).value) + " is out of range");
                }
            }
        }

        if (args[2] != null) {
            if(args[2] instanceof org.python.types.Int) {
                if(((org.python.types.Int) args[2]).value > 0 || ((org.python.types.Int) args[2]).value < 10000) {
                    this.day = ((org.python.types.Int) args[2]).value;
                } else {
                    throw new org.python.exceptions.ValueError("day " + Long.toString(((org.python.types.Int) args[2]).value) + " is out of range");
                }
            }
        }
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

    @org.python.Attribute
    public static org.python.Object min;
    @org.python.Attribute
    public static org.python.Object max;

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
        java.time.LocalDate date;

        if((timestamp instanceof org.python.types.Int) || (timestamp instanceof org.python.types.Float)) {
            date = 
                java.time.Instant.ofEpochSecond(((org.python.types.Int) timestamp.__int__()).value)
                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        } else {
            throw new org.python.exceptions.TypeError("a float is required");
        }

        return new org.python.stdlib.datetime.Date(
            org.python.types.Int.getInt(Long.valueOf(date.getYear())), 
            org.python.types.Int.getInt(Long.valueOf(date.getMonthValue())), 
            org.python.types.Int.getInt(Long.valueOf(date.getDayOfMonth())));
    }

    @org.python.Method(
            __doc__ = "Return the day of the week represented by the date.\nMonday == 0 ... Sunday == 6"
    )
    public org.python.Object weekday() {
        java.time.LocalDate date = java.time.LocalDate.of((int) this.year, (int) this.month, (int) this.day);
        long weekday = (long) date.getDayOfWeek().getValue() - 1; // date.weekday() uses zero indexing

        return org.python.types.Int.getInt(weekday);
    }
}