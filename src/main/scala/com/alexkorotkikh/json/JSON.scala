package com.alexkorotkikh.json

import com.fasterxml.jackson.databind.JsonNode

/**
 * User: alexkorotkikh
 * Date: 10/7/13
 * Time: 5:54 PM
 */

object JSON {
  def apply(pairs: (String, JsonValue)*): JsonObject = create(pairs: _*)

  def create(pairs: (String, JsonValue)*): JsonObject = JsonObject(pairs: _*)


  def jsonObject(pairs: (String, JsonValue)*) = create(pairs: _*)

  def jsonArray(values: JsonValue*) = arrayToJsonArray(Array(values:_*))

  implicit def intToJsonInt(value: Int) = JsonNumber(value)

  implicit def stringToJsonString(value: String) = JsonString(value)

  implicit def booleanToJsonBoolean(value: Boolean) = JsonBoolean(value)

  implicit def arrayToJsonArray(array: Array[JsonValue]) = JsonArray(array)
}

trait JsonValue {
  val size = 1
}

case class JsonNumber(value: Int) extends JsonValue

case class JsonString(value: String) extends JsonValue

case class JsonBoolean(value: Boolean) extends JsonValue

case class JsonArray(value: Array[JsonValue]) extends JsonValue {
  override val size = value.size
}

case class JsonObject(value: (String, JsonValue)*) extends JsonValue {
  override val size = value.size
}