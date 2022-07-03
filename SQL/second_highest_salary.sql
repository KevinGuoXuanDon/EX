-- 编写一个 SQL 查询，获取并返回 Employee表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null 。
--
-- 查询结果如下例所示。
--
-- 示例 1：
--
-- 输入：
-- Employee 表：
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 输出：
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+

-- 最外层保证空值,内层要加distinct否则可能会有多个结果
select(
select distinct salary as SecondHighestSalary
from Employee
order by salary desc
limit 1,1
-- 表示从index为1开始取，取1个
)