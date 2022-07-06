# 输入：
# Employee 表:
# +----+-------+--------+--------------+
# | id | name  | salary | departmentId |
# +----+-------+--------+--------------+
# | 1  | Joe   | 70000  | 1            |
# | 2  | Jim   | 90000  | 1            |
# | 3  | Henry | 80000  | 2            |
# | 4  | Sam   | 60000  | 2            |
# | 5  | Max   | 90000  | 1            |
# +----+-------+--------+--------------+
# Department 表:
# +----+-------+
# | id | name  |
# +----+-------+
# | 1  | IT    |
# | 2  | Sales |
# +----+-------+
# 输出：
# +------------+----------+--------+
# | Department | Employee | Salary |
# +------------+----------+--------+
# | IT         | Jim      | 90000  |
# | Sales      | Henry    | 80000  |
# | IT         | Max      | 90000  |
# +------------+----------+--------+
# 解释：Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高

# 700ms
select d.name Department,e.name Employee, e.salary Salary
from Employee e inner join Department d on e.departmentId = d.id
where
(e.departmentid,Salary) in
    (
    select departmentId, max(salary)
    from employee
    group by department
    )
;

#1200
select d.name Department,e.name Employee,e.salary Salary
from employee e inner join department d on e.departmentId = d.id
    and e.salary >= (select max(salary) from employee where departmentId=d.id)

# 200ms，利用了开窗函数，修改ab.ranking=1可以获得第二高，第三高的
select ab.Department, ab.Employee, ab.salary as Salary
from
    (
    select b.name as Department, a.name as Employee, a.salary,
           dense_rank() over (partition by departmentId order by a.salary desc) as ranking
        from employee  a left join department  b on a.departmentId = b.id
    ) as ab
where ab.ranking=1;