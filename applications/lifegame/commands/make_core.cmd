
javac -cp .;libs/junit-4.12.jar -sourcepath src -d dist src/com/tsi/lifegame/core/*.java 1>>log/log.txt 2>&1
java -cp .;libs/junit-4.12.jar;.;libs/hamcrest-core-1.3.jar;.;dist;**/*.class org.junit.runner.JUnitCore 1>>log/log.txt 2>&1
