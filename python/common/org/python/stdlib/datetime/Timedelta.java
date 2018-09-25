package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Float;
import org.python.types.Str;
import org.python.types.Bool;

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
        // TODO: overflow
        
        long[] toMicro = {86400000000L, 1000000L, 1L, 1000L, 60000000L, 3600000000L, 604800000000L};
        String[] paramError = {"days", "seconds", "microseconds", "milliseconds", "minutes", "hours", "weeks"};
        Int[] params = {days, seconds, microseconds, milliseconds, minutes, hours, weeks};

        //Not valid types 
        for (int i = 0; i < args.length; i++){
            if (!(args[i] instanceof org.python.types.Int || 
                args[i] instanceof org.python.types.Bool || 
                args[i] instanceof org.python.types.Float)) {
                throw new org.python.exceptions.TypeError(
                    "unsupported type for timedelta " + paramError[i] + " component: " + args[i].typeName()+"");
            }
        }

        for (int i = 0; i < paramError.length; i++){
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null){
                if (!(kwarg instanceof org.python.types.Int ||
                    kwarg instanceof org.python.types.Bool ||
                    kwarg instanceof org.python.types.Float)) {
                    throw new org.python.exceptions.TypeError(
                        "unsupported type for timedelta " + paramError[i] + " component: " + kwarg.typeName()+"");
                }
            }     
        }

        //Bool inputs
        for (int i = 0; i < args.length; i++){
            if (args[i] instanceof org.python.types.Bool){     
                boolean value = ((Bool) args[i]).value;
            if(value){
                params[i] = Int.getInt(1);
            }
            }
        }
        
        for (int i = 0; i < paramError.length; i++){
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null){
                if (kwarg instanceof org.python.types.Bool){
                    boolean value = ((Bool) kwarg).value;
                    if(value){
                        params[i] = Int.getInt(1);
                    }
                }
            }     
        }
        
        //Integers
        for (int i = 0; i < args.length; i++){
            if (args[i] instanceof org.python.types.Int){     
                params[i] = (Int) args[i];
            }
        }
        
        for (int i = 0; i < paramError.length; i++){
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null){
                if (kwarg instanceof org.python.types.Int){
                    params[i] = (Int) kwarg;
                }
            }     
        }

        //Floats
        for (int i = 0; i < args.length; i++){
            if (args[i] instanceof org.python.types.Float){     
            params[i] = Int.getInt((int)(((Float)args[i].__float__()).value));
            rest = rest + (long)(((((Float)args[i].__float__()).value) - params[i].value) * toMicro[i]);
            }
        }
        
        for (int i = 0; i < paramError.length; i++){
            org.python.Object kwarg = kwargs.get(paramError[i]);
            if (kwarg != null){
                if (kwarg instanceof org.python.types.Float){     
                    params[i] = Int.getInt((int)(((Float)kwarg.__float__()).value));
                    rest = rest + (long)(((((Float)kwarg.__float__()).value) - params[i].value) * toMicro[i]);
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
        return new org.python.types.Float((this.microseconds.value + (this.seconds.value + this.days.value*86400.0)*1000000.0)/1000000.0);
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
