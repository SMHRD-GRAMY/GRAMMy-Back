select sh.shelf_seq,sh.shelf_name,sh.user_id,st.stock_seq,st.stock_name
from tb_shelf sh,tb_stock st
where sh.shelf_seq=st.shelf_seq
and sh.user_id='1@1'
and sh.shelf_seq = (select shelf_seq from tb_shelf where user_id='1@1' and rownum=1);
;
\


select * from tb_shelf;
select* from tb_stock;

insert into tb_shelf(shelf_seq,shelf_name,user_id) values(tb_shelf_seq.nextval,'창고','1@1');
insert into tb_shelf(shelf_seq,shelf_name,user_id) values(tb_shelf_seq.nextval,'창고2','1@1');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'사과',10,sysdate,'2022-05-14',21,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'배',20,sysdate,'2022-05-14',21,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'과자',30,sysdate,'2022-05-14',21,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'감자',10,sysdate,'2022-05-14',24,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'고구마',20,sysdate,'2022-05-14',24,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'당근',30,sysdate,'2022-05-14',24,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'사과',10,sysdate,'2022-05-14',22,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'배',20,sysdate,'2022-05-14',22,'온라인');
insert into TB_stock(stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,shelf_seq,stock_order)
values(tb_stock_seq.nextval,'과자',30,sysdate,'2022-05-14',22,'온라인');


select * from tb_stock_weight;

insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'11',10,sysdate,'11kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'12',10,sysdate,'12kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'13',10,sysdate,'13kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'14',10,sysdate,'14kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'11',11,sysdate,'11kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'11',12,sysdate,'12kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'11',13,sysdate,'13kg');
insert into tb_stock_weight values (tb_stock_weight_seq.nextval,'11',14,sysdate,'14kg');



select stock_seq,stock_name,stock_weight,stock_date,stock_shelfLife,stock_order,weight_value,weight_date
from (select st.stock_seq,st.stock_name,st.stock_weight,st.stock_date,st.stock_shelfLife,st.stock_order,sw.weight_value,sw.weight_date
from tb_stock st,tb_stock_weight sw
where st.stock_seq=sw.stock_seq
and st.stock_seq=11
order by sw.weight_seq desc)
where rownum<2;

select st.stock_seq,st.stock_name,st.stock_weight,st.stock_date,st.stock_shelfLife,st.stock_order,sw.weight_value,sw.weight_date
from tb_stock st,tb_stock_weight sw
where st.stock_seq=sw.stock_seq
and st.stock_seq=11
order by sw.weight_seq desc;