from unittest import expectedFailure

from ..utils import TranspileTestCase


class DatetimeModuleTests(TranspileTestCase):
    def test_date_constructor_sanity(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 10, 10))
            """)

    def test_date_constructor_thorough(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 10, 10))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 1, 1))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 12, 31))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(20, 3, 6))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(1, 1, 1))
            """)

    def test_date_constructor_errors_sanity(self):
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(0, 10, 10)
            except ValueError as e:
                print(e)
            """)

    def test_date_constructor_value_errors(self):
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(10000, 13, 32)
            except ValueError as e:
                print(e)
            """)
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(2018, 2, 29)
            except ValueError as e:
                print(e)
            """)
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(2016, 2, 29)
            except ValueError as e:
                print(e)
            """)
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(2018, -1, 16)
            except ValueError as e:
                print(e)
            """)

    def test_date_constructor_type_errors(self):
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(2, "asddf", 3)
            except TypeError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date("asddf", 2, 3)
            except TypeError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(2, 3, "asddf")
            except TypeError as e:
                print(e)
            """)

    def test_date_fromtimestamp(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(0))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(1537283188.184869))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(1537283188))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(-86400))
            """)

    def test_date_fromtimestamp_errors(self):
        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.date.fromtimestamp('1'))
            except TypeError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.date.fromtimestamp(1000000000000))
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.date.fromtimestamp(-1000000000000))
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.date.fromtimestamp(10000000000000000))
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.date.fromtimestamp(-10000000000000000))
            except ValueError as e:
                print(e)
            """)

    def test_date_weekday(self):
        self.assertCodeExecution("""
            import datetime
            for x in range (1, 8):
                print(datetime.date(2018, 1, x).weekday())
            """)

    def test_date_isoweekday(self):
        self.assertCodeExecution("""
            import datetime
            import datetime
            for x in range (1, 8):
                print(datetime.date(2018, 1, x).isoweekday())
            """)

    def test_date_get_attributes(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 12, 10).year)
        """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 12, 10).month)
        """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 12, 10).day)
        """)

    def test_date_set_attributes(self):
        self.assertCodeExecution("""
            import datetime
            a = datetime.date(2018, 12, 10)
            try:
                a.year = 2000
            except AttributeError as e:
                print(e)
        """)
        self.assertCodeExecution("""
            import datetime
            a = datetime.date(2018, 12, 10)
            try:
                a.month = 10
            except AttributeError as e:
                print(e)
        """)
        self.assertCodeExecution("""
            import datetime
            a = datetime.date(2018, 12, 10)
            try:
                a.day = 20
            except AttributeError as e:
                print(e)
        """)

    @expectedFailure
    def test_date_isocalendar(self):
        self.assertCodeExecution("""
            import datetime
            for x in [datetime.date(1970, 1, 1), datetime.date(2018, 12, 31), datetime.date(1, 1, 1)]:
                print(x.isocalendar())
            """)

    @expectedFailure
    def test_date_class_attributes(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date.min)
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.max)
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.resolution)
            """)

    def test_time_constructor(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.time(0,0,0,0))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time(23,59,59,999999))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time(12,30,0,5000))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time(22,0,5,0))
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                datetime.time(25,0,0,0)
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                datetime.time(0,61)
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                datetime.time(0,0,-1,0)
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                datetime.time(0,0,0,-10000000)
            except ValueError as e:
                print(e)
            """)

    @expectedFailure
    def test_time_class_attributes(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.time.min)
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.max)
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.resolution)
            """)

    def test_time_instance_attributes(self):
        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(1,2,3,4)
            print(foo.hour)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(1,2,3,4)
            print(foo.minute)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(1,2,3,4)
            print(foo.second)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(1,2,3,4)
            print(foo.microsecond)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(1,2,3,4)
            print(foo.tzinfo)
            """)

    def test_time_isoformat(self):
        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(1,2,3,4)
            print(foo.isoformat())
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(0,0,0,1000)
            print(foo.isoformat())
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(0,0,0,0)
            print(foo.isoformat())
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(23,59,59,999999)
            print(foo.isoformat())
            """)
        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(12,30,0,0)
            print(foo.isoformat())
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(0,0,1,0)
            print(foo.isoformat())
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            print(foo.isoformat())
            """)

    def test_time_replace(self):
        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            bar = foo.replace(0,0,0,0)
            print(foo)
            print(bar)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            bar = foo.replace(12,12,12,4287)
            print(foo)
            print(bar)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            bar = foo.replace(12)
            print(foo)
            print(bar)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            bar = foo.replace(second=59)
            print(foo)
            print(bar)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            bar = foo.replace(microsecond=59, hour=12)
            print(foo)
            print(bar)
            """)

        self.assertCodeExecution("""
            import datetime
            foo = datetime.time(10,10,10,120)
            bar = foo.replace(12, second=0)
            print(foo)
            print(bar)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                foo = datetime.time(10,10,10,120)
                bar = foo.replace(24,0,0,0)
                print(foo)
                print(bar)
            except ValueError as e:
                print(e)
            """)

    def test_time_fromisoformat(self):
        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.time.fromisoformat("abc"))
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.time.fromisoformat(123))
            except Exception as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.time.fromisoformat("12-30:00.000300"))
            except Exception as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try:
                print(datetime.time.fromisoformat("12:30:00:000003"))
            except Exception as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.fromisoformat("12:30:00.000400"))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.fromisoformat("00:00:00"))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.fromisoformat("12:32:32"))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.fromisoformat("23:59:59.999999"))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.time.fromisoformat("10:30:50.000020"))
            """)

    def test_timedelta_constructor(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.timedelta(1))
            print(datetime.timedelta(10, 10, 5))
            print(datetime.timedelta(1, 2, 0, 0, 3, 2, 1))
            print(datetime.timedelta(1, -36000, -500000, 0, 0, 0, 0))
            print(datetime.timedelta(1, -2, 0, 0, 3, -2, 1))
            print(datetime.timedelta(days=10))
            print(datetime.timedelta(days=10.5))
            print(datetime.timedelta(days=1.2))
            print(datetime.timedelta())

            # args vs kwargs
            print(datetime.timedelta(-20))
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

    def test_timedelta_constructor_inputs(self):
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

            try:
                print(datetime.timedelta(1, 2, 0, 0, 3, 2, 1, 8))
            except TypeError as e:
                print (e)

            """)

    def test_timedelta_pos(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.timedelta(99)
            print(+d)
            y = datetime.timedelta(weeks = 15, days = -4, seconds = -36000, microseconds = -500000)
            print(-y)
            """)

    def test_timedelta_neg(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.timedelta(99, 13, 4, 1, -1, 2, 8)
            print(-d)
            y = datetime.timedelta(weeks = 15, days = -4, seconds = -36000, microseconds = -500000)
            print(-y)
            """)

    @expectedFailure
    def test_timedelta_attributes(self):
        self.assertCodeExecution("""
            import datetime

            print(datetime.timedelta.max)
            print(datetime.timedelta.min)
            print(datetime.timedelta.resolution)
            """)

    def test_timedelta_totalSeconds(self):
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
