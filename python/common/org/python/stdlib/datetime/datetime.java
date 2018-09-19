package python;

@org.python.Module(
        __doc__ = "This module provides functions to manipulate datetime representations"
)
public class datetime extends org.python.types.Module {
    static {
        date = org.python.types.Type.pythonType(org.python.stdlib.datetime.Date.class);
    }

    public datetime() {
        super();
    }

    @org.python.Attribute
    public static org.python.Object date;
}