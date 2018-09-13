package python;

import java.lang.Math;

@org.python.Module(
        __doc__ = "Math-things"
    )

public class math extends org.python.types.Module {

    @org.python.Method(
            __doc__ = "Create and return a new object.  See help(type) for accurate signature.",
            args = {"value"}
    )
    public static org.python.types.Object ceil(org.python.types.Object value) {
        int val = 0; 
        if(value instanceof org.python.types.Float) {
            val = (int) Math.ceil(((org.python.types.Float) value).value);
        }
        return org.python.types.Int.getInt(val);
    }

    @org.python.Method(
            __doc__ = "Create and return a new object.  See help(type) for accurate signature.",
            args = {"value"}
    )
    public static org.python.types.Object floor(org.python.types.Object value) {
        int val = 0; 
        if(value instanceof org.python.types.Float) {
            val = (int) Math.floor(((org.python.types.Float) value).value);
        }
        return org.python.types.Int.getInt(val);
    }
    
    @org.python.Method(
            __doc__ = "Create and return a new object.  See help(type) for accurate signature.",
            args = {"value"}
    )
    public static /*org.python.types.Object*/double sqrt(org.python.types.Object value) {
        double val = 0; 
        if(value instanceof org.python.types.Float) {
            val = Math.sqrt(((org.python.types.Float) value).value);
        }
        return val;
    }
}
