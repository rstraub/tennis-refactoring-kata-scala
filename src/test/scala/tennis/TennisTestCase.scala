package tennis

class TennisTestCase(val player1Score: Int,
                     val player2Score: Int,
                     val expectedScore: String) {
  override def toString(): String = {
    player1Score + ":" + player2Score + " = " + expectedScore;
  }
}
