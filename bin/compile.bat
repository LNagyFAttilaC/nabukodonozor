@echo off
echo              GRAFIKUS VALTOZAT BEMUTATASA
echo ----------------------------------------------
echo Csapatszam, csapatnev: 13, nabukodonozor
echo ----------------------------------------------
echo Csapattagok: Enyedi Peter Attila, Gurzo Lajos, 
echo              Nagy Attila, Savci Tamas
echo ----------------------------------------------
echo Bemutatas kezdete: %DATE%, %TIME%
echo ----------------------------------------------
pause
set PATH=%PATH%;[IDE IRJA A JAVA MAPPAJAT!]
echo Forditas folyamatban, kis turelmet...
javac nabukodonozor\*.java
echo A forditas megtortent. Inditsa el a run.bat fajlt!
pause
exit