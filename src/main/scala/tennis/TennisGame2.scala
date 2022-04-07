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
    } else if (playerOnePoints < minimumPointsToWin && playerTwoPoints < 4) {
      val playerOneResult = pointsAsScore(playerOnePoints)
      val playerTwoResult = pointsAsScore(playerTwoPoints)
      playerOneResult + "-" + playerTwoResult
    } else if (playerOnePoints >= minimumPointsToWin && playerTwoPoints >= 0 && (playerOnePoints - playerTwoPoints) >= minimumPointDifference) {
      "Win for player1"
    } else if (playerOnePoints > playerTwoPoints && playerTwoPoints >= 3) {
      "Advantage player1"
    } else if (playerTwoPoints >= minimumPointsToWin && playerOnePoints >= 0 && (playerTwoPoints - playerOnePoints) >= minimumPointDifference) {
      "Win for player2"
    } else if (playerTwoPoints > playerOnePoints && playerOnePoints >= 3) {
      "Advantage player2"
    } else throw new IllegalStateException("points are inconsistent")
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
