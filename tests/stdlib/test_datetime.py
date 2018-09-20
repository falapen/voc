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
    
    @expectedFailure
    def test_date_constructor_errors_sanity(self):
        self.assertCodeExecution("""
            import datetime
            try:
                datetime.date(0, 10, 10)
            except ValueError as e:
                print(e)
            """)
        
    @expectedFailure
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
            print(datetime.date.fromtimestamp('1'))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(1000000000000))
            """)

        self.assertCodeExecution("""
            import datetime
            print(datetime.date.fromtimestamp(-1000000000000))
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

    @expectedFailure
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
            a.year = 2000
        """)
        self.assertCodeExecution("""
            import datetime
            a = datetime.date(2018, 12, 10)
            a.month = 10
        """)
        self.assertCodeExecution("""
            import datetime
            a = datetime.date(2018, 12, 10)
            a.day = 20
        """)