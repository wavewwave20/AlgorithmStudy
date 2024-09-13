-- 코드를 입력하세요
SELECT mcdp_cd '진료과코드', count(*) '5월예약건수'
from appointment
where year(APNT_YMD) = 2022 and month(APNT_YMD) = 5
group by mcdp_cd
order by 2,1