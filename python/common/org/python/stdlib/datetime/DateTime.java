package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Str;

public class DateTime extends org.python.types.Object {

    @org.python.Attribute
    public static Int MINYEAR = Int.getInt(1);
    @org.python.Attribute
    public static Int MAXYEAR = Int.getInt(9999);

    
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


		yearTemp = (Int) args[0];
		monthTemp = (Int) args[1];
		dayTemp = (Int) args[2];

		//Validite the three main required arguments year, month, day
        if (yearTemp == null || monthTemp == null || dayTemp == null) {
            throw new org.python.exceptions.TypeError("Invalid arguments");
        }



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
}



