select * from tb_user;
delete from tb_user;
select * from TB_PURCHASE;

DROP TABLE tb_user CASCADE CONSTRAINTS;
DROP TABLE tb_shelf CASCADE CONSTRAINTS;
DROP TABLE tb_purchase CASCADE CONSTRAINTS;
DROP TABLE tb_p_reply CASCADE CONSTRAINTS;
DROP TABLE tb_report CASCADE CONSTRAINTS;
DROP TABLE tb_stock CASCADE CONSTRAINTS;
DROP TABLE tb_stock_weight CASCADE CONSTRAINTS;
DROP TABLE tb_reply CASCADE CONSTRAINTS;

drop trigger TB_USER_AI_TRG;

INSERT INTO tb_purchase
    (purchase_seq,
    purchase_title, 
    purchase_content, 
    purchase_date, 
    purchase_cnt, 
    user_id)
VALUES
    (tb_purchase_SEQ.nextval,
    'purchase_title 1', 
    'purchase_content 1', 
    sysdate, 
    1, 
    'user_id 1');
    INSERT INTO tb_purchase
    (purchase_seq,
    purchase_title, 
    purchase_content, 
    purchase_date, 
    purchase_cnt, 
    user_id)
VALUES
    (tb_purchase_SEQ.nextval,
    'purchase_title 2', 
    'purchase_content 2', 
    sysdate, 
    1, 
    'user_id 1');



-- tb_user Table Create SQL
CREATE TABLE tb_user
(
    user_seq         NUMBER(12, 0)    NOT NULL, 
    user_id          VARCHAR2(30)     NOT NULL, 
    user_pw          VARCHAR2(100)     NOT NULL, 
    user_phone       VARCHAR2(30)     NOT NULL, 
    user_addr        VARCHAR2(200)    NOT NULL, 
    user_role        VARCHAR2(30)     NOT NULL, 
    user_joindate    DATE             NOT NULL, 
    user_name        VARCHAR2(30)     NOT NULL, 
    user_gender      VARCHAR2(30)     NOT NULL, 
     PRIMARY KEY (user_seq)
)
/

CREATE SEQUENCE tb_user_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_user_AI_TRG
BEFORE INSERT ON tb_user 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_user_SEQ.NEXTVAL
    INTO :NEW.user_seq
    FROM DUAL;
END;
/


CREATE TABLE tb_shelf
(
    shelf_seq     NUMBER(12, 0)    NOT NULL, 
    shelf_name    VARCHAR2(30)     NOT NULL, 
    user_id       VARCHAR2(30)     NOT NULL, 
     PRIMARY KEY (shelf_seq)
)
/

CREATE SEQUENCE tb_shelf_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_shelf_AI_TRG
BEFORE INSERT ON tb_shelf 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_shelf_SEQ.NEXTVAL
    INTO :NEW.shelf_seq
    FROM DUAL;
END;
/

--DROP TRIGGER tb_shelf_AI_TRG;
/

--DROP SEQUENCE tb_shelf_SEQ;

ALTER TABLE tb_shelf
    ADD CONSTRAINT FK_tb_shelf_user_id_tb_user_us FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
/


-- tb_stock Table Create SQL
CREATE TABLE tb_stock
(
    stock_seq       NUMBER(12, 0)    NOT NULL, 
    hw_uid          VARCHAR2(30)     NOT NULL, 
    stock_name      VARCHAR2(30)     NOT NULL, 
    stock_date      DATE             NOT NULL, 
    stock_weight    NUMBER(12, 1)    NOT NULL, 
    shelf_seq       NUMBER(12, 0)    NOT NULL, 
     PRIMARY KEY (stock_seq)
)
/

CREATE SEQUENCE tb_stock_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_stock_AI_TRG
BEFORE INSERT ON tb_stock 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_stock_SEQ.NEXTVAL
    INTO :NEW.stock_seq
    FROM DUAL;
END;


ALTER TABLE tb_stock
    ADD CONSTRAINT FK_tb_stock_shelf_seq_tb_shelf FOREIGN KEY (shelf_seq)
        REFERENCES tb_shelf (shelf_seq)
/


-- tb_purchase Table Create SQL
CREATE TABLE tb_purchase
(
    purchase_seq        NUMBER(12, 0)      NOT NULL, 
    purchase_title      VARCHAR2(200)      NOT NULL, 
    purchase_content    VARCHAR2(4000)    NOT NULL, 
    purchase_date       DATE               NOT NULL, 
    purchase_cnt        NUMBER(12, 0)      NOT NULL, 
    user_id             VARCHAR2(30)       NOT NULL, 
    user_name           VARCHAR2(30)       NOT NULL, 
     PRIMARY KEY (purchase_seq)
)
/

CREATE SEQUENCE tb_purchase_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_purchase_AI_TRG
BEFORE INSERT ON tb_purchase 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_purchase_SEQ.NEXTVAL
    INTO :NEW.purchase_seq
    FROM DUAL;
END;
/



ALTER TABLE tb_purchase
    ADD CONSTRAINT FK_tb_purchase_user_id_tb_user FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
/


-- tb_report Table Create SQL
CREATE TABLE tb_report
(
    report_seq        NUMBER(12, 0)      NOT NULL, 
    report_title      VARCHAR2(200)      NOT NULL, 
    report_content    VARCHAR2(4000)    NOT NULL, 
    report_date       DATE               NOT NULL, 
    report_status     CHAR(1)            NOT NULL, 
    user_id           VARCHAR2(30)       NOT NULL, 
    report_cnt        NUMBER(12, 0)      NOT NULL, 
    user_name         VARCHAR2(30)       NOT NULL, 
     PRIMARY KEY (report_seq)
)
/

CREATE SEQUENCE tb_report_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_report_AI_TRG
BEFORE INSERT ON tb_report 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_report_SEQ.NEXTVAL
    INTO :NEW.report_seq
    FROM DUAL;
END;
/



ALTER TABLE tb_report
    ADD CONSTRAINT FK_tb_report_user_id_tb_user_u FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
/


-- tb_reply Table Create SQL
CREATE TABLE tb_reply
(
    reply_seq        NUMBER(12, 0)     NOT NULL, 
    report_seq       NUMBER(12, 0)     NOT NULL, 
    reply_content    VARCHAR2(4000)    NOT NULL, 
    reply_date       DATE              NOT NULL, 
    user_id          VARCHAR2(30)      NOT NULL, 
    user_name        VARCHAR2(30)      NOT NULL, 
     PRIMARY KEY (reply_seq)
)
/

CREATE SEQUENCE tb_reply_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_reply_AI_TRG
BEFORE INSERT ON tb_reply 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_reply_SEQ.NEXTVAL
    INTO :NEW.reply_seq
    FROM DUAL;
END;
/



ALTER TABLE tb_reply
    ADD CONSTRAINT FK_tb_reply_report_seq_tb_repo FOREIGN KEY (report_seq)
        REFERENCES tb_report (report_seq)
/

ALTER TABLE tb_reply
    ADD CONSTRAINT FK_tb_reply_user_id_tb_user_us FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
/


-- tb_p_reply Table Create SQL
CREATE TABLE tb_p_reply
(
    pr_seq          NUMBER(12, 0)     NOT NULL, 
    purchase_seq    NUMBER(12, 0)     NOT NULL, 
    pr_content      VARCHAR2(4000)    NOT NULL, 
    pr_date         DATE              NOT NULL, 
    user_id         VARCHAR2(30)      NOT NULL, 
    user_name       VARCHAR2(30)      NOT NULL, 
     PRIMARY KEY (pr_seq)
)
/

CREATE SEQUENCE tb_p_reply_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_p_reply_AI_TRG
BEFORE INSERT ON tb_p_reply 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_p_reply_SEQ.NEXTVAL
    INTO :NEW.pr_seq
    FROM DUAL;
END;
/



ALTER TABLE tb_p_reply
    ADD CONSTRAINT FK_tb_p_reply_purchase_seq_tb_ FOREIGN KEY (purchase_seq)
        REFERENCES tb_purchase (purchase_seq)
/

ALTER TABLE tb_p_reply
    ADD CONSTRAINT FK_tb_p_reply_user_id_tb_user_ FOREIGN KEY (user_id)
        REFERENCES tb_user (user_id)
/


-- tb_stock_weight Table Create SQL
CREATE TABLE tb_stock_weight
(
    weight_seq      NUMBER(12, 0)     NOT NULL, 
    stock_seq       NUMBER(12, 0)     NOT NULL, 
    weight_value    NUMBER(12, 1)     NOT NULL, 
    weight_date     DATE              NOT NULL, 
    weight_memo     VARCHAR2(4000)    NULL, 
     PRIMARY KEY (weight_seq)
)
/

CREATE SEQUENCE tb_stock_weight_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_stock_weight_AI_TRG
BEFORE INSERT ON tb_stock_weight 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_stock_weight_SEQ.NEXTVAL
    INTO :NEW.weight_seq
    FROM DUAL;
END;
/


ALTER TABLE tb_stock_weight
    ADD CONSTRAINT FK_tb_stock_weight_stock_seq_t FOREIGN KEY (stock_seq)
        REFERENCES tb_stock (stock_seq)
/



