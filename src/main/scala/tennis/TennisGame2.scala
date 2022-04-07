package tennis

class TennisGame2(val player1Name: String, val player2Name: String)
    extends TennisGame {

  private val minimumPointsToWin = 4
  private val minimumPointDifference = 2
  private var playerOnePoints = 0
  private var playerTwoPoints = 0

  def calculateScore(): String = {
    if (playerOnePoints >= minimumPointsToWin || playerTwoPoints >= minimumPointsToWin) {
      if (equalScores) "Deuce"
      else {
        val leader =
          if (playerOnePoints > playerTwoPoints) player1Name else player2Name
        val diff = Math.abs(playerOnePoints - playerTwoPoints)
        if (diff >= minimumPointDifference) "Win for " + leader
        else "Advantage " + leader
      }
    } else {
      if (equalScores) {
        if (playerOnePoints < 3)
          toScore(playerOnePoints) + "-All"
        else "Deuce"
      } else toScore(playerOnePoints) + "-" + toScore(playerTwoPoints)
    }
  }

  private def toScore(points: Int): String = points match {
    case 0 => "Love"
    case 1 => "Fifteen"
    case 2 => "Thirty"
    case 3 => "Forty"
  }

  private def equalScores = playerOnePoints == playerTwoPoints

  def wonPoint(player: String): Unit = {
    if (player == "player1")
      addPointForPlayerOne()
    else
      addPointForPlayerTwo()
  }

  private def addPointForPlayerTwo(): Unit = {
    playerTwoPoints += 1
  }

  private def addPointForPlayerOne(): Unit = {
    playerOnePoints += 1
  }
}
