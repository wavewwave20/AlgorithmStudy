SELECT COUNT(*) COUNT
FROM ECOLI_DATA
WHERE 
    (genotype & 2) = 0 
    AND 
    ((genotype & 1) = 1 OR (genotype & 4) = 4); 

