create or replace PACKAGE BODY pk_auth IS
    
    FUNCTION pr_login(user VARCHAR2, password VARCHAR2) RETURN VARCHAR2 IS
    
        resp VARCHAR2(5) DEFAULT 'N';
        
    BEGIN
    
        IF user='asesoftware' AND password = '123456' THEN
            resp := 'Y';
        ELSE
            resp := 'N';
        END IF;
    END;

    
END pk_auth;