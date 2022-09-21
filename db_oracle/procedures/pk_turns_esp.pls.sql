create or replace PACKAGE pk_turns IS

PROCEDURE pr_create_turns(id         asw_services.id%TYPE,
                         date_start DATE,
                         date_end   DATE
                         );
                       

END pk_turns;