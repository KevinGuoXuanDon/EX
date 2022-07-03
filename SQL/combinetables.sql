-- 编写一个SQL查询来报告 Person 表中每个人的姓、名、城市和州。如果 personId 的地址不在Address表中，则报告为空 null。
-- 以 任意顺序 返回结果表。
-- 查询结果格式如下所示。
-- 示例 1:
--
-- 输入:
-- Person表:
-- +----------+----------+-----------+
-- | personId | lastName | firstName |
-- +----------+----------+-----------+
-- | 1        | Wang     | Allen     |
-- | 2        | Alice    | Bob       |
-- +----------+----------+-----------+
-- Address表:
-- +-----------+----------+---------------+------------+
-- | addressId | personId | city          | state      |
-- +-----------+----------+---------------+------------+
-- | 1         | 2        | New York City | New York   |
-- | 2         | 3        | Leetcode      | California |
-- +-----------+----------+---------------+------------+
-- 输出:
-- +-----------+----------+---------------+----------+
-- | firstName | lastName | city          | state    |
-- +-----------+----------+---------------+----------+
-- | Allen     | Wang     | Null          | Null     |
-- | Bob       | Alice    | New York City | New York |
-- +-----------+----------+---------------+----------+
-- 解释:
-- 地址表中没有 personId = 1 的地址，所以它们的城市和州返回 null。
-- addressId = 1 包含了 personId = 2 的地址信息。

-- 左链接
select p.firstName,p.lastName,a.city,a.state
from Person as p left join Address as a on p.personId = a.personId;