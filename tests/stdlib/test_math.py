import math

from unittest import expectedFailure
from ..utils import TranspileTestCase


class MathModuleTests(TranspileTestCase):

    #pow
    @expectedFailure
    def test_pow(self):
        self.assertCodeExecution("""
            import math
            for number in [3.0, 0, "tt", 4, 123123552499881882, 0.0000000001, True]:
                print(math.pow(number,2))
                print(math.pow(2,number))
            """)
    
    #log2
    @expectedFailure
    def test_log2(self):
        self.assertCodeExecution("""
            import math
            for number in [3.0, 0, "tt", 4, 123123552499881882, 0.0000000001, False]:
                print(math.log2(number))
            """)
    
    #exp
    @expectedFailure
    def test_exp(self):
        self.assertCodeExecution("""
            import math
            for number in [3.0, 0, "tt", 4, 123123552499881882, 0.0000000001, false]:
                print(math.exp(number))
            """)
        
            
    #factorial
    @expectedFailure
    def test_exp(self):
        self.assertCodeExecution("""
            import math
            for number in [3.0, 0, "tt", 4, 123123552499881882, 0.0000000001, false]:
                print(math.factorial(number))
            """)
