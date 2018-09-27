package org.python.stdlib.datetime;

public class Time extends org.python.types.Object {
    @org.python.Attribute
    public static org.python.stdlib.datetime.Time min = new org.python.stdlib.datetime.Time(new org.python.Object[]{org.python.types.Int.getInt(23), org.python.types.Int.getInt(59), org.python.types.Int.getInt(59), org.python.types.Int.getInt(999999)}, null);


    @org.python.Attribute
    public static org.python.stdlib.datetime.Time max = new org.python.stdlib.datetime.Time(new org.python.Object[]{org.python.types.Int.getInt(0), org.python.types.Int.getInt(0), org.python.types.Int.getInt(0), org.python.types.Int.getInt(0)}, null);


    @org.python.Attribute
    public org.python.Object resolution = new org.python.stdlib.datetime.Timedelta(org.python.types.Int.getInt(1));


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
    }

    @org.python.Method(
            __doc__ = "Implement setattr(self, name, value)."
    )
    public void __setattr__(java.lang.String name, org.python.Object value) {
        throw new org.python.exceptions.AttributeError("attribute \'" + name + "\' of 'datetime.time' objects is not writable");
    }

    @org.python.Method(
                __doc__ = "Return string in ISO 8601 format, [HH[:MM[:SS[.mmm[uuu]]]]][+HH:MM].\n\ntimespec specifies what components of the time to include."
    )
    public org.python.types.Str isoformat() {
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

    @org.python.Method(
            __doc__ = "Return time with new specified fields.",
            default_args = {"hour", "minute", "second", "microsecond", "tzinfo"}
    )
    public org.python.Object replace(org.python.Object hour, org.python.Object minute, org.python.Object second, org.python.Object microsecond, org.python.Object tzinfo) {
        if (hour == null) {
            hour = this.hour;
        }
        if (minute == null) {
            minute = this.minute;
        }
        if (second == null) {
            second = this.second;
        }
        if (microsecond == null) {
            microsecond = this.microsecond;
        }
        if (tzinfo == null) {
            tzinfo = this.tzinfo;
        }

        return new org.python.stdlib.datetime.Time(new org.python.Object[]{(org.python.types.Int) hour, (org.python.types.Int) minute, (org.python.types.Int) second, (org.python.types.Int) microsecond, tzinfo}, null);
    }

<<<<<<< HEAD
	 public Time(int hour, int minute, int second, int microsecond) {
         this.hour = org.python.types.Int.getInt(hour);
         this.minute = org.python.types.Int.getInt(minute);
         this.second = org.python.types.Int.getInt(second);
         this.microsecond = org.python.types.Int.getInt(microsecond);
     }
	 
=======
>>>>>>> origin/adriannurre
    @org.python.Method(
            __doc__ = "string -> time from time.isoformat() output",
            args = {"isoformat"}
    )
    public static org.python.Object fromisoformat(org.python.Object isoformat) {
        if (!(isoformat instanceof org.python.types.Str)) {
            throw new org.python.exceptions.TypeError("fromisoformat: argument must be str");
        }

        org.python.exceptions.ValueError valueError = new org.python.exceptions.ValueError("Invalid isoformat string: " + isoformat);
        String isoformatJavaString = isoformat.toString();

        if (isoformatJavaString.length() != 8 && isoformatJavaString.length() != 15) {
            throw valueError;
        }

        org.python.types.Int hour = null;
        org.python.types.Int minute = null;
        org.python.types.Int seconds = null;
        org.python.types.Int microseconds = null;

        try {
            hour = org.python.types.Int.getInt(Integer.parseInt(isoformatJavaString.substring(0, 2)));
            if (!isoformatJavaString.substring(2, 3).equals(":")) {
                throw valueError;
            }
            minute = org.python.types.Int.getInt(Integer.parseInt(isoformatJavaString.substring(3, 5)));
            if (!isoformatJavaString.substring(5, 6).equals(":")) {
                throw valueError;
            }
            seconds = org.python.types.Int.getInt(Integer.parseInt(isoformatJavaString.substring(6, 8)));
            if (isoformatJavaString.length() == 15) {
                if (!(isoformatJavaString.substring(8, 9).equals(":") || isoformatJavaString.substring(8, 9).equals("."))) {
                    throw valueError;
                }
                microseconds = org.python.types.Int.getInt(Integer.parseInt(isoformatJavaString.substring(9, 15)));
            }
        } catch (Exception e) {
            throw valueError;
        }

        org.python.stdlib.datetime.Time time = microseconds == null ? new org.python.stdlib.datetime.Time(new org.python.Object[]{hour, minute, seconds}, null) : new org.python.stdlib.datetime.Time(new org.python.Object[]{hour, minute, seconds, microseconds}, null);
        return time;

    }

    @org.python.Method(
            __doc__ = "Return str(self)."
    )
    public org.python.types.Str __str__() {
        return this.isoformat();
    }
}
