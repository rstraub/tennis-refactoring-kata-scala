package tennis

class TennisGame3(val playerOneName: String, val playerTwoName: String)
    extends TennisGame {
  private var playerTwoScore: Int = 0
  private var playerOneScore: Int = 0

  def calculateScore(): String = {
    var s: String = ""
    if (playerOneScore < 4 && playerTwoScore < 4 && !(playerOneScore + playerTwoScore == 6)) {
      val p = Array("Love", "Fifteen", "Thirty", "Forty")
      s = p(playerOneScore)
      if (playerOneScore == playerTwoScore) s + "-All"
      else s + "-" + p(playerTwoScore)
    } else {
      if (playerOneScore == playerTwoScore) "Deuce"
      else {
        s =
          if (playerOneScore > playerTwoScore) playerOneName else playerTwoName
        if ((playerOneScore - playerTwoScore) * (playerOneScore - playerTwoScore) == 1)
          "Advantage " + s
        else "Win for " + s
      }
    }
  }

  def wonPoint(playerName: String): Unit = {
    if (playerName == playerOneName)
      this.playerOneScore += 1
    else
      this.playerTwoScore += 1

  }

}
