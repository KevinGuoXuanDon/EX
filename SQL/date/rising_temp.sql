# 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
#
# 返回结果 不要求顺序 。
#
# 查询结果格式如下例。
#
#  
#
# 示例 1：
#
# 输入：
# Weather 表：
# +----+------------+-------------+
# | id | recordDate | Temperature |
# +----+------------+-------------+
# | 1  | 2015-01-01 | 10          |
# | 2  | 2015-01-02 | 25          |
# | 3  | 2015-01-03 | 20          |
# | 4  | 2015-01-04 | 30          |
# +----+------------+-------------+
# 输出：
# +----+
# | id |
# +----+
# | 2  |
# | 4  |
# +----+
# 解释：
# 2015-01-02 的温度比前一天高（10 -> 25）
# 2015-01-04 的温度比前一天高（20 -> 30）

# 自链接 477ms
select w1.id
from weather w1 join weather w2
on datediff(w1.recordDate,w2.recordDate)=1
and w1.temperature>w2.temperature;

# 内链接 483ms
select w1.id
from weather w1, weather w2
where datediff(w1.recordDate,w2.recordDate)=1
and w1.temperature > w2.temperature;

#计算相差天数：
select TIMESTAMPDIFF(DAY,'2019-05-20', '2019-05-21'); # 1

#计算相差小时数：
select TIMESTAMPDIFF(HOUR, '2015-03-22 07:00:00', '2015-03-22 18:00:00'); # 11

#计算相差秒数：
select TIMESTAMPDIFF(SECOND, '2015-03-22 07:00:00', '2015-03-22 7:01:01'); # 61

#加一天
select adddate('2015-03-22',interval 1 day )