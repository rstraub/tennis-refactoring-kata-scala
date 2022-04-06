package tennis

class TennisGame1(val player1Name: String, val player2Name: String)
    extends TennisGame {
  private val SCORE_SEPARATOR = "-"
  private val FORTY = "Forty"
  private val THIRTY = "Thirty"
  private val FIFTEEN = "Fifteen"
  private val LOVE = "Love"

  private var playerOneScore: Int = 0
  private var playerTwoScore: Int = 0

  def wonPoint(playerName: String): Unit = {
    if (playerName == "player1")
      playerOneScore += 1
    else
      playerTwoScore += 1
  }

  def calculateScore(): String = {
    if (playerOneScore == playerTwoScore) determineEqualScore
    else if (playerOneScore >= 4 || playerTwoScore >= 4) {
      val minusResult = playerOneScore - playerTwoScore

      if (minusResult == 1) "Advantage player1"
      else if (minusResult == -1) "Advantage player2"
      else if (minusResult >= 2) "Win for player1"
      else "Win for player2"
    } else {
      determinePlayerScore(playerOneScore) + SCORE_SEPARATOR + determinePlayerScore(
        playerTwoScore
      )
    }
  }

  private def determineEqualScore =
    if (playerOneScore >= 3) "Deuce"
    else determinePlayerScore(playerOneScore) + SCORE_SEPARATOR + "All"

  private def determinePlayerScore(playerScore: Int) = playerScore match {
    case 0 => LOVE
    case 1 => FIFTEEN
    case 2 => THIRTY
    case _ => FORTY
  }
}
