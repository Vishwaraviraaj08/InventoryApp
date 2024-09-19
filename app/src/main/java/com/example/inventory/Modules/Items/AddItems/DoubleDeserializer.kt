package com.example.inventory.Modules.Items.AddItems

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class DoubleDeserializer : JsonDeserializer<Double> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): Double {
        return if (json.asString.isEmpty()) {
            0.0
        } else {
            try {
                json.asDouble
            } catch (e: NumberFormatException) {
                0.0
            }
        }
    }
}
