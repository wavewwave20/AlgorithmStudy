-- 코드를 입력하세요
SELECT HISTORY_ID,
    CAR_ID,
    date_format(START_DATE, '%Y-%m-%d') START_DATE,
    date_format(END_DATE, '%Y-%m-%d') END_DATE,
    if(datediff(end_date , start_date)+1  >= 30, '장기 대여', '단기 대여') RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date) = 2022 and month(start_date) = 9
order by history_id desc