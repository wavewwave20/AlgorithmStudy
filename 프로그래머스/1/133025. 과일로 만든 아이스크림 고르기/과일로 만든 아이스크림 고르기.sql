-- 코드를 입력하세요
SELECT flavor
from first_half join icecream_info
using(flavor)
where ingredient_type = 'fruit_based'
and TOTAL_ORDER > 3000
order by TOTAL_ORDER desc