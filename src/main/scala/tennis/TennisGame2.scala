package tennis

class TennisGame2(val player1Name: String, val player2Name: String)
    extends TennisGame {

  private val minimumPointsToWin = 4
  private val minimumPointDifference = 2
  private var playerOnePoints = 0
  private var playerTwoPoints = 0

  def calculateScore(): String = {
    if (equalScores) {
      if (playerOnePoints < 3) toScore(playerOnePoints) + "-All"
      else "Deuce"
    } else if (inAdvantageStage) {
      if (hasWinner) "Win for " + leadingPlayer
      else "Advantage " + leadingPlayer
    } else toScore(playerOnePoints) + "-" + toScore(playerTwoPoints)
  }

  private def hasWinner = pointDifference >= minimumPointDifference

  private def pointDifference = Math.abs(playerOnePoints - playerTwoPoints)

  private def inAdvantageStage =
    playerOnePoints >= minimumPointsToWin || playerTwoPoints >= minimumPointsToWin

  private def leadingPlayer =
    if (playerOnePoints > playerTwoPoints) player1Name else player2Name

  private def toScore(points: Int): String = points match {
    case 0 => "Love"
    case 1 => "Fifteen"
    case 2 => "Thirty"
    case 3 => "Forty"
  }

  private def equalScores = playerOnePoints == playerTwoPoints

  def wonPoint(player: String): Unit = {
    if (player == player1Name)
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
