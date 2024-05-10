SELECT ID, 
CASE
    WHEN CHILD_COUNT IS NULL THEN 0
    ELSE CHILD_COUNT
END CHILD_COUNT
FROM ECOLI_DATA A LEFT JOIN (
    SELECT PARENT_ID, COUNT(*) AS CHILD_COUNT
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NOT NULL
    GROUP BY PARENT_ID
) B ON A.ID = B.PARENT_ID
ORDER BY ID;