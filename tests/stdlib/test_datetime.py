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

    # @expectedFailure
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

    @expectedFailure
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