from unittest import expectedFailure

from ..utils import TranspileTestCase


class TimedeltaTests(TranspileTestCase):
    def test_c(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.timedelta(1))
            print(datetime.timedelta(10, 10, 5))
            print(datetime.timedelta(1, 2, 0, 0, 3, 2, 1))
            print(datetime.timedelta(days=10))
            print(datetime.timedelta(days=10.5))
            print(datetime.timedelta())
            # print(datetime.timedelta(seconds=a))
            print(datetime.timedelta(seconds=None))

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
            # TODO: Carrying over to days
            print(datetime.timedelta(microseconds=1, minutes=1, seconds=1, milliseconds=111111111111, hours=1))
            """)

    def test_totalSeconds(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.timedelta(minutes=1).total_seconds())
            """)