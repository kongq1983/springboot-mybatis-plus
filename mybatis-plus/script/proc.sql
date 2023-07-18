

drop table if exists tenant_sequence;

create table tenant_sequence (
                                 tenant_id       BIGINT ,  -- 租户id
                                 seq_name        VARCHAR(50) NOT NULL, -- 序列名称
                                 current_val     BIGINT         NOT NULL, -- 当前值

                                 PRIMARY KEY (tenant_id,seq_name)
);

-----------------------------------------------------------------------------------------------

DELIMITER $$

DROP PROCEDURE IF EXISTS tenant_nextval_proc$$
create PROCEDURE tenant_nextval_proc (v_tenant_id BIGINT, v_seq_name VARCHAR(50),OUT v_current_val BIGINT)
-- returns bigint
BEGIN

   declare v_size INT;
  --  declare v_current_val BIGINT DEFAULT 0;
   declare v_current_temp BIGINT DEFAULT 0;


SELECT COUNT(*) INTO v_size  FROM tenant_sequence where tenant_id=v_tenant_id and seq_name = v_seq_name;


IF v_size=0 THEN

SELECT current_val INTO v_current_temp FROM tenant_sequence where tenant_id=0 and seq_name = 'default_seq_name' FOR UPDATE;


SELECT COUNT(*) INTO v_size  FROM tenant_sequence where tenant_id=v_tenant_id and seq_name = v_seq_name;

IF v_size=0 THEN

		INSERT INTO tenant_sequence(tenant_id,seq_name,current_val) VALUES(v_tenant_id,v_seq_name,0);

END if;

END if;


update tenant_sequence set current_val = current_val + 1  where tenant_id=v_tenant_id and seq_name = v_seq_name;

SELECT current_val into v_current_val FROM tenant_sequence where tenant_id=v_tenant_id and seq_name = v_seq_name FOR UPDATE;


COMMIT;


-- RETURN v_current_val;
END $$

DELIMITER ;


-----------------------------------------------------------------------------------------------------------------------------


set @RES=0;

CALL tenant_nextval_proc(0,'num5',@RES) ;

SELECT @RES;