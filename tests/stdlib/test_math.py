from unittest import expectedFailure

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    #######################################################
    # sin
    @expectedFailure
    def test_sin(self):
        self.assertCodeExecution("""
            import math
            print(math.sin(1))
            """)
