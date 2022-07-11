# 编写一个SQL查询来查找收入比经理高的员工。
#
# 以 任意顺序 返回结果表。
#
# 查询结果格式如下所示。
#
# 示例 1:
#
# 输入:
# Employee 表:
# +----+-------+--------+-----------+
# | id | name  | salary | managerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | Null      |
# | 4  | Max   | 90000  | Null      |
# +----+-------+--------+-----------+
# 输出:
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------+
# 解释: Joe 是唯一挣得比经理多的雇员。

# 两种方法：自链接和子链接：能够自链接有限自链接

# 自链接 427ms
select name as Employee
from Employee as e1, Employee as e2
where e1.managerId = e2.id and e1.salary>e2.salary

# 子链接 939ms

select name as Employee
from Employee as e1
where e1.salary >
      (
          select salary from Employee
          where id = e1.managerId
      )