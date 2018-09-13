package python;

import java.lang.Math;

@org.python.Module(
    __doc__ = "'This module is always available.  It provides access to the\nmathematical functions defined by the C standard.'"
)
public class math extends org.python.types.Module {
    
	@org.python.Method(
	__doc__ = "Convert angle x from radians to degrees.",
	args = {"angle"}
    )    
	public static org.python.types.Float degrees(org.python.Object angle) {
    	return new org.python.types.Float(Math.toDegrees(((org.python.types.Float) angle. __float__()).value));
    }

    @org.python.Method(
	__doc__ = "Convert angle x from degrees to radians.",
	args = {"angle"}
    )    
	public static org.python.types.Float radians(org.python.Object angle) {
    	return new org.python.types.Float(Math.toRadians(((org.python.types.Float) angle. __float__()).value));
    }

    @org.python.Method(
	__doc__ = "Return the Euclidean norm, sqrt(x*x + y*y). This is the length of the vector from the origin to point (x, y).",
	args = {"value, value"}
    )    
	public static org.python.types.Float hypot(org.python.Object x, org.python.Object y) {
    	return new org.python.types.Float(Math.hypot(((org.python.types.Float) x. __float__()).value, ((org.python.types.Float) y. __float__()).value));
    } 

}















