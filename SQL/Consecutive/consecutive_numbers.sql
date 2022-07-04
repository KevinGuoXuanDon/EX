# 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
#
# 返回的结果表中的数据可以按 任意顺序 排列。
#
# 查询结果格式如下面的例子所示：
#
# 示例 1:
#
# 输入：
# Logs 表：
# +----+-----+
# | Id | Num |
# +----+-----+
# | 1  | 1   |
# | 2  | 1   |
# | 3  | 1   |
# | 4  | 2   |
# | 5  | 1   |
# | 6  | 2   |
# | 7  | 2   |
# +----+-----+
# 输出：
# Result 表：
# +-----------------+
# | ConsecutiveNums |
# +-----------------+
# | 1               |
# +-----------------+
# 解释：1 是唯一连续出现至少三次的数字。

# 1. 自链接 (也是我的写法和官方解答)
select distinct Num as ConsectutiveNums
from 'Logs' a, 'Logs' b, 'Logs' c
where a.id = b.id-1
and b.id = c.id-1
and a.Num = b.Num
and b.Num = c.Num;

# 2. 用户变量写法。 好处是摆脱了需要靠id来辨别连续这个束缚,并且CNT的次数可以自己定义/修改
select distinct Num as ConsectutiveNums
from(
    select Num,
           case
                # 如果prev和NUM相等，count加一，如果不相等，就将prev重新赋值为num，然后count重新赋值为1
                when @prev = Num then @count := @count+1
                when (@prev=Num) is not NULL then @count :=1
           end as CNT
           from 'Logs', ( select @prev := null, @count :=null) as t
) as temp
where temp.CNT>=3


# 3.一点巧劲

select distinct Num as ConsectutiveNums
from logs
where (id+1,Num) in (select * from logs)
and (id+2,num) in (select * from logs)