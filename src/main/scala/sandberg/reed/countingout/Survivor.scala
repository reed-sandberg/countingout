package sandberg.reed.countingout

/**
  * Application accepts two required arguments: n k
  * Where n is the number of members of the group and k is the step amount.
  *
  * https://en.wikipedia.org/wiki/Josephus_problem
  */
object Survivor extends App {
  if ((args.length == 1 && (args(0) == "-h" || args(0) == "--help")) || args.length < 2)
    usage

  val (n, k) = try {
    (args(0).toLong, args(1).toLong)
  } catch {
    case _: NumberFormatException => usage
  }

  val survivorAt = try {
    survivorPos(n, k)
  } catch {
    case _: IllegalArgumentException => usage
  }

  println(s"Survivor position for n=$n, k=$k: ${survivorAt.toString}")


  /**
    * Determine the survivor position (0-based numbering) where n is the number of people on the edge of a circle
    * (group) and k is the step amount after which that member of the circle is
    * eliminated. The step count starts with the member of the group at the 0 position.
    * For example if n=10 and k=2, counting starts with member 0 so the first member to be eliminated is at position 1
    * and the survivor will be at position 4.
    *
    * @throws IllegalArgumentException if n and k are not positive integers greater than 0
    */
  def survivorPos(n: Long, k: Long): Long = {
    if (n < 1 || k < 1)
      throw new IllegalArgumentException("n and k must be positive integers > 0.")
    var prevPos = 0L
    var groupSize = 2L
    while (groupSize <= n) {
      prevPos = (prevPos + k) % groupSize
      groupSize += 1L
    }
    prevPos
  }

  /** Print usage information and exit. */
  def usage = {
    println("Usage: sbt \"run n k\"\nRequired parameters: n k, where n and k are positive integers greater than 0.")
    sys.exit(1)
  }
}
