import math

from unittest import expectedFailure

from ..utils import TranspileTestCase


class MathModuleTests(TranspileTestCase):

	#######################################################
	# hypot
	@expectedFailure
	def test_hypot(self):
		self.assertCodeExecution("""
			import math
			print(math.hypot(3,4))
			""")

	#######################################################
	# degrees
	@expectedFailure
	def test_degrees(self):
		self.assertCodeExecution("""
			import math
			print(math.degrees(1))
			""")		


	#######################################################
	# radians
	@expectedFailure
	def test_radians(self):
		self.assertCodeExecution("""
			import math
			print(math.radians(180))
			""")



