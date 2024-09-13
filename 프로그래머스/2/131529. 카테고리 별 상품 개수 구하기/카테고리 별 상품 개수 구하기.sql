-- 코드를 입력하세요
SELECT 
    left(product_code, 2) CATEGORY, count(*)
FROM product
group by category
order by product_code