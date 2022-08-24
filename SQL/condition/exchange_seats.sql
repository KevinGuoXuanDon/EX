编写SQL查询来交换每两个连续的学生的座位号。如果学生的数量是奇数，则最后一个学生的id不交换。

按 id 升序 返回结果表。

查询结果格式如下所示。

 

示例 1:

输入:
Seat 表:
+----+---------+
| id | student |
+----+---------+
| 1  | Abbot   |
| 2  | Doris   |
| 3  | Emerson |
| 4  | Green   |
| 5  | Jeames  |
+----+---------+
输出:
+----+---------+
| id | student |
+----+---------+
| 1  | Doris   |
| 2  | Abbot   |
| 3  | Green   |
| 4  | Emerson |
| 5  | Jeames  |
+----+---------+

select (
    case
        when mod(id,2) =1 and id = (select count(id) from student) then id
        when mod(id,2) = 1 then id+1
        else id-1
    end
        ) as id, student
from seat
order by id;