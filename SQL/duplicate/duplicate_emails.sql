# 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
#
# 示例：
#
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
# 根据以上输入，你的查询应返回以下结果：
#
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+

# 三种解法，执行速度从快到慢

# 400ms
select email
from (
     select count(1) as ct,email from person group by email
) as res
where res.ct>1;

# 400ms
select email
from person
group by email
having count(email)>1;

# 700ms
select distinct p1.email
from person p1, person p2
where p1.id!=p2.id and p1.email=p2.email;