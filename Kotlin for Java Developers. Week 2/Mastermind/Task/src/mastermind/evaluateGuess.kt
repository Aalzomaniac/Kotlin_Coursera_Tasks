package mastermind

import javax.print.attribute.standard.MediaSize

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = secret.zip(guess).count { it.first == it.second }
    val commonLetters = "ABCDEF".sumBy { ch->
        Math.min(secret.count{
            it == ch
        },
        guess.count {
            it == ch
        })

    }
    return Evaluation(rightPosition,commonLetters-rightPosition)
}
fun main(array: Array<String>){
    val result = Evaluation(rightPosition = 1,wrongPosition = 1)
    evaluateGuess("ABCD","ABCD") eq result
    evaluateGuess("ABCD","CDBA") eq result
    evaluateGuess("ABCD","ABDC") eq result
    evaluateGuess("AABC","ADFA") eq result
    evaluateGuess("AABC","DFAA") eq result
}
infix fun <T>T.eq(other:T){
    if (this == other) println("OK") else println("Error: $this != $other")
}