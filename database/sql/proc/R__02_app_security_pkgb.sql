CREATE OR REPLACE PACKAGE BODY app_security AS
    FUNCTION getsessionid(p_username varchar2,p_password varchar2) RETURN VARCHAR2 AS
        /*
        RETURNS:
        in case of success -> SESSIONID=xxxxxxxxxxxxxxxxxxxx
        in case of errors  -> ERRORMSG=xxxxxxxxxxxxxxxxxxxxx
        */
        v_sessionid varchar2(32):=null;
    BEGIN
        --RETURN QUERY  SELECT row_to_json(a) FROM (SELECT username, password FROM sec_accounts) a;
        select 'randomstringxxyyy123' into v_sessionid from accounts a where a.username=p_username and a.password=p_password;
        return 'SESSIONID='||v_sessionid;
    EXCEPTION WHEN NO_DATA_FOUND THEN 
        return 'ERRORMSG=Invalid user/password';
    END;
END;
/
