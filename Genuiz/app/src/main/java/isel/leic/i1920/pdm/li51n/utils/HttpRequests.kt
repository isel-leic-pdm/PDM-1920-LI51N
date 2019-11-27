package isel.leic.i1920.pdm.li51n.utils

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import isel.leic.i1920.pdm.li51n.lastfm.dto.SearchDto

class HttpRequests(ctx: Context) {
    val TAG = HttpRequests::class.java.simpleName
    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(ctx)

    val gson = Gson()

    inline fun <reified T> get(url: String, noinline onSuccess: (T) -> Unit, crossinline onError: (AppError) -> Unit) {
        Log.i(TAG, "Request to ${url}")
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                println("onResponse thread is ${Thread.currentThread().id}")
                val params = JsonParseAsyncTask.Params(gson, onSuccess, T::class.java, response)
                JsonParseAsyncTask<T>().execute(params)
            },
            Response.ErrorListener { err -> onError(AppError(err))})
        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }



    class JsonParseAsyncTask<T>: AsyncTask<JsonParseAsyncTask.Params<T>, Unit, T>() {

        data class Params<T>(val gson:Gson, val onSuccess: (T) -> Unit, val javaKlass: Class<T>, val response: String)

        private lateinit var onSuccess: (T) -> Unit

        override fun doInBackground(vararg p: Params<T>): T {
            val params = p[0]
            onSuccess = params.onSuccess
            println("doInBackground thread is ${Thread.currentThread().id}")
            var dto = params.gson.fromJson(params.response, params.javaKlass)
            return dto
        }

        override fun onPostExecute(result: T) {
            println("onPostExecute thread is ${Thread.currentThread().id}")
            onSuccess(result)
        }
    }
}