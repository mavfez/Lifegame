
#-Xlint:unchecked se adiciona esto para ver las advertencias

javac -cp .;libs/junit-4.12.jar -sourcepath src -d dist test/com/tsi/lifegame/core/*.java  1>>log/log.txt 2>&1
java -cp .;libs/junit-4.12.jar;.;libs/hamcrest-core-1.3.jar;.;dist;**/*.class org.junit.runner.JUnitCore com.tsi.lifegame.core.UniverseTest com.tsi.lifegame.core.CellTest 1>>log/log.txt 2>&1