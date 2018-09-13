package python;

import java.lang.Math;

@org.python.Module(
    __doc__ = "'This module is always available.  It provides access to the\nmathematical functions defined by the C standard.'"
)
public class math extends org.python.types.Module {
    @org.python.Method(
	__doc__ = "sin(x)\n\nReturn the sine of x (measured in radians).",
	args = {"angle"}
    )
    public static org.python.types.Float sin(org.python.Object angle) {
	return new org.python.types.Float(Math.sin(((org.python.types.Float) angle.__float__()).value));
    }

    @org.python.Method(
	__doc__ = "cos(x)\n\nReturn the cosine of x (measured in radians).",
	args = {"angle"}
    )
    public static org.python.types.Float cos(org.python.Object angle) {
	return new org.python.types.Float(Math.cos(((org.python.types.Float) angle.__float__()).value));
    }

    @org.python.Method(
	__doc__ = "tan(x)\n\nReturn the tangent of x (measured in radians).",
	args = {"angle"}
    )
    public static org.python.types.Float tan(org.python.Object angle) {
        return new org.python.types.Float(Math.tan(((org.python.types.Float) angle.__float__()).value));
    }

    @org.python.Method(
            __doc__ = "Returns the smallest integer larger than or equal to 'value'.",
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
            __doc__ = "Returns the largest integer smaller than or equal to 'value'.",
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
            __doc__ = "Returns the square-root of 'value'",
            args = {"value"}
    )
    public static org.python.types.Object sqrt(org.python.types.Object value) {
        double val = 0; 
        if(value instanceof org.python.types.Float) {
            val = Math.sqrt(((org.python.types.Float) value).value);
        } else if(value instanceof org.python.types.Int) {
            val = Math.sqrt((double)((org.python.types.Int) value).value);
        }
        return new org.python.types.Float(val);
    }
}
