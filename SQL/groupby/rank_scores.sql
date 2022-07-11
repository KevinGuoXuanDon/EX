# 编写 SQL 查询对分数进行排序。排名按以下规则计算:
#
# 分数应按从高到低排列。
# 如果两个分数相等，那么两个分数的排名应该相同。
# 在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字。
# 按score降序返回结果表。
# 输入:
# Scores 表:
# +----+-------+
# | id | score |
# +----+-------+
# | 1  | 3.50  |
# | 2  | 3.65  |
# | 3  | 4.00  |
# | 4  | 3.85  |
# | 5  | 4.00  |
# | 6  | 3.65  |
# +----+-------+
# 输出:
# +-------+------+
# | score | rank |
# +-------+------+
# | 4.00  | 1    |
# | 4.00  | 1    |
# | 3.85  | 2    |
# | 3.65  | 3    |
# | 3.65  | 3    |
# | 3.50  | 4    |
# +-------+------+

# 调用内部函数300ms
Select score, dense_rank() over (order by score desc) as 'rank'
from Score;

# 自链接, 需要用分组对每个数据都进行排名，否则只会有一条数据
Select s1.score, count(distinct(s2.score)) as 'rank'
from Scores as s1, Scores as s2
where s1.salary<=s2
group by s1.id
order by s1.salary desc;

