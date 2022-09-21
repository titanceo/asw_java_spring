create or replace PACKAGE pk_crud_asw_services IS

PROCEDURE pr_find_asw_services(id         IN  asw_services.id%TYPE,
                               r_asw_ser  OUT asw_services%ROWTYPE);
                       

END pk_crud_asw_services;