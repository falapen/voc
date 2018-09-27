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

	def test_datetime_simple(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(2018, 10, 10)
            """)

    def test_datetime_simple2(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(1990,5,10)
            """)

    def test_datetime_simple3(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(1995,3,10)
            """)

    def test_datetime_simple_kwargs(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year=2018, month=10, day=10)
            """)

    def test_datetime_simple_kwargs2(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year=1990, month=5, day=10)
            """)

    def test_datetime_simple_kwargs3(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year=1995, month=3, day=10)
            """)

    def test_datetime_simple_kwargs4(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year = 1995, month = 1, day = 1, hour = 1)
            """)

    def test_datetime_simple_kwargs5(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year = 1995, month = 1, day = 1, hour = 1, minute = 1)
            """)

    def test_datetime_simple_kwargs6(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year = 1995, month = 1, day = 1, hour = 1, minute = 1, second = 1)
            """)


    def test_datetime_simple_kwargs7(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(year = 1995, month = 1, day = 1, hour = 1, minute = 1, second = 1, microsecond = 1)
            """)


    @expectedFailure
    def test_datetime_few_arg(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1,1))
            """)

    @expectedFailure
    def test_datetime_few_arg2(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1))
            """)

    @expectedFailure
    def test_datetime_many_arg(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2000,1,1,1,1,1,1,1,1))
            """)

    @expectedFailure
    def test_datetime_many_arg2(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,11,11,1,1,1,1,1,1))
            """)

    @expectedFailure
    def test_datetime_wrong_yeartype(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime("2018",1,1))
            """)

    @expectedFailure
    def test_datetime_year_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(-1,1,1))
            """)

    @expectedFailure
    def test_datetime_year_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(122018,1,1))
            """)

    @expectedFailure
    def test_datetime_wrong_monthtype(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,"1",1))
            """)

    @expectedFailure
    def test_datetime_month_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,-1,1))
            """)

    @expectedFailure
    def test_datetime_month_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,31,1))
            """)

    @expectedFailure
    def test_datetime_wrong_daytype(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,1,"1"))
            """)

    @expectedFailure
    def test_datetime_day_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,-1))
            """)

    @expectedFailure
    def test_datetime_day_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,31,41))
            """)

    @expectedFailure
    def test_datetime_hour_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,1,-1))
            """)

    @expectedFailure
    def test_datetime_hour_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,1,25))
            """)

    @expectedFailure
    def test_datetime_wrong_mintype(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,1,1,1,"1"))
            """)

    @expectedFailure
    def test_datetime_min_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,1,1,-1))
            """)

    @expectedFailure
    def test_datetime_min_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,1,1,61))
            """)


    @expectedFailure
    def test_datetime_wrong_sectype(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,1,1,1,1,"1"))
            """)

    @expectedFailure
    def test_datetime_sec_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,1,1,1,-1))
            """)

    @expectedFailure
    def test_datetime_sec_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(1990,1,1,1,1,61))
            """)

    @expectedFailure
    def test_datetime_wrong_mstype(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,1,1,1,1,1,"1"))
            """)

    @expectedFailure
    def test_datetime_ms_too_low(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,1,1,1,1,1,-11))
            """)

    @expectedFailure
    def test_datetime_ms_too_high(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018,1,1,1,1,1,1000000))
            """)

    def test_datetime_all_conc_args(self):
        self.assertCodeExecution("""            
            import datetime
            for year in range(1, 10000, 1000):
                for month in range(1, 12, 3):
                    for day in range(1, 28, 6):
                        for hour in range(0, 23, 4):
                            for min in range(0, 59, 18):
                                for sec in range(0, 59, 12):
                                    for ms in range(0, 1000000, 100000):
                                        d = datetime.datetime(year,month,day,hour,min,sec,ms)
            """)

    def test_datetime_all_conc_kwargs(self):
        self.assertCodeExecution("""            
            import datetime
            for y in range(1, 10000, 1000):
                for m in range(1, 12, 3):
                    for d in range(1, 28, 6):
                        for h in range(0, 23, 4):
                            for min in range(0, 59, 18):
                                for sec in range(0, 59, 12):
                                    for ms in range(0, 1000000, 100000):
                                        date = datetime.datetime(year = y, month = m, day = d, hour = h, minute = min, second = sec, microsecond = ms)
            """)

    @expectedFailure
    def test_datetime_utcfromtimestamp(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.utcfromtimestamp(0))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.utcfromtimestamp(1234567890))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.utcfromtimestamp(1234567890.123))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.utcfromtimestamp(-1234567890))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime.utcfromtimestamp(-1234567890.123))
            """)

    @expectedFailure
    def test_datetime_utcfromtimestamp_errors(self):

        self.assertCodeExecution("""
            import datetime
            try 
                print(datetime.datetime.utcfromtimestamp(100000000000))
            except TypeError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try 
                print(datetime.datetime.utcfromtimestamp(-100000000000))
            except ValueError as e:
                print(e)
            """)

        self.assertCodeExecution("""
            import datetime
            try
                print(datetime.datetime.utcfromtimestamp('0'))
            except ValueError as e:
                print(e)
            """)

    def test_datetime_class_attributes(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime.min
            """)

        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime.max
            """)

    def test_datetime_instance_get_attributes(self):

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1).year)
        """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1).month)
        """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1).day)
        """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1, 1).hour)
        """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1, 1, 1).minute)
        """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1, 1, 1, 1).second)
        """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.datetime(2018, 1, 1, 1, 1, 1, 1).microsecond)
        """)

    @expectedFailure
    def test_datetime_instance_set_attributes(self):

        self.assertCodeExecution("""
            import datetime
            y = datetime.datetime(2018, 1, 1)
            try:
                y.year = 2017
            except AttributeError as e:
                print(e)
        """)

        self.assertCodeExecution("""
            import datetime
            m = datetime.datetime(2018, 1, 1)
            try:
                m.month = 2
            except AttributeError as e:
                print (e)
        """)

        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(2018, 1, 1)
            try:
                d.day = 2
            except AttributeError as e:
                print(e)
        """)

        self.assertCodeExecution("""
            import datetime
            h = datetime.datetime(2018, 1, 1, 1)
            try:
                h.hour = 2
            except AttributeError as e
                print(e)
        """)

        self.assertCodeExecution("""
            import datetime
            m = datetime.datetime(2018, 1, 1, 1, 1)
            try:
                m.minute = 2
            except AttributeError as e
                print(e)
        """)

        self.assertCodeExecution("""
            import datetime
            s = datetime.datetime(2018, 1, 1, 1, 1, 1)
            try:
                s.second = 2
            except AttributeError as e
                print(e)
        """)

        self.assertCodeExecution("""
            import datetime
            m = datetime.datetime(2018, 1, 1, 1, 1, 1, 1)
            try:
                m.microsecond = 2
            except AttributeError as e
                print(e)
        """)

        self.assertCodeExecution("""
            import datetime
            t = datetime.datetime(2018, 1, 1)
            try:
                t.tzinfo = 1
            except AttributeError as e
                print(e)
        """)

    def test_datetime_instance_method_date(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(2018, 1, 1).date
        """)

    def test_datetime_instance_method_time(self):
        self.assertCodeExecution("""
            import datetime
            d = datetime.datetime(2018, 1, 1, 1, 1, 1, 1).time
        """)
			
