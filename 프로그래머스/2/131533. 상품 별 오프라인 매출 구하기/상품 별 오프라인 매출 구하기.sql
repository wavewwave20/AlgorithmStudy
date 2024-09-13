-- 코드를 입력하세요
SELECT p.product_code PRODUCT_CODE, sum(p.price * s.sales_amount)  SALES
from offline_sale s join product p
on p.product_id = s.product_id
group by p.product_code
order by sales desc, p.product_code