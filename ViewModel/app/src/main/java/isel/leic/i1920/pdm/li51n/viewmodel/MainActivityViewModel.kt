package isel.leic.i1920.pdm.li51n.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel





class MainActivityViewModel : ViewModel() {
    private val TAG = MainActivityViewModel::class.java.name
    init {
        Log.i(TAG, " ####### constructor called ########")
    }
    var counter = 0

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, " ####### oncleared called ########")

    }

    fun getNames(cb: (List<String>) -> Unit) {

    }


}