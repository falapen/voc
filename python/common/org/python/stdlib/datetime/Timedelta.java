package org.python.stdlib.datetime;
import org.python.types.Int;
import org.python.types.Float;
import org.python.types.Str;
import org.python.types.Bool;

public class Timedelta extends org.python.types.Object {
    private Int days;
    private Int seconds;
    private Int microseconds;

    @org.python.Attribute
    public static org.python.Object min =
        new Timedelta(Int.getInt(-999999999), Int.getInt(0), Int.getInt(0));

    @org.python.Attribute
    public static org.python.Object max =
        new Timedelta(Int.getInt(999999999), Int.getInt(82800 + 3540 + 59), Int.getInt(999999));
    //days=999999999, hours=23, minutes=59, seconds=59, microseconds=999999

    @org.python.Attribute
    public static org.python.Object resolution =
        new Timedelta(Int.getInt(0), Int.getInt(0), Int.getInt(1));
    @org.python.Method(
        __doc__ = "Difference between two datetime values.",
        args = {"day"}
    )
    public Timedelta(org.python.Object day) {
        super();
        this.days = (org.python.types.Int) day;
    }

    @org.python.Method(
        __doc__ = "Timedelta TODO",
        default_args = {}
    )
    private Timedelta(Int days, Int seconds, Int microseconds) {
        // Carry over to seconds
        if (microseconds.value < 0) {
            seconds = Int.getInt(seconds.value - (1 + (microseconds.value / 1000000)));
            microseconds = Int.getInt(1000000 + (microseconds.value % 1000000));
        } else {
            seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
            microseconds = Int.getInt(microseconds.value % 1000000);
        }

        // Carry over to days as well
        if (seconds.value < 0) {
            days = Int.getInt(-1 + days.value + (seconds.value / 86400));
            seconds = Int.getInt(86400 + (seconds.value % 86400));
        } else {
            days = Int.getInt(days.value + seconds.value / 86400);
            seconds = Int.getInt(seconds.value % 86400);
        }

        this.days = days;
        this.seconds = seconds;
        this.microseconds = microseconds;
    }

    @org.python.Method(
        __doc__ = "timedelta([days[, seconds[, microseconds[, milliseconds[, minutes[, hours[, weeks]]]]]]]) -->\n" +
            "--> A timedelta object that represents a duration, the differences between two dates or time.\n" +
            "\n" +
            "Only days, seconds and microseconds are stored internally. Arguments are converted to those units:\n" +
            "    - A millisecond is converted to 1000 microseconds.\n" +
            "    - A minute is converted to 60 seconds.\n" +
            "    - An hour is converted to 3600 seconds.\n" +
            "    - A week is converted to 7 days.\n" +
            "and days, seconds and microseconds are then normalized so that the representation is unique, with\n" +
            "      0 <= microseconds < 1000000\n" +
            "      0 <= seconds < 3600*24 (the number of seconds in one day)\n" +
            "      -999999999 <= days <= 999999999\n" +
            "If any argument is a float and there are fractional microseconds, the fractional microseconds left\n" +
            "over from all arguments are combined and their sum is rounded to the nearest microsecond.\n" +
            "If no argument is a float, the conversion and normalization processes are exact (no information is lost).\n" +
            "\n",
        default_args = {}
        //default_args = {"days", "seconds", "microseconds", "milliseconds", "minutes", "hours", "weeks"}
    )
    public Timedelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

        Int days = Int.getInt(0);
        Int seconds = Int.getInt(0);
        Int microseconds = Int.getInt(0);
        Int milliseconds = Int.getInt(0);
        Int minutes = Int.getInt(0);
        Int hours = Int.getInt(0);
        Int weeks = Int.getInt(0);
        long rest = 0L;
        // TODO: overflow

        double[] toMicro = {86400000000.0, 1000000.0, 1.0, 1000.0, 60000000.0, 3600000000.0, 604800000000.0};
        String[] paramError = {"days", "seconds", "microseconds", "milliseconds", "minutes", "hours", "weeks"};
        Int[] params = {days, seconds, microseconds, milliseconds, minutes, hours, weeks};

        if (args.length > 7) {
            throw new org.python.exceptions.TypeError(
                "__new__() takes at most 7 arguments (" + args.length + " given)");
        }

        //Not valid types
        for (int i = 0; i < args.length; i++) {
            if (!(args[i] instanceof org.python.types.Int ||
                args[i] instanceof org.python.types.Bool ||
                args[i] instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError(
                    "unsupported type for timedelta " + paramError[i] + " component: " + args[i].typeName());
            }
        }

        for (int i = 0; i < paramError.length; i++) {
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null) {
                if (!(kwarg instanceof org.python.types.Int ||
                    kwarg instanceof org.python.types.Bool ||
                    kwarg instanceof org.python.types.Float)) {
                    throw new org.python.exceptions.TypeError(
                        "unsupported type for timedelta " + paramError[i] + " component: " + kwarg.typeName());
                }
            }
        }

        //Bool inputs
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof org.python.types.Bool) {
                boolean value = ((Bool) args[i]).value;
                if (value) {
                    params[i] = Int.getInt(1);
                }
            }
        }

        for (int i = 0; i < paramError.length; i++) {
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null) {
                if (kwarg instanceof org.python.types.Bool) {
                    boolean value = ((Bool) kwarg).value;
                    if (value) {
                        params[i] = Int.getInt(1);
                    }
                }
            }
        }

        //Integers
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof org.python.types.Int) {
                params[i] = (Int) args[i];
            }
        }

        for (int i = 0; i < paramError.length; i++) {
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null) {
                if (kwarg instanceof org.python.types.Int) {
                    params[i] = (Int) kwarg;
                }
            }
        }

        //Floats
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof org.python.types.Float) {
                params[i] = Int.getInt((int) (((Float) args[i].__float__()).value));
                rest = rest + (long) ((Math.round(100000000000L * ((((Float) args[i].__float__()).value) - params[i].value)) * toMicro[i]) / 100000000000L);
            }
        }

        for (int i = 0; i < paramError.length; i++) {
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null) {
                if (kwarg instanceof org.python.types.Float) {
                    params[i] = Int.getInt((int) (((Float) kwarg.__float__()).value));
                    rest = rest + (long) ((Math.round(100000000000L * ((((Float) kwarg.__float__()).value) - params[i].value)) * toMicro[i]) / 100000000000L);
                }
            }
        }

        days = params[0];
        seconds = params[1];
        microseconds = params[2];
        milliseconds = params[3];
        minutes = params[4];
        hours = params[5];
        weeks = params[6];

        //add rest to microseconds
        microseconds = Int.getInt(microseconds.value + rest);

        // Normalize everything to days, seconds, microseconds.
        days = Int.getInt(days.value + (weeks.value * 7));
        seconds = Int.getInt(seconds.value + (minutes.value * 60 + hours.value * 3600));
        microseconds = Int.getInt(microseconds.value + (milliseconds.value * 1000));

        // Carry over to seconds
        if (microseconds.value < 0) {
            seconds = Int.getInt(seconds.value - (1 + (microseconds.value / 1000000)));
            microseconds = Int.getInt(1000000 + (microseconds.value % 1000000));
        } else {
            seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
            microseconds = Int.getInt(microseconds.value % 1000000);
        }

        // Carry over to days as well
        if (seconds.value < 0) {
            days = Int.getInt(-1 + days.value + (seconds.value / 86400));
            seconds = Int.getInt(86400 + (seconds.value % 86400));
        } else {
            days = Int.getInt(days.value + seconds.value / 86400);
            seconds = Int.getInt(seconds.value % 86400);
        }

        this.days = days;
        this.seconds = seconds;
        this.microseconds = microseconds;
    }

    @org.python.Method(
        __doc__ = "Return the total number of seconds contained in the duration. Note that for very large "
            + "\n" + "time intervals (greater than 270 years on most platforms) this method will lose microsecond accuracy."
    )
    public org.python.types.Float total_seconds() {
        //(td.microseconds + (td.seconds + td.days * 24 * 3600) * 10**6) / 10**6 computed with true division enabled.
        return new org.python.types.Float((this.microseconds.value + (this.seconds.value + this.days.value * 86400.0) * 1000000.0) / 1000000.0);
    }

    @org.python.Method(
        __doc__ = "Returns a timedelta object with the same value."
    )
    public Timedelta __pos__() {
        return this;
    }

    @org.python.Method(
        __doc__ = "Equivalent to timedelta(-t1.days, -t1.seconds, -t1.microseconds), and to t1* -1."
    )
    public Timedelta __neg__() {
        Int days = Int.getInt(-this.days.value);
        Int seconds = Int.getInt(-this.seconds.value);
        Int microseconds = Int.getInt(-this.microseconds.value);
        return new Timedelta(days, seconds, microseconds);
    }

    @org.python.Method(
        __doc__ = "Return str(self)."
    )
    public Str __str__() {
        long mm = this.seconds.value / 60;
        long ss = this.seconds.value % 60;
        long hh = mm / 60;
        mm = mm % 60;

        String result = String.format("%d:%02d:%02d", hh, mm, ss);

        if (this.days.value > 0) {
            result = String.format(
                "%d day%s, %s",
                this.days.value,
                this.days.value > 1 ? "s" : "",
                result
            );
        }

        if (this.days.value < 0) {
            result = String.format(
                "%d day%s, %s",
                this.days.value,
                this.days.value < -1 ? "s" : "",
                result
            );
        }

        if (this.microseconds.value > 0) {
            result = String.format(
                "%s.%06d",
                result,
                this.microseconds.value
            );
        }

        return new Str(result);
    }
}
