@echo off
echo              SZKELETON BEMUTATASA
echo ----------------------------------------------
echo Csapatszam, csapatnev: 13, nabukodonozor
echo ----------------------------------------------
echo Csapattagok: Enyedi Peter Attila, Gurzo Lajos, 
echo              Nagy Attila, Savci Tamas
echo ----------------------------------------------
echo Bemutatas kezdete: %DATE%, %TIME%
echo ----------------------------------------------
pause

set PATH=%PATH%;C:\Program Files\Java\JDK 1.7.0 45\bin
javac *.java
java  -classpath . nabukodonozor.Program
pause
exit