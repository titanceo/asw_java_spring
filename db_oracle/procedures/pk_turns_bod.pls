create or replace PACKAGE body pk_turns IS
    
    PROCEDURE pr_create_turns_time(date_start DATE, r_asw_service asw_services%ROWTYPE ) IS
    
        
        t_turns        pk_crud_asw_turns.ty_t_asw_turns;
        id_regis       asw_turns.id%TYPE; 
        last INTEGER;
        time_open DATE;
        time_end  DATE;
        time_start DATE;
        date_flag DATE;
    
    
    BEGIN    

        pr_insert_bas12('date_start='||date_start);
        
        time_open := r_asw_service.time_open;
        time_end  := r_asw_service.time_end;
        
        pr_insert_bas12('time_open='||TO_CHAR(r_asw_service.time_open,'DD/MM/RRRR HH24:MI:SS'));
        pr_insert_bas12('time_end='||tO_CHAR(r_asw_service.time_end,'DD/MM/RRRR HH24:MI:SS'));
        
        id_regis := NVL(pk_crud_asw_turns.fu_id_last_register,0) + 1;
        pr_insert_bas12('date_flag : '|| TO_CHAR(date_flag,'DD/MM/RRRR HH24:MI:SS') );
        
        WHILE time_end  <= r_asw_service.time_end  LOOP
        pr_insert_bas12('ENTRA AL WHILE: ');
            IF t_turns.COUNT = 0 THEN
            pr_insert_bas12('NADA EN LA TABLA: ');
                t_turns(1).id := id_regis;
                t_turns(1).date_turn := date_start;
                t_turns(1).state := 'inactivo';
                t_turns(1).time_start := time_open;
                
                time_end := time_open+(r_asw_service.duration/1440);
                t_turns(1).time_end := time_end;
                
                t_turns(1).id_service := r_asw_service.id;
                
            ELSE
            pr_insert_bas12('ALGO EN LA TABLA: ');
 
                last := t_turns.LAST;
                
                

                pr_insert_bas12('last: '||last);
                time_start := time_end ;
                time_end := time_end + (r_asw_service.duration/1440);
                pr_insert_bas12('time_end: '||to_char(time_end,'DD/MM/RRRR HH24:MI:SS'));
                
                

                t_turns(last+1).date_turn := date_start;
                t_turns(last+1).time_start := time_start;
                t_turns(last+1).time_end := time_end;
                t_turns(last+1).id := id_regis;
                t_turns(last+1).state := 'activo';                
                t_turns(last+1).id_service := r_asw_service.id;
 
                
            END IF;
            

            
            id_regis:=id_regis+1;
            pr_insert_bas12('id_regis: '||id_regis);
            
        
            
        
        END LOOP;
        
        pr_insert_bas12('count: '||t_turns.count);
        
        FOR c_t_turns IN t_turns.FIRST .. t_turns.LAST LOOP
            pr_insert_bas12('***************************');
            pr_insert_bas12('t_turns(1).id: '||t_turns(c_t_turns).id);
            pr_insert_bas12('t_turns(1).date_turn:'||t_turns(c_t_turns).date_turn);
            pr_insert_bas12('t_turns(1).state:'||t_turns(c_t_turns).state);
            pr_insert_bas12('t_turns(1).time_start: '||to_char(t_turns(c_t_turns).time_start,'DD/MM/RRRR HH24:MI:SS'));
            pr_insert_bas12('t_turns(1).time_end: '||to_char(t_turns(c_t_turns).time_end,'DD/MM/RRRR HH24:MI:SS') );
            pr_insert_bas12('t_turns(1).id_service: '||t_turns(c_t_turns).id_service);
            pr_insert_bas12('time_open: '||time_open);
            pk_crud_asw_turns.pr_create(t_turns(c_t_turns));
        END LOOP;
        
        
        
        
    EXCEPTION
      WHEN OTHERS THEN
           RAISE_APPLICATION_ERROR( -20000, 'pr_create_turns_time'||SQLERRM);
    END pr_create_turns_time;
    
    PROCEDURE pr_create_turns(id         asw_services.id%TYPE,
                              date_start DATE,
                              date_end   DATE
                              ) IS
        date_flag      DATE;     
        r_asw_service  asw_services%ROWTYPE;
    BEGIN
        date_flag := date_start;
        pk_crud_asw_services.pr_find_asw_services(id,r_asw_service);
    WHILE date_flag <= date_end LOOP
        pr_create_turns_time(date_flag, r_asw_service);
        date_flag := date_flag +1;
    END LOOP;
    
    COMMIT;
    
    EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
           RAISE_APPLICATION_ERROR( -20000, 'pr_create_turns'||SQLERRM);
    END pr_create_turns;
    
    
    
    

END pk_turns;