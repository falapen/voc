package python;

import java.lang.Math;

@org.python.Module(
    __doc__ = "TODO"
)
public class math extends org.python.types.Module {
    @org.python.Method(
	__doc__ = "TODO",
	args = {"angle"}
    )
    public static org.python.types.Float sin(org.python.Object angle) {
	return new org.python.types.Float(Math.sin(((org.python.types.Float) angle.__float__()).value));
    }

    @org.python.Method(
	__doc__ = "TODO",
	args = {"angle"}
    )
    public static org.python.types.Float cos(org.python.Object angle) {
	return new org.python.types.Float(Math.cos(((org.python.types.Float) angle.__float__()).value));
    }

    @org.python.Method(
	__doc__ = "TODO",
	args = {"angle"}
    )
    public static org.python.types.Float tan(org.python.Object angle) {
        return new org.python.types.Float(Math.tan(((org.python.types.Float) angle.__float__()).value));
    }
}
