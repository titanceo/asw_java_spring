create or replace PACKAGE BODY pk_crud_asw_turns IS

    FUNCTION fu_id_last_register RETURN NUMBER IS
    
        id NUMBER(5);
        
        BEGIN
            SELECT MAX(id) INTO id FROM asw_turns;
        RETURN id;
    EXCEPTION
      WHEN OTHERS THEN
           RAISE_APPLICATION_ERROR( -20000, 'Fu_id_last_register'||SQLERRM);
    END fu_id_last_register;
    
END pk_crud_asw_turns;