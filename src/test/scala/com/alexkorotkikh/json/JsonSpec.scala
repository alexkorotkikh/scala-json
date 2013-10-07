package com.alexkorotkikh.json

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import JSON._

/**
 * User: alexkorotkikh
 * Date: 10/7/13
 * Time: 5:44 PM
 */
class JsonSpec extends FlatSpec with ShouldMatchers {

  val exampleJsonObj = jsonObject(
    "number" -> 1,
    "string" -> "Hello",
    "boolean" -> true,
    "array" -> jsonArray(
      1, 2, 3, "four", "five", "six"
    ),
    "object" -> jsonObject(
      "subNumber" -> 5,
      "subString" -> "bye"
    )
  )

  "An example JSON object" should "have size of 5" in {
    exampleJsonObj.size should be(5)
  }
}
