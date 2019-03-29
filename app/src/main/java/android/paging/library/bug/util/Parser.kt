package android.paging.library.bug.util

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken


private val GSON = GsonBuilder()
    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
    .create()

internal inline fun <reified A> typeToken() =
    object : TypeToken<A>() {}.type

internal inline fun <reified A> JsonElement.parseAs(): A =
    GSON.fromJson<A>(this, typeToken<A>())

internal inline fun <reified A> String.parseAs(): A =
    GSON.fromJson<A>(this, typeToken<A>())