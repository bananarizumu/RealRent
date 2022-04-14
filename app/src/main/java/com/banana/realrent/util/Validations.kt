package com.banana.realrent.util

fun String.isValidNumber(emptyEnabled: Boolean): Boolean {
    if(emptyEnabled && this.isEmpty()) {
        return true
    }
    this.toIntOrNull()?.let {
        return true
    }
    return false
}