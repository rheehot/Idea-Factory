package kr.juyeop.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesManager {

    private const val PREF_FACTORY_USER = "factory_user"
    private const val PREF_FACTORY_NAME = "factory_name"

    fun getFactoryUser(context: Context) : String?{
        return getDefaultSharedPreferences(context).getString(PREF_FACTORY_USER, null)
    }
    fun setFactoryUser(context: Context, name : String){
        getDefaultSharedPreferences(context).edit().putString(PREF_FACTORY_USER, name).apply()
    }

    fun getFactoryName(context: Context) : String?{
        return getDefaultSharedPreferences(context).getString(PREF_FACTORY_NAME, null)
    }
    fun setFactoryName(context: Context, name : String){
        getDefaultSharedPreferences(context).edit().putString(PREF_FACTORY_NAME, name).apply()
    }

    fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode())
    }
    private fun getDefaultSharedPreferencesName(context: Context): String {
        return context.packageName.toString() + "_preferences"
    }
    private fun getDefaultSharedPreferencesMode(): Int {
        return Context.MODE_PRIVATE
    }
}