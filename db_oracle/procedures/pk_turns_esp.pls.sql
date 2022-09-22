create or replace PACKAGE pk_turns IS

PROCEDURE pr_create_turns(id         asw_services.id%TYPE,
                              date_start DATE,
                              date_end   DATE,
                              t_turns    OUT    pk_crud_asw_turns.ty_t_asw_turns
                         );
                       

END pk_turns;