package robots

import java.util.*
import java.awt.*

import org.deeplearning4j.rl4j.learning.async.nstep.discrete.AsyncNStepQLearningDiscrete
import org.deeplearning4j.rl4j.learning.async.nstep.discrete.AsyncNStepQLearningDiscreteDense
import org.deeplearning4j.rl4j.learning.sync.qlearning.QLearning
import org.deeplearning4j.rl4j.network.dqn.DQNFactoryStdDense
import org.deeplearning4j.rl4j.space.Box
import org.deeplearning4j.rl4j.util.DataManager
import oracle.jvm.hotspot.jfr.ThreadStates.States
import robocode.*
import robocode.BulletHitEvent
import robocode.BulletHitBulletEvent
import robocode.HitWallEvent
import robocode.HitByBulletEvent
import robocode.BulletMissedEvent
import robocode.BattleEndedEvent
import org.deeplearning4j.rl4j.learning.HistoryProcessor;




fun randInt(min: Int, max: Int): Double = (Random().nextInt(max + 1 - min) + min).toDouble()

object g {
    var roundCountTotal = 0
    var winsCount = 0
}


class R_1 : AdvancedRobot() {
    var reward = 0
    val dataManager = DataManager(true)
    init {
        println("hello hello")
    }
    override fun run() {
        setBodyColor(Color.blue)
        setGunColor(Color.gray)
        setRadarColor(Color.gray)
        setBulletColor(Color.red)
        setScanColor(Color.cyan)

        g.roundCountTotal ++

        isAdjustGunForRobotTurn = true
        isAdjustRadarForGunTurn = true

        while (true) {
            executeAction(5)
        }
    }

    private fun executeAction(action: Int) {
        when (action) {
            0 -> runAwayTop()
            1 -> runAwayBottom()
            2 -> runAwayRight()
            3 -> runAwayLeft()
            4 -> runAway45Right()
            5 -> runAway45Left()
        }
    }

    private fun runAwayTop() {
        val degrees = 180.0
        setTurnRight(degrees)
        waitFor(TurnCompleteCondition(this))
        setAhead(100.0)
        waitFor(MoveCompleteCondition(this))
    }
    private fun runAwayBottom() {
        val degrees = 180.0
        setTurnRight(degrees)
        waitFor(TurnCompleteCondition(this))
        setAhead(100.0)
        waitFor(MoveCompleteCondition(this))
    }
    private fun runAwayRight() {
        val degrees = 90.0
        setTurnRight(degrees)
        waitFor(TurnCompleteCondition(this))
        setAhead(100.0)
        waitFor(MoveCompleteCondition(this))
    }
    private fun runAwayLeft() {
        val degrees = 90.0
        setTurnLeft(degrees)
        waitFor(TurnCompleteCondition(this))
        setAhead(100.0)
        waitFor(MoveCompleteCondition(this))
    }
    private fun runAway45Right() {
        val degrees = 45.0
        setTurnRight(degrees)
        waitFor(TurnCompleteCondition(this))
        setAhead(100.0)
        waitFor(MoveCompleteCondition(this))
    }
    private fun runAway45Left() {
        val degrees = 45.0
        setTurnLeft(degrees)
        waitFor(TurnCompleteCondition(this))
        setAhead(100.0)
        waitFor(MoveCompleteCondition(this))
    }
    override fun onScannedRobot(e: ScannedRobotEvent) {
        // update the state
    }

    override fun onWin(event: WinEvent) {
        reward += 10
        g.winsCount++
    }
    override fun onDeath(event: DeathEvent) {
        reward += -10
    }

    override fun onBulletHit(e: BulletHitEvent) {
        reward += (e.bullet.power * 3).toInt()
    }

    override fun onBulletHitBullet(e: BulletHitBulletEvent) {
        reward += -3
    }

    override fun onBulletMissed(e: BulletMissedEvent) {
        reward += (-e.bullet.power).toInt()
    }

    override fun onHitByBullet(e: HitByBulletEvent) {
        val power = e.bullet.power
        val change = -3 * power

        reward += change.toInt()
    }

    override fun onHitWall(e: HitWallEvent?) {
        reward += -3
    }

    override fun onBattleEnded(e: BattleEndedEvent) {

    }

}
