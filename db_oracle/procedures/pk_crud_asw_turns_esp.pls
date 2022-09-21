create or replace PACKAGE pk_crud_asw_turns IS

TYPE ty_t_asw_turns IS TABLE OF asw_turns%ROWTYPE INDEX BY BINARY_INTEGER;

FUNCTION fu_id_last_register RETURN NUMBER;
    
END pk_crud_asw_turns;