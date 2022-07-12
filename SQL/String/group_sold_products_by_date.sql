# 输入：
# Activities 表：
# +------------+-------------+
# | sell_date  | product     |
# +------------+-------------+
# | 2020-05-30 | Headphone   |
# | 2020-06-01 | Pencil      |
# | 2020-06-02 | Mask        |
# | 2020-05-30 | Basketball  |
# | 2020-06-01 | Bible       |
# | 2020-06-02 | Mask        |
# | 2020-05-30 | T-Shirt     |
# +------------+-------------+
# 输出：
# +------------+----------+------------------------------+
# | sell_date  | num_sold | products                     |
# +------------+----------+------------------------------+
# | 2020-05-30 | 3        | Basketball,Headphone,T-shirt |
# | 2020-06-01 | 2        | Bible,Pencil                 |
# | 2020-06-02 | 1        | Mask                         |
# +------------+----------+------------------------------+
# 编写一个 SQL 查询来查找每个日期、销售的不同产品的数量及其名称。
# 每个日期的销售产品名称应按词典序排列。
# 返回按 sell_date 排序的结果表


select sell_date,
    count(distinct (product)),
    # “不同的”【distinct product】产品按照字典排序【order by product】  & “,”分割【separator ','】
    group_concat(distinct product order by product separator ',') as products
from activities
group by sell_date
order by sell_date;