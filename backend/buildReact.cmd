cd %1%
set NODE_OPTIONS=--openssl-legacy-provider

rem on powershell env:NODE_OPTIONS = "--openssl-legacy-provider"

rem TO DO
rem The script doesn't run both npm lines - I don't know why - it runs only one yhat is why I commented the 'npm install'
rem npm install
npm run build

