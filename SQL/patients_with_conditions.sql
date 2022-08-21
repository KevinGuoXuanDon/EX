写一条SQL 语句，
查询患有 I 类糖尿病的患者ID （patient_id）、患者姓名（patient_name）
以及其患有的所有疾病代码（conditions）。I 类糖尿病的代码总是包含前缀DIAB1。
输入：
Patients表：
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 1          | Daniel       | YFEV COUGH   |
| 2          | Alice        |              |
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |
| 5          | Alain        | DIAB201      |
+------------+--------------+--------------+
输出：
+------------+--------------+--------------+
| patient_id | patient_name | conditions   |
+------------+--------------+--------------+
| 3          | Bob          | DIAB100 MYOP |
| 4          | George       | ACNE DIAB100 |
+------------+--------------+--------------+
解释：Bob 和 George 都患有代码以 DIAB1 开头的疾病。

# Write your MySQL query statement below

select patient_id, patient_name,conditions
from patients
where conditions like '% DIAB1%' or conditions like 'DIAB1%'