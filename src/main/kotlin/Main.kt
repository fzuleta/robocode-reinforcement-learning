import org.apache.commons.io.FileUtils
import robocode.control.BattleSpecification
import robocode.control.BattlefieldSpecification
import robocode.control.RobocodeEngine
import java.io.File

val LOCAL_FOLDER_LOCATION = FileUtils.getFile("").absolutePath

fun main(args: Array<String>) {
    println(LOCAL_FOLDER_LOCATION)
    val engine = RobocodeEngine(File(""))
    val battlefield = BattlefieldSpecification(1000, 1000)
    val selectedBots = engine.getLocalRepository("robots.R_1*,sample.Walls")
    val battleSpec = BattleSpecification(5, battlefield, selectedBots)

    engine.setVisible(true)
    engine.runBattle(battleSpec, true)

}
