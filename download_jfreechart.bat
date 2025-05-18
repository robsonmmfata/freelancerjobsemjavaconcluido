@echo off
echo Baixando JFreeChart e JCommon...

REM Baixar JFreeChart 1.5.3
powershell -Command "Invoke-WebRequest -Uri https://repo1.maven.org/maven2/org/jfree/jfreechart/1.5.3/jfreechart-1.5.3.jar -OutFile jfreechart-1.5.3.jar"

REM Baixar JCommon 1.0.24
powershell -Command "Invoke-WebRequest -Uri https://repo1.maven.org/maven2/org/jfree/jcommon/1.0.24/jcommon-1.0.24.jar -OutFile jcommon-1.0.24.jar"

echo Downloads concluídos.
pause
