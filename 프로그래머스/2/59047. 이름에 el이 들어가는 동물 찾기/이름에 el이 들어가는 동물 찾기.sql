-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where animal_type = 'Dog' and (name like('%EL%') or name like('%el%'))
order by name