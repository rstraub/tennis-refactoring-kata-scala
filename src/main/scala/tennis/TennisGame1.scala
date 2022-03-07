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
    if (playerOneScore == playerTwoScore) {
      score = playerOneScore match {
        case 0 => "Love-All"
        case 1 => "Fifteen-All"
        case 2 => "Thirty-All"
        case _ => "Deuce"

      }
    } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
      val minusResult = playerOneScore - playerTwoScore
      if (minusResult == 1) score = "Advantage player1"
      else if (minusResult == -1) score = "Advantage player2"
      else if (minusResult >= 2) score = "Win for player1"
      else score = "Win for player2"
    } else {
      for (i <- 1 until 3 by 1) {
        var tempScore = 0
        if (i == 1) tempScore = playerOneScore
        else { score += "-"; tempScore = playerTwoScore; }
        val tempScore2 = tempScore match {
          case 0 => "Love"
          case 1 => "Fifteen"
          case 2 => "Thirty"
          case 3 => "Forty"
        }
        score += tempScore2
      }
    }
    score
  }

}
