package com.rakasettya.marlin3.data.sqlite.model.token

import com.google.gson.annotations.SerializedName

class Token {

    var token: String? = null

    constructor() {}

    constructor(token: String) {
        this.token = token
    }

    override fun toString(): String {
        return "Token{" +
                "_partnumber='" + token + '\''.toString() +
                '}'.toString()
    }
}