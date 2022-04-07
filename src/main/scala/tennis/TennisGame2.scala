package tennis

class TennisGame2(val player1Name: String, val player2Name: String)
    extends TennisGame {

  private val minimumPointsToWin = 4
  private val minimumPointDifference = 2
  private var playerOnePoints = 0
  private var playerTwoPoints = 0

  def calculateScore(): String = {
    if (equalScores) {
      if (playerOnePoints < 3) pointsAsScore(playerOnePoints) + "-All"
      else "Deuce"
    } else if (playerOnePoints < minimumPointsToWin && playerTwoPoints < minimumPointsToWin) {
      val playerOneResult = pointsAsScore(playerOnePoints)
      val playerTwoResult = pointsAsScore(playerTwoPoints)
      playerOneResult + "-" + playerTwoResult
    } else {
      if (playerOnePoints > playerTwoPoints) {
        val diff = playerOnePoints - playerTwoPoints
        if (diff >= minimumPointDifference) "Win for player1"
        else "Advantage player1"
      } else {
        val diff = playerTwoPoints - playerOnePoints
        if (diff >= minimumPointDifference) "Win for player2"
        else "Advantage player2"
      }
    }
  }

  private def pointsAsScore(points: Int): String = points match {
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
