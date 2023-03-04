package uk.co.digitaljeeves.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import retrofit2.Retrofit
import uk.co.digitaljeeves.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retService: IAlbumService = RetrofitInstance.getRetrofitInstance().create(IAlbumService::class.java)
        val responseLiveData:LiveData<Response<Albums>> = liveData {
            val response = retService.getAlbums()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null){
                while (albumsList.hasNext()){
                    val albumsItem = albumsList.next()
                    val result =
                        " Album title : ${albumsItem.title}\n"+
                        " Album id : ${albumsItem.id}\n"+
                        " user id : ${albumsItem.userId}\n\n\n"
                    Log.i("MyTag", result)
                    binding.tvTitle.append(result)
                }
            }
        })
    }
}