-- 코드를 입력하세요
SELECT a.name, a.datetime
from animal_ins a left join animal_outs b on a.animal_id = b.animal_id
where b.datetime is null
order by datetime
limit 3;

SELECT name, datetime
from animal_ins
where animal_id not in (
    select animal_id
    from animal_outs
)
order by datetime
limit 3;