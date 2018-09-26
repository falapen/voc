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

    @org.python.Attribute
    public static Int MIN_DAY = Int.getInt(1);
    @org.python.Attribute
    public static Int MAX_DAY = Int.getInt(31);

    @org.python.Attribute
    public static Int MIN_HOUR = Int.getInt(0);
    @org.python.Attribute
    public static Int MAX_HOUR = Int.getInt(23);

    @org.python.Attribute
    public static Int MIN_MIN = Int.getInt(0);
    @org.python.Attribute
    public static Int MAX_MIN = Int.getInt(59);

    @org.python.Attribute
    public static Int MIN_SEC = Int.getInt(0);
    @org.python.Attribute
    public static Int MAX_SEC = Int.getInt(59);

    @org.python.Attribute
    public static Int MIN_MS = Int.getInt(0);
    @org.python.Attribute
    public static Int MAX_MS = Int.getInt(999999);

    private Int year;
    private Int month;
    private Int day;
    private Int hour;
    private Int minute;
    private Int second;
    private Int ms;
    private Str tzinfo;

	@org.python.Method(
        __doc__ = "DateTime Constructor",
        default_args = {}
    )
    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

		//Init temp variables
		Int yearTemp = null;
		Int monthTemp = null;
		Int dayTemp = null;
        Int hourTemp = Int.getInt(0);
        Int minTemp = Int.getInt(0);
        Int secTemp = Int.getInt(0);
        Int msTemp = Int.getInt(0);

		//Too few arguments
        if ((args.length + kwargs.size()) < 3) {
            throw new org.python.exceptions.TypeError("Too few arguments.");
        }

		//Too many arguments
        if ((args.length + kwargs.size()) > 7) {
            throw new org.python.exceptions.TypeError("Too many arguments.");
        }

		//Set and validate all arguments

		//Year
		String strYear = "year";
		yearTemp = ((kwargs.get(strYear) == null && args.length >= 1) ? (Int) args[0] : (Int) kwargs.get(strYear));
		checkIntType(strYear, yearTemp);
		checkNull(strYear, yearTemp);
		checkIntRange(strYear, yearTemp, MIN_YEAR, MAX_YEAR);

		//Month
		String strMonth = "month";
		monthTemp = ((kwargs.get(strMonth) == null && args.length >= 2) ? (Int) args[1] : (Int) kwargs.get(strMonth));
		checkIntType(strMonth, monthTemp);
		checkNull(strMonth, monthTemp);
		checkIntRange(strMonth, monthTemp, MIN_MONTH, MAX_MONTH);

		//Day
		String strDay = "day";
		dayTemp = ((kwargs.get(strDay) == null && args.length >= 3) ? (Int) args[2] : (Int) kwargs.get(strDay));
		checkIntType(strDay, dayTemp);
		checkNull(strDay, dayTemp);
		checkIntRange(strDay, dayTemp, MIN_DAY, MAX_DAY);

		//Hour
		String strHour = "hour";
		hourTemp = ((kwargs.get(strHour) == null && args.length >= 4) ? (Int) args[3] : (Int) kwargs.get(strHour));
		if (hourTemp!=null) {
			checkIntType(strHour, hourTemp);
			checkIntRange(strHour, hourTemp, MIN_HOUR, MAX_HOUR);
		}

		//Minutes
		String strMin = "minute";
		minTemp = ((kwargs.get(strMin) == null && args.length >= 5) ? (Int) args[4] : (Int) kwargs.get(strMin));
		if (minTemp!=null) {
			checkIntType(strMin, minTemp);
			checkIntRange(strMin, minTemp, MIN_MIN, MAX_MIN);
		}

		//Second
		String strSec = "second";
		secTemp = ((kwargs.get(strSec) == null && args.length >= 6) ? (Int) args[5] : (Int) kwargs.get(strSec));
		if (secTemp!=null) {
			checkIntType(strSec, secTemp);
			checkIntRange(strSec, secTemp, MIN_SEC, MAX_SEC);
		}

		//MicroSecond
		String strMs = "microsecond";
		msTemp = ((kwargs.get(strMs) == null && args.length >= 7) ? (Int) args[6] : (Int) kwargs.get(strMs));
		if (msTemp!=null) {
			checkIntType(strMs, msTemp);
			checkIntRange(strMs, msTemp, MIN_MS, MAX_MS);
		}

		//Final assignment
		this.year = yearTemp;
        this.month = monthTemp;
        this.day = dayTemp;
        this.hour = hourTemp;
        this.minute = minTemp;
        this.second = secTemp;
        this.ms = msTemp;
		this.tzinfo = null;
	}

	@org.python.Method(
        __doc__ = "Checks a variable if it is of type Integers",
        default_args = {}
    )
	private void checkIntType(String varName, org.python.types.Object var) {
		if (!(var instanceof org.python.types.Int)) {
			throw new org.python.exceptions.TypeError("Wrong '" + varName + "'-type");
		}
	}

	@org.python.Method(
        __doc__ = "Checks a variable if it is in a specific range of Integers",
        default_args = {}
    )
	private void checkIntRange(String varName, org.python.types.Int var, org.python.types.Int min, org.python.types.Int max) {
        if (var.value < min.value || var.value > max.value) {
            throw new org.python.exceptions.ValueError(varName + " is Out of range");
        }
	}
}


