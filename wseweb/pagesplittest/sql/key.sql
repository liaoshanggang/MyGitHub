SELECT * FROM employees ORDER BY hire_date DESC;
SELECT ROWNUM rn,a.* FROM (SELECT * FROM employees ORDER BY hire_date DESC) a WHERE ROWNUM <=107;
SELECT * FROM (SELECT ROWNUM rn,a.* FROM (SELECT * FROM employees ORDER BY hire_date DESC) a WHERE ROWNUM <=20) WHERE rn>12;