package tennis

class TennisGame2(val player1Name: String, val player2Name: String)
    extends TennisGame {

  private var playerOnePoints = 0
  private var playerTwoPoints = 0

  def calculateScore(): String = {
    var playerOneResult = ""
    var playerTwoResult = ""
    var score = ""
    if (equalScores) {
      if (playerOnePoints < 3) score = pointsAsScore(playerOnePoints) + "-All"
      else score = "Deuce"
    } else if (playerOnePoints < 4 && playerTwoPoints < 4) {
      playerOneResult = pointsAsScore(playerOnePoints)
      playerTwoResult = pointsAsScore(playerTwoPoints)
      score = playerOneResult + "-" + playerTwoResult
    } else if (playerOnePoints >= 4 && playerTwoPoints >= 0 && (playerOnePoints - playerTwoPoints) >= 2) {
      score = "Win for player1"
    } else if (playerOnePoints > playerTwoPoints && playerTwoPoints >= 3) {
      score = "Advantage player1"
    } else if (playerTwoPoints >= 4 && playerOnePoints >= 0 && (playerTwoPoints - playerOnePoints) >= 2) {
      score = "Win for player2"
    } else if (playerTwoPoints > playerOnePoints && playerOnePoints >= 3) {
      score = "Advantage player2"
    }
    score
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
