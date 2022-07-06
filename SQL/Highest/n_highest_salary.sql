# 编写一个SQL查询来报告 Employee 表中第 n 高的工资。如果没有第 n 个最高工资，查询应该报告为 null 。
#
# 查询结果格式如下所示。
#
# 示例 1:
#
# 输入:
# Employee table:
# +----+--------+
# | id | salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# n = 2
# 输出:
# +------------------------+
# | getNthHighestSalary(2) |
# +------------------------+
# | 200                    |
# +------------------------+

create function getNthHighestSalary(N int) returns int
begin
    set N=N-1;
    return (
        select distinct salary
        from employee
        order by salary desc
        limit N,1
        );
end;