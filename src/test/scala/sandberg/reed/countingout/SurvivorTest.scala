package sandberg.reed.countingout

import org.scalatest.{Matchers, WordSpec}

import Survivor._

/**
  * Exercise Survivor counting out routines.
  */
class SurvivorTest extends WordSpec with Matchers {
  "survivor position determination" when {
    "invoked with n < 1" should {
      "fail with exception" in {
        an[IllegalArgumentException] should be thrownBy survivorPos(0, 1)
      }
    }
    "invoked with k < 1" should {
      "fail with exception" in {
        an [IllegalArgumentException] should be thrownBy survivorPos(1, -50)
      }
    }
    "yield correct answer with known example" in {
      survivorPos(3L, 2L) shouldBe 2L
    }
    "invoked with n=1" should {
      "always return 0" in {
        val n = 1L
        for (k <- 1L to 10001L)
          survivorPos(n, k) shouldBe 0L
      }
    }
    "invoked with k=1" should {
      "always return the last member of the group" in {
        val k = 1L
        for (n <- 2L to 10001L)
          survivorPos(n, k) shouldBe (n - 1L)
      }
    }
    "invoked with n=k" should {
      "never return the last member of the group" in {
        for (n <- 2L to 10001L)
          survivorPos(n, n) should not be (n - 1L)
      }
    }
    "invoked with k=2 and large n" should {
      "yield 2l where n = 2^m + l" in {
        // In practice, I'd use the calculated value below for all cases of k=2 within survivorPos(...), as an
        // optimization. I'll use only here for the purposes of demonstrating a proof for this example.
        // Proof given here:
        // https://en.wikipedia.org/wiki/Josephus_problem
        val n = 39283442L
        val k = 2L
        val expectedSurvivorPos = 2 * (n - java.lang.Long.highestOneBit(n))
        survivorPos(n, k) shouldBe expectedSurvivorPos
      }
    }
  }
}
