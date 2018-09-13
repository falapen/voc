import math

from unittest import expectedFailure
from ..utils import TranspileTestCase


class MathModuleTests(TranspileTestCase):

    #pow
    @expectedFailure
    def test_pow(self):
        self.assertCodeExecution("""
            import math
            print(math.pow(2,2))
            """)
    
    #log2
    @expectedFailure
    def test_log2(self):
        self.assertCodeExecution("""
            import math
            print(math.log2(2))
            """)
    
    #exp
    @expectedFailure
    def test_exp(self):
        self.assertCodeExecution("""
            import math
            print(math.exp(1))
            """)