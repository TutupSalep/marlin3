package com.rakasettya.marlin3.data.model.signup

import com.google.gson.annotations.SerializedName

data class Success(

	@field:SerializedName("token")
	val token: String? = null
)