@echo off
REM Prepared by Vinayak-Mahadev (vinayakmahadev.nm@gmail.com)

echo Project path : %cd%
echo Building all module [datagrokr-common, datagrokr-services] - please wait
echo --------------------------------------------------------------------------------------------------
start cmd.exe /c "cd %cd%/ && mvn clean install  && exit"
echo --------------------------------------------------------------------------------------------------
echo [datagrokr-common, datagrokr-services] are builded successfully
echo --------------------------------------------------------------------------------------------------
pause
echo --------------------------------------------------------------------------------------------------
echo All build execution done successfully
echo --------------------------------------------------------------------------------------------------
pause
echo --------------------------------------------------------------------------------------------------
echo Starting application
echo --------------------------------------------------------------------------------------------------

java -classpath %cd%/datagrokr-services/lib -Xms32M -Xmx64M -jar %cd%/datagrokr-services/target/Application.jar

