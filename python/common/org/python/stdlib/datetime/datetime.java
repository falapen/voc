package python;

@org.python.Module(
        __doc__ = "This module provides functions to manipulate datetime representations"
)
public class datetime extends org.python.types.Module {
    static {
        date = org.python.types.Type.pythonType(org.python.stdlib.datetime.Date.class);
        timedelta = org.python.types.Type.pythonType(org.python.stdlib.datetime.Timedelta.class);
        time = org.python.types.Type.pythonType(org.python.stdlib.datetime.Time.class);
	datetime = org.python.types.Type.pythonType(org.python.stdlib.datetime.DateTime.class);
    }

    public datetime() {
        super();
    }

    @org.python.Attribute
    public static org.python.Object date;
    @org.python.Attribute
    public static org.python.Object timedelta;
    @org.python.Attribute
    public static org.python.Object time;
}
