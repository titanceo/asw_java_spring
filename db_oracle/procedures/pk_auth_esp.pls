create or replace PACKAGE pk_auth IS
    
    PROCEDURE pr_login(user VARCHAR2, pasword VARCHAR2);

    
END pk_crud_asw_turns;