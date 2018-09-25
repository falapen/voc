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

    def test_date_constructor_errors(self):
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

    def test_date_class_attributes(self):
        self.assertCodeExecution("""
            import datetime
            datetime.date.min
            """)

        self.assertCodeExecution("""
            import datetime
            datetime.date.max
            """)

        self.assertCodeExecution("""
            import datetime
            datetime.date.resolution
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

