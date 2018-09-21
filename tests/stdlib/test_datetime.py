from unittest import expectedFailure

from ..utils import TranspileTestCase


class TimedeltaTests(TranspileTestCase):

    def test_creation(self):
        self.assertCodeExecution("""
            import datetime

            # print(datetime.timedelta(seconds="abc"))
            # print(datetime.timedelta(seconds=a))
            # print(datetime.timedelta(seconds=None))

            # # args vs kwargs
            # print(datetime.timedelta(20)) 
            print(datetime.timedelta(seconds=20))
            print(datetime.timedelta(minutes=30))
            print(datetime.timedelta(hours=20))

            print(datetime.timedelta(days=20))
            print(datetime.timedelta(weeks=20))
            print(datetime.timedelta(microseconds=20))
            print(datetime.timedelta(milliseconds=20))
            
            # Carrying over milliseconds to seconds
            print(datetime.timedelta(microseconds=1, minutes=1, seconds=1, milliseconds=11111, hours=1))
            # TODO: Carrying over to days
            # print(datetime.timedelta(microseconds=1, minutes=1, seconds=1, milliseconds=111111111111, hours=1))
            """)

    @expectedFailure
    def test_totalSeconds(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.total_seconds(datetime.timedelta(minutes=1)))
            """)