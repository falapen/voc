from unittest import expectedFailure

from ..utils import TranspileTestCase


class TimedeltaTests(TranspileTestCase):
    def test_constructor(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.timedelta(1))
            print(datetime.timedelta(10, 10, 5))
            print(datetime.timedelta(1, 2, 0, 0, 3, 2, 1))
            print(datetime.timedelta(days=10))
            print(datetime.timedelta(days=10.5))
            print(datetime.timedelta())
            
            # args vs kwargs
            print(datetime.timedelta(20)) 
            print(datetime.timedelta(seconds=20))
            print(datetime.timedelta(seconds=20.05))
            print(datetime.timedelta(minutes=30))
            print(datetime.timedelta(minutes=30.004))
            print(datetime.timedelta(hours=20))
            print(datetime.timedelta(hours=20.91))

            print(datetime.timedelta(days=20))
            print(datetime.timedelta(weeks=20.5))
            print(datetime.timedelta(microseconds=2000000000))
            print(datetime.timedelta(milliseconds=20))
            print(datetime.timedelta(milliseconds=20.05))
            
            # Carrying over milliseconds to seconds
            print(datetime.timedelta(microseconds=1, minutes=1, seconds=1, milliseconds=11111, hours=1))
            print(datetime.timedelta(microseconds=1, minutes=1, seconds=1, milliseconds=111111111111, hours=1))
            
            # Boolean inputs
            print(datetime.timedelta(days=True, minutes=False))
            print(datetime.timedelta(True))
            print(datetime.timedelta(days=True, minutes =False, seconds = 11))
            
            # Mixed inputs
            print(datetime.timedelta(microseconds=True, minutes=1, seconds=1, milliseconds=11111, hours=1.5))
            print(datetime.timedelta(microseconds=1, minutes=1, seconds=1, milliseconds=111111111111, hours=False))

            """)
    
    @expectedFailure
    def test_t1(self):
        self.assertCodeExecution("""
            import datetime
            
            try:
                print(datetime.timedelta(2323232323223232332323200000000000))
            except TypeError as e:
                print (e)
            """)

    def test_constructor_inputs(self):
        self.assertCodeExecution("""
            import datetime

            #print(datetime.timedelta(a))
            
            try:
                print(datetime.timedelta(None))
            except TypeError as e:
                print (e)

            try:
                print(datetime.timedelta(None, 2, 3))
            except TypeError as e:
                print (e)

            try:
                print(datetime.timedelta(10, None, 3))
            except TypeError as e:
                print (e)

            try:
                print(datetime.timedelta(seconds=None))
            except TypeError as e:
                print (e)

            try:
                print(datetime.timedelta(days=2, seconds=33, weeks=None))
            except TypeError as e:
                print (e)

            """)

    def test_totalSeconds(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.timedelta(minutes=1).total_seconds())
            print(datetime.timedelta(weeks=1).total_seconds())
            print(datetime.timedelta(seconds=1).total_seconds())
            print(datetime.timedelta(days=1).total_seconds())
            print(datetime.timedelta(hours=1).total_seconds())
            
            print(datetime.timedelta(microseconds=10).total_seconds())
            print(datetime.timedelta(milliseconds=10).total_seconds())
            
            print(datetime.timedelta(seconds=1, days=1).total_seconds())
            print(datetime.timedelta(weeks=3, days=4, hours=13, minutes=26).total_seconds())
            
            # try:
            #     print(datetime.timedelta(minutes=None).total_seconds())
            # except TypeError as e:
            #     print(e)
            
            """)