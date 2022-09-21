create or replace PACKAGE body pk_crud_asw_services IS

    PROCEDURE pr_find_asw_services(id         IN  asw_services.id%TYPE,
                                   r_asw_ser  OUT asw_services%ROWTYPE) IS
    
    CURSOR c_asw_ser( p_id      asw_services.id%TYPE) IS 
         SELECT    *
         FROM      asw_services
         WHERE     id = p_id;
         
    BEGIN
        FOR r_c_asw_ser IN c_asw_ser( id ) LOOP
            r_asw_ser  := r_c_asw_ser;
        END LOOP;
    EXCEPTION
      WHEN OTHERS THEN
           RAISE_APPLICATION_ERROR( -20000, 'pr_find_asw_services'||SQLERRM);
    END pr_find_asw_services;                       

END pk_crud_asw_services;