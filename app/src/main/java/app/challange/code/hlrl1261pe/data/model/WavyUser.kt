package app.challange.code.hlrl1261pe.data.model

import com.google.gson.annotations.SerializedName

data class WavyUser(
    @SerializedName("id") var id: String,
    @SerializedName("firstName") var firstName: String,
    @SerializedName("lastName") var lastName: String,
    @SerializedName("phoneNumber") var phoneNumber: String,
    @SerializedName("email") var email: String,
    @SerializedName("profilePicture") var profilePicture: String
)
