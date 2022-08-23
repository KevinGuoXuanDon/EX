use sqlLearning;

create table tbl_index (
    a int primary key ,
    b int,
    c int,
    d int,
    e int
);

create index index_test on tbl_index(a,b,c,d,e);

explain select * from tbl_index where a='1' and d ='2'
group by b,c,e;
