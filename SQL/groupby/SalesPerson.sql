# 编写一个SQL查询，报告没有任何与名为 “RED” 的公司相关的订单的所有销售人员的姓名。
#
# 以 任意顺序 返回结果表。
# 输入：
# SalesPerson 表:
# +----------+------+--------+-----------------+------------+
# | sales_id | name | salary | commission_rate | hire_date  |
# +----------+------+--------+-----------------+------------+
# | 1        | John | 100000 | 6               | 4/1/2006   |
# | 2        | Amy  | 12000  | 5               | 5/1/2010   |
# | 3        | Mark | 65000  | 12              | 12/25/2008 |
# | 4        | Pam  | 25000  | 25              | 1/1/2005   |
# | 5        | Alex | 5000   | 10              | 2/3/2007   |
# +----------+------+--------+-----------------+------------+
# Company 表:
# +--------+--------+----------+
# | com_id | name   | city     |
# +--------+--------+----------+
# | 1      | RED    | Boston   |
# | 2      | ORANGE | New York |
# | 3      | YELLOW | Boston   |
# | 4      | GREEN  | Austin   |
# +--------+--------+----------+
# Orders 表:
# +----------+------------+--------+----------+--------+
# | order_id | order_date | com_id | sales_id | amount |
# +----------+------------+--------+----------+--------+
# | 1        | 1/1/2014   | 3      | 4        | 10000  |
# | 2        | 2/1/2014   | 4      | 5        | 5000   |
# | 3        | 3/1/2014   | 1      | 1        | 50000  |
# | 4        | 4/1/2014   | 1      | 4        | 25000  |
# +----------+------------+--------+----------+--------+
# 输出：
# +------+
# | name |
# +------+
# | Amy  |
# | Mark |
# | Alex |
# +------+

# Write your MySQL query statement below
select name from
    SalesPerson
where sales_id not in
      (
          select o.sales_id
          from orders o inner join company c on  o.com_id = c.com_id
              and c.name = 'Red'
      );
# 两种写法，一种是not in + 左链接

select s.name
from SalesPerson s
         left join orders o on s.sales_id =o.sales_id
         left join company c on o.com_id = c.com_id and c.name = 'RED'
group by s.sales_id
having count(c.name)=0;
# 第二种是left join + group by