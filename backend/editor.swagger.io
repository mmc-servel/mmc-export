openapi: 3.0.0
info:
  version: 1.0.0
  title: Student API
  description: This is swaggerspec of the Progent API, The first call must be the /login in order to obtain the "sessionid" all subsequent calls must contain "username" and "sessionid".
  contact: 
    name: Sergiu Velescu
    url: https://hello.com
    email: qwe@qwe.md
servers:
  - url: http:192.168.0.101:8000
    description: First server
  - url: http://zxc.com
    description: Second server  
paths:
  /api/login:
    post:
      description: Authenticate user/pass and return SessionID    
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/loginrequest'
      responses:
        200:
          description: success call
          content:
            application/json:
              schema:
                oneOf:
                  - $ref: '#/components/schemas/loginSuccessResp'
                  - $ref: '#/components/schemas/failedRequest'
                
components:
  schemas:
    loginSuccessResp:          
      description: Succesfull authentication
      properties:
        responce:
          type: string
          example: OK
        message:
          type: string
          example: Login Success     
        data:
          type: object
          properties:
            sessionid:
              type: string
    failedRequest:          
      description: Request failed (whatever the reason is).
      properties:
        responce:
          type: string
          example: FAILED
        message:
          type: string
          example: Error root cause (or generic error).
    loginrequest:
      type: object
      properties:
        username:
          type: string
          example: qwe@asd.com
        password:
          type: string
          example: secret
  parameters:
    requestUsername:
      in: query
      name: username
      required: true
      schema:
        type: string
        example: qwe@asd.com
      description: Username  
    requestSessionid:
      in: query
      name: sessionid
      required: true
      schema:
        type: string
        example: qwe123asdzxc
      description: SessionID 