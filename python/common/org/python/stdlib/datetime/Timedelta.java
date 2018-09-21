package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Float;
import org.python.types.Str;

public class Timedelta extends org.python.types.Object {
    private Int days;
    private Int seconds;
    private Int microseconds;
 

    @org.python.Method(
        __doc__ = "Timedelta TODO",
        default_args = {}
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
        Float rest = new Float(0);

        // region ==== PARSING ====

       /* 
        if (!(args[0] instanceof org.python.types.NoneType)){
            days = (Int) args[0];
        }
        */

        org.python.Object daysKwargs = kwargs.get("days");
        if (daysKwargs instanceof org.python.types.Int) {
            //days = (Int) daysKwargs;
        }
        if (daysKwargs instanceof org.python.types.Float){
            Int dayToMicro = Int.getInt(24*60*60*1000000);
            days = Int.getInt((int)(((Float)daysKwargs.__float__()).value));
            rest =  (Float) daysKwargs.__sub__(days.__truediv__(dayToMicro));
        }

        org.python.Object secondsKwargs = kwargs.get("seconds");
        if (secondsKwargs instanceof org.python.types.Int) {
            seconds = (Int) secondsKwargs;
        }
        org.python.Object microsecondsKwargs = kwargs.get("microseconds");
        if (microsecondsKwargs instanceof org.python.types.Int) {
            microseconds = (Int) microsecondsKwargs;
        }
        org.python.Object millisecondsKwargs = kwargs.get("milliseconds");
        if (millisecondsKwargs instanceof org.python.types.Int) {
            milliseconds = (Int) millisecondsKwargs;
        }
        org.python.Object minutesKwargs = kwargs.get("minutes");
        if (minutesKwargs instanceof org.python.types.Int) {
            minutes = (Int) minutesKwargs;
        }
        org.python.Object hoursKwargs = kwargs.get("hours");
        if (hoursKwargs instanceof org.python.types.Int) {
            hours = (Int) hoursKwargs;
        }
        org.python.Object weeksKwargs = kwargs.get("weeks");
        if (weeksKwargs instanceof org.python.types.Int) {
            weeks = (Int) weeksKwargs;
        }


        // endregion

        // Normalize everything to days, seconds, microseconds.
        days = Int.getInt(days.value + (weeks.value * 7));
        seconds = Int.getInt(seconds.value + (minutes.value * 60 + hours.value * 3600));
        microseconds = Int.getInt(microseconds.value + (milliseconds.value * 1000));

        // TODO: Fractions

        seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
        microseconds = Int.getInt(microseconds.value % 1000000);

        // TODO: Carry over to days as well

        this.days = days;
        this.seconds = seconds;
        this.microseconds = microseconds;
    }

    @org.python.Method(
        __doc__ = "Return the total number of seconds contained in the duration."
    )
    public org.python.types.Float totalSeconds(){
        //(td.microseconds + (td.seconds + td.days * 24 * 3600) * 10**6) / 10**6 computed with true division enabled.
        return new org.python.types.Float((this.microseconds.value + (this.seconds.value + this.days.value*86400)*1000000)/1000000);
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
