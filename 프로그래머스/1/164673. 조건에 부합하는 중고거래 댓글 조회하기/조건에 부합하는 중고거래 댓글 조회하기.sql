-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, Date_format(r.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
from USED_GOODS_BOARD b join USED_GOODS_REPLY r
using (board_id)
where year(b.CREATED_DATE) = 2022 and month(b.CREATED_DATE) = 10
order by r.CREATED_DATE, b.TITLE