import math

from unittest import expectedFailure
from ..utils import TranspileTestCase


#
# "tt", 4, 123123552499881882, 0.0000000001, False
class MathModuleTests(TranspileTestCase):

    #pow
    @expectedFailure
    def test_pow(self):
        self.assertCodeExecution("""
            import math
            for number in [2.0, 3, 21.05,"tt", 4, 123123552499881882, 0.0000000001, True]:
                print(math.pow(3,number))
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
    def test_exp(self):
        self.assertCodeExecution("""
            import math
            for number in [False, True, 10.5]:
                print(math.exp(number))
            """)

    @expectedFailure
    def test_exp2(self):
        self.assertCodeExecution("""
            import math
            for number in ["11", "123"]:
                print(math.exp(number))
            """)