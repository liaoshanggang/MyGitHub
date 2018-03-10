select * from employees

create table copy_emp as select * from employees

SELECT COUNT(*) FROM copy_emp

insert into copy_emp select * from copy_emp;
commit;
SELECT COUNT(*) FROM copy_emp
