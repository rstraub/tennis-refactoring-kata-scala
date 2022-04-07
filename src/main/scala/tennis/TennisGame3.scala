package tennis

class TennisGame3(val playerOneName: String, val playerTwoName: String)
    extends TennisGame {
  private val playerOne = new Player(playerOneName)
  private val playerTwo = new Player(playerTwoName)
  def calculateScore(): String = {
    var s: String = ""
    if (playerOne.points < 4 && playerTwo.points < 4 && !(playerOne.points + playerTwo.points == 6)) {
      val p = Array("Love", "Fifteen", "Thirty", "Forty")
      s = p(playerOne.points)
      if (playerOne.points == playerTwo.points) s + "-All"
      else s + "-" + p(playerTwo.points)
    } else {
      if (playerOne.points == playerTwo.points) "Deuce"
      else {
        s =
          if (playerOne.points > playerTwo.points) playerOneName
          else playerTwoName
        if ((playerOne.points - playerTwo.points) * (playerOne.points - playerTwo.points) == 1)
          "Advantage " + s
        else "Win for " + s
      }
    }
  }

  def wonPoint(playerName: String): Unit = {
    if (playerName == playerOneName)
      playerOne.wonPoint()
    else
      playerTwo.wonPoint()
  }
}

private class Player(val name: String) {
  private var _points = 0

  def points: Int = _points

  def wonPoint(): Unit = {
    _points += 1
  }
}
