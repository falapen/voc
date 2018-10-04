import datetime
for x in [datetime.date(1970, 1, 1), datetime.date(2018, 12, 31), datetime.date(1, 1, 1)]:
    print(x.isocalendar())
