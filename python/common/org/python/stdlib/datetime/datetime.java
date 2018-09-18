package python;

@org.python.Module(
        __doc__ = "This module provides functions to manipulate datetime representations"
)
public class datetime extends org.python.types.Module {
    static {
        date = new org.python.stdlib.datetime.Date();
    }

    public datetime() {
        super();
    }

    /*
    @org.python.Method(
        __doc__ = "Returns a Date-object at the specified date",
        args = {"year", "month", "day"}
    )
    public static org.python.Object date(org.python.Object year, org.python.Object month, org.python.Object day) {
        return new org.python.stdlib.datetime.Date(year, month, day);
    }
    */

    @org.python.Attribute()
    public static org.python.stdlib.datetime.Date date;
}