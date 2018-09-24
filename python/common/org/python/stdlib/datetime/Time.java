package org.python.stdlib.datetime;

public class Time extends org.python.types.Object {
    @org.python.Attribute
    public static org.python.Object min = new org.python.stdlib.datetime.Time(new org.python.Object[]{org.python.types.Int.getInt(0), org.python.types.Int.getInt(0), org.python.types.Int.getInt(0), org.python.types.Int.getInt(0)}, null);
    @org.python.Attribute
    public static org.python.Object max = new org.python.stdlib.datetime.Time(new org.python.Object[]{org.python.types.Int.getInt(23), org.python.types.Int.getInt(59), org.python.types.Int.getInt(59), org.python.types.Int.getInt(999999)}, null);
    @org.python.Attribute
    public static org.python.Object resolution = new org.python.stdlib.datetime.Timedelta(org.python.types.Int.getInt(1));

    private org.python.types.Int hour;
    private org.python.types.Int minute;
    private org.python.types.Int second;
    private org.python.types.Int microsecond;
    private org.python.Object tzinfo;

    public Time() {
        super();
    }

    @org.python.Method(
        __doc__ = "time([hour[, minute[, second[, microsecond[, tzinfo]]]]]) --> a time object\n\nAll arguments are optional. tzinfo may be None, or an instance of\na tzinfo subclass. The remaining arguments may be ints.\n"
    )
    public Time(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        if (args.length >= 1) {
            if (args[0] instanceof org.python.types.Int) {
                if (((org.python.types.Int) args[0]).value >= 0 && ((org.python.types.Int) args[0]).value < 24) {
                    this.hour = (org.python.types.Int) args[0];
                } else {
                    throw new org.python.exceptions.ValueError("hour must be in 0..23");
                }
            }
        } else {
            this.hour = org.python.types.Int.getInt(0);
        }

        if (args.length >= 2) {
            if (args[1] instanceof org.python.types.Int) {
                if (((org.python.types.Int) args[1]).value >= 0 && ((org.python.types.Int) args[1]).value < 60) {
                    this.minute = (org.python.types.Int) args[1];
                } else {
                    throw new org.python.exceptions.ValueError("minute must be in 0..59");
                }
            }
        } else {
            this.minute = org.python.types.Int.getInt(0);
        }

        if (args.length >= 3) {
            if (args[2] instanceof org.python.types.Int) {
                if (((org.python.types.Int) args[2]).value >= 0 && ((org.python.types.Int) args[2]).value < 60) {
                    this.second = (org.python.types.Int) args[2];
                } else {
                    throw new org.python.exceptions.ValueError("second must be in 0..59");
                }
            }
        } else {
            this.second = org.python.types.Int.getInt(0);
        }

        if (args.length >= 4) {
            if (args[3] instanceof org.python.types.Int) {
                if (((org.python.types.Int) args[3]).value >= 0 && ((org.python.types.Int) args[3]).value < 1000000) {
                    this.microsecond = (org.python.types.Int) args[3];
                } else {
                    throw new org.python.exceptions.ValueError("microsecond must be in 0..999999");
                }
            }
        } else {
            this.microsecond = org.python.types.Int.getInt(0);
        }

        if (args.length >= 5) {
            this.tzinfo = args[4];
        } else {
            this.tzinfo = org.python.types.NoneType.NONE;
        }
    }

    @org.python.Method(
        __doc__ = "Return getattr(self, name)."
    )
    public org.python.Object __getattribute__(java.lang.String name) {
        if (name.equals("hour")) {
            return this.hour;
        }
        if (name.equals("minute")) {
            return this.minute;
        }
        if (name.equals("second")) {
            return this.second;
        }
        if (name.equals("microsecond")) {
            return this.microsecond;
        }
        if (name.equals("tzinfo")) {
            return this.tzinfo;
        }
        return super.__getattribute__(name);
    };

    @org.python.Method(
        __doc__ = "Implement setattr(self, name, value)."
    )
    public void __setattr__(java.lang.String name, org.python.Object value) {
        throw new org.python.exceptions.AttributeError("attribute \'" + name + "\' of 'datetime.time' objects is not writable");
    };

    @org.python.Method(
        __doc__ = "Return str(self)."
    )
    public org.python.types.Str __str__() {
        java.lang.StringBuilder timeString = new java.lang.StringBuilder("");
        //Hour
        if (this.hour.value < 10) {
            timeString.append("0");
        }
        timeString.append(this.hour.value);
        timeString.append(":");
        //Minute
        if (this.minute.value < 10) {
            timeString.append("0");
        }
        timeString.append(this.minute.value);
        timeString.append(":");
        //Second
        if (this.second.value < 10) {
            timeString.append("0");
        }
        timeString.append(this.second.value);
        //Microsecond
        if (this.microsecond.value > 0) {
            timeString.append(".");
            if (this.microsecond.value < 10) {
                timeString.append("0");
            }
            if (this.microsecond.value < 100) {
                timeString.append("0");
            }
            if (this.microsecond.value < 1000) {
                timeString.append("0");
            }
            if (this.microsecond.value < 10000) {
                timeString.append("0");
            }
            if (this.microsecond.value < 100000) {
                timeString.append("0");
            }
            timeString.append(this.microsecond.value);
        }
        return new org.python.types.Str(timeString.toString());
    }

}
