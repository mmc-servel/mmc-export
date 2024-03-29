CREATE OR REPLACE PACKAGE app_security AS
/*
RETURNS:
in case of success -> SESSIONID=xxxxxxxxxxxxxxxxxxxx
in case of errors  -> ERRORMSG=xxxxxxxxxxxxxxxxxxxxx
*/
    FUNCTION getsessionid(p_username varchar2,p_password varchar2) RETURN VARCHAR2;
END;
/
