package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Str;

public class DateTime extends org.python.types.Object {

    @org.python.Attribute
    public static Int MIN_YEAR = Int.getInt(1);
    @org.python.Attribute
    public static Int MAX_YEAR = Int.getInt(10000);

    @org.python.Attribute
    public static Int MIN_MONTH = Int.getInt(1);
    @org.python.Attribute
    public static Int MAX_MONTH = Int.getInt(12);

    
    private Int year;
    private Int month;
    private Int day;
    private Int hour;
    private Int minute;
    private Int second;
    private Int ms;
    private Str tzinfo;

    

	@org.python.Method(
        __doc__ = "DateTime constructor",
        default_args = { }
    )
    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

		Int yearTemp = null;
		Int monthTemp = null;
		Int dayTemp = null;
        Int hourTemp = Int.getInt(0);
        Int minuteTemp = Int.getInt(0);
        Int secondTemp = Int.getInt(0);
        Int msTemp = Int.getInt(0);

		//Too few arguments
        if ((args.length + kwargs.size()) < 3) {
            throw new org.python.exceptions.TypeError("Too few arguments.");
        }

		//Too many arguments
        if ((args.length + kwargs.size()) > 8) {
            throw new org.python.exceptions.TypeError("Too many arguments.");
        }


		//Year
        org.python.Object kwYear = kwargs.get("year");




		if (kwYear==null) {
			yearTemp = (Int) args[0];
		}
		else {
			yearTemp = (Int) kwYear;
		}

		if (yearTemp==null) {
			throw new org.python.exceptions.TypeError("'year' not found");
		}

		if (!(yearTemp instanceof org.python.types.Int)) {
			throw new org.python.exceptions.TypeError("Wrong 'year'-type");
		}





		//valid?
		checkIntRange(yearTemp, MIN_YEAR, MAX_YEAR);

		//Month
		//dayTemp = (Int) args[1];
		//valid?

		//Day
		//dayTemp = (Int) args[2];
		//Hour
		//Minutes
		//Second
		//MicroSecond



		yearTemp = (Int) kwargs.get("year");
		monthTemp = (Int) kwargs.get("month");
		dayTemp = (Int) kwargs.get("day");
		hourTemp = (Int) kwargs.get("hour");
		minuteTemp = (Int) kwargs.get("minute");
		secondTemp = (Int) kwargs.get("second");
		msTemp = (Int) kwargs.get("microsecond");
		//Final assignment

		this.year = yearTemp;
        this.month = monthTemp;
        this.day = dayTemp;
        this.hour = hourTemp;
        this.minute = minuteTemp;
        this.second = secondTemp;
        this.ms = msTemp;
		this.tzinfo = null;
	}


	private void checkIntRange(org.python.types.Int var, org.python.types.Int min, org.python.types.Int max) {
        if (var.value < min.value || var.value > max.value) {
            throw new org.python.exceptions.ValueError("Out of range");
        }
	}
}


