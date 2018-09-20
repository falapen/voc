from unittest import expectedFailure
from ..utils import TranspileTestCase


class DatetimeModuleTests(TranspileTestCase): 
    def test_date_constructor_sanity(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 10, 10))
            """)

    def test_date_repr(self): 
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 10, 10).__repr__())
        """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 1, 1).__repr__())
        """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(1, 1, 1).__repr__())
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
    
    @expectedFailure
    def test_date_constructor_errors_sanity(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(0, 0, 0))
            """)
        
    @expectedFailure
    def test_date_constructor_errors(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(10000, 13, 32))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, 2, 29))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2016, 2, 29))
            """)
        self.assertCodeExecution("""
            import datetime
            print(datetime.date(2018, -1, 16))
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
        # self.assertCodeExecution("""
        #     import datetime
        #     print(datetime.date.fromtimestamp('1'))
        #     """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(1000000000000))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(-1000000000000))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(10000000000000000))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(-10000000000000000))
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
            for x in range (1, 8):
                print(datetime.date(2018, 1, x).isoweekday())
            """)

    def test_date_isocalendar(self):
        self.assertCodeExecution("""
            import datetime
            for x in [datetime.date(1970, 1, 1), datetime.date(2018, 12, 31), datetime.date(1, 1, 1)]:
                x.isocalendar()
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
