package robots

import org.deeplearning4j.rl4j.mdp.MDP
import org.deeplearning4j.rl4j.space.DiscreteSpace
import org.deeplearning4j.rl4j.space.Encodable
import org.deeplearning4j.rl4j.space.ObservationSpace

abstract class visrobocode : MDP<GameScreen, Int, DiscreteSpace> {

    var discreteSpace: DiscreteSpace? = null
    var theObservationSpace: ObservationSpace<GameScreen>? = null
}

abstract class GameScreen : Encodable {
    var array = mutableListOf<Double>()


    fun GameScreen(screen: ByteArray) {
        // Todo
    }

    override fun toArray(): DoubleArray = array.toDoubleArray()
}