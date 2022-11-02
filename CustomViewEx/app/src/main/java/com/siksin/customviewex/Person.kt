package com.siksin.customviewex

import android.os.Parcel
import android.os.Parcelable

data class Person(val name: String, val age: Int): Parcelable {
    private constructor(p: Parcel): this(
        name = p.readString().toString(),
        age = p.readInt()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<Person> {
            override fun createFromParcel(parcel: Parcel) = Person(parcel)

            override fun newArray(size: Int) = arrayOfNulls<Person>(size)
        }
    }
}