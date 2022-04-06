package tennis

class TennisGame1(val player1Name: String, val player2Name: String)
    extends TennisGame {
  private var playerOneScore: Int = 0
  private var playerTwoScore: Int = 0

  def wonPoint(playerName: String): Unit = {
    if (playerName == "player1")
      playerOneScore += 1
    else
      playerTwoScore += 1
  }

  def calculateScore(): String = {
    var score: String = ""
    if (playerOneScore == playerTwoScore) score = determineEqualScore
    else if (playerOneScore >= 4 || playerTwoScore >= 4) {
      val minusResult = playerOneScore - playerTwoScore
      score =
        if (minusResult == 1) "Advantage player1"
        else if (minusResult == -1) "Advantage player2"
        else if (minusResult >= 2) "Win for player1"
        else "Win for player2"
    } else {
      score = determinePlayerScore(playerOneScore) + "-" + determinePlayerScore(
        playerTwoScore
      )
    }
    score
  }

  private def determineEqualScore = {
    val score = determinePlayerScore(playerOneScore)
    score match {
      case "Forty" => "Deuce"
      case _       => score + "-All"
    }
  }

  private def determinePlayerScore(playerScore: Int) = playerScore match {
    case 0 => "Love"
    case 1 => "Fifteen"
    case 2 => "Thirty"
    case _ => "Forty"
  }
}
