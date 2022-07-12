# 编写一个 SQL 查询来修复名字，使得只有第一个字符是大写的，其余都是小写的。
#
# 返回按 user_id 排序的结果表。
#
# 查询结果格式示例如下。
#
#
# 示例 1：
#
# 输入：
# Users table:
# +---------+-------+
# | user_id | name  |
# +---------+-------+
# | 1       | aLice |
# | 2       | bOB   |
# +---------+-------+
# 输出：
# +---------+-------+
# | user_id | name  |
# +---------+-------+
# | 1       | Alice |
# | 2       | Bob   |
# +---------+-------+

select user_id, concat(upper(left(name,1)),lower(substr(name,2))) as name
from users
order by user_id;

