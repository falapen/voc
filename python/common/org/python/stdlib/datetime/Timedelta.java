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
        long rest = 0L;

        // region ==== PARSING ====
        int daysIndex = 0;
        int secondsIndex = 1;
        int microIndex = 2;
        int milliIndex = 3;
        int minutesIndex = 4;
        int hoursIndex = 5;
        int weeksIndex = 6;
        

        //weeks
        org.python.Object weeksKwargs= null;
        if (args.length > weeksIndex){
            weeksKwargs = args[weeksIndex];
        }
        else {
            weeksKwargs = kwargs.get("weeks");
        }
        if (weeksKwargs instanceof org.python.types.Int) {
            weeks = (Int) weeksKwargs;
        }
        else if (weeksKwargs instanceof org.python.types.Float){
            long weekToMicro = 604800000000L;
            weeks = Int.getInt((int)(((Float)weeksKwargs.__float__()).value));
            rest = rest + (long)(((((Float)weeksKwargs.__float__()).value) - weeks.value) * weekToMicro);
        }

        //days
        org.python.Object daysKwargs= null;
        if (args.length > daysIndex){
            daysKwargs = args[daysIndex];
        }
        else {
            daysKwargs = kwargs.get("days");
        }
        if (daysKwargs instanceof org.python.types.Int) {
            days = (Int) daysKwargs;
        }
        else if (daysKwargs instanceof org.python.types.Float){
            long daysToMicro = 86400000000L;
            days = Int.getInt((int)(((Float)daysKwargs.__float__()).value));
            rest = rest + (long)(((((Float)daysKwargs.__float__()).value) - days.value) * daysToMicro);
        }

        //seconds
        org.python.Object secondsKwargs= null;
        if (args.length > secondsIndex){
            secondsKwargs = args[secondsIndex];
        }
        else {
            secondsKwargs = kwargs.get("seconds");
        }
        if (secondsKwargs instanceof org.python.types.Int) {
            seconds = (Int) secondsKwargs;
        }
        else if (secondsKwargs instanceof org.python.types.Float){
            long secondsToMicro = 1000000;
            seconds = Int.getInt((int)(((Float)secondsKwargs.__float__()).value));
            rest = rest + (long)(((((Float)secondsKwargs.__float__()).value) - seconds.value) * secondsToMicro);
        }

        //microseconds
        org.python.Object microsecondsKwargs= null;
        if (args.length > microIndex){
            microsecondsKwargs = args[microIndex];
        }
        else {
            microsecondsKwargs = kwargs.get("microseconds");
        }
        if (microsecondsKwargs instanceof org.python.types.Int) {
            microseconds = (Int) microsecondsKwargs;
        }
        else if (microsecondsKwargs instanceof org.python.types.Float){
            long microToMicro = 1L;
            microseconds = Int.getInt((int)(((Float)microsecondsKwargs.__float__()).value));
            rest = rest + (long)(((((Float)microsecondsKwargs.__float__()).value) - microseconds.value) * microToMicro);
        }
        
        //milliseconds
        org.python.Object millisecondsKwargs= null;
        if (args.length > milliIndex){
            millisecondsKwargs = args[milliIndex];
        }
        else {
            millisecondsKwargs = kwargs.get("milliseconds");
        }
        if (millisecondsKwargs instanceof org.python.types.Int) {
            milliseconds = (Int) millisecondsKwargs;
        }
        else if (millisecondsKwargs instanceof org.python.types.Float){
            long milliToMicro = 1000L;
            milliseconds = Int.getInt((int)(((Float)millisecondsKwargs.__float__()).value));
            rest = rest + (long)(((((Float)millisecondsKwargs.__float__()).value) - milliseconds.value) * milliToMicro);
        }

        //minutes
        org.python.Object minutesKwargs= null;
        if (args.length > minutesIndex){
            minutesKwargs = args[minutesIndex];
        }
        else {
            minutesKwargs = kwargs.get("minutes");
        }
        if (minutesKwargs instanceof org.python.types.Int) {
            minutes = (Int) minutesKwargs;
        }
        else if (minutesKwargs instanceof org.python.types.Float){
            long minutesToMicro = 60000000L;
            minutes = Int.getInt((int)(((Float)minutesKwargs.__float__()).value));
            rest = rest + (long)(((((Float)minutesKwargs.__float__()).value) - minutes.value) * minutesToMicro);
        }
        
        //hours
        org.python.Object hoursKwargs= null;
        if (args.length > hoursIndex){
            hoursKwargs = args[hoursIndex];
        }
        else {
            hoursKwargs = kwargs.get("hours");
        }
        if (hoursKwargs instanceof org.python.types.Int) {
            hours = (Int) hoursKwargs;
        }
        else if (hoursKwargs instanceof org.python.types.Float){
            long hoursToMicro = 3600000000L;
            hours = Int.getInt((int)(((Float)hoursKwargs.__float__()).value));
            rest = rest + (long)(((((Float)hoursKwargs.__float__()).value) - hours.value) * hoursToMicro);
        }

        // endregion
        
        //add rest to microseconds
        microseconds = Int.getInt(microseconds.value + rest);

        // Normalize everything to days, seconds, microseconds.
        days = Int.getInt(days.value + (weeks.value * 7));
        seconds = Int.getInt(seconds.value + (minutes.value * 60 + hours.value * 3600));
        microseconds = Int.getInt(microseconds.value + (milliseconds.value * 1000));

        // TODO: Fractions

        // Carry over to seconds
        seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
        microseconds = Int.getInt(microseconds.value % 1000000);


        // Carry over to days as well
        days = Int.getInt(days.value + seconds.value / 86400);
        seconds = Int.getInt(seconds.value % 86400);


        this.days = days;
        this.seconds = seconds;
        this.microseconds = microseconds;
    }


    @org.python.Method(
        __doc__ = "Return the total number of seconds contained in the duration."
    )
    public org.python.types.Float total_seconds(){
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
