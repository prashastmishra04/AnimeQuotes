import com.google.gson.annotations.SerializedName



data class Json4Kotlin_Base (
	@SerializedName("anime") val anime : String,
	@SerializedName("character") val character : String,
	@SerializedName("quote") val quote : String
)