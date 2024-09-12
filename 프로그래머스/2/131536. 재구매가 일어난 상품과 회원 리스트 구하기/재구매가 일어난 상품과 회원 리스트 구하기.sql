-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
from online_sale
group by product_id, user_id
having (count(user_id) > 1)
order by user_id , product_id desc