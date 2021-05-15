package com.adam.movieapp.maps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adam.movieapp.core.ui.MovieAdapter
import com.adam.movieapp.detail.DetailMovieActivity
import com.adam.movieapp.maps.databinding.ActivityFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(favoriteModule)
        supportActionBar?.title = "Favorite Movie"
        getFavorite()
    }

    private fun getFavorite() {
        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        movieViewModel.favoriteMovie.observe(this, { dataTourism ->
            movieAdapter.setData(dataTourism)
            binding.viewEmpty.root.visibility =
                if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvMovieFav) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}