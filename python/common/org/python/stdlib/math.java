package python;

import java.lang.Math;

public class math extends org.python.types.Module {

@org.python.Method(
    __doc__ = "",
    args = {"val"}
)
    public static org.python.types.Float exp(org.python.types.Object val) {

        if(val instanceof org.python.types.Float){
            return new org.python.types.Float(Math.exp(((org.python.types.Float) val).value));
        }
        else  if(val instanceof org.python.types.Int){
            return new org.python.types.Float(Math.exp(((org.python.types.Int) val).value));
        }
        else if (val instanceof org.python.types.Bool){
            if (((org.python.types.Bool) val).value){
                return new org.python.types.Float(2.718281828459045);
            }
            else{
                return new org.python.types.Float(1.0);
            }
        }
        else if (val instanceof org.python.types.Str)
                throw new org.python.exceptions.TypeError(
                                "must be real number, not " + val.typeName()+""  
                );
        else {
            return new org.python.types.Float(1.0);


        }
    }
}








