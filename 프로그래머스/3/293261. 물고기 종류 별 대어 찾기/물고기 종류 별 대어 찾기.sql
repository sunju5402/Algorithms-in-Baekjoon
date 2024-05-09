SELECT B.ID, A.FISH_NAME, A.LENGTH
FROM (
    SELECT F.FISH_TYPE, FISH_NAME, MAX(LENGTH) AS LENGTH
    FROM FISH_INFO F JOIN FISH_NAME_INFO N ON F.FISH_TYPE = N.FISH_TYPE
    GROUP BY FISH_TYPE, FISH_NAME
) A JOIN FISH_INFO B ON A.FISH_TYPE = B.FISH_TYPE
WHERE A.LENGTH = B.LENGTH
ORDER BY ID;