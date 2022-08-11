package bike.rapido.movieapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTextView: TextView = itemView.findViewById(R.id.movie_title)
        private val movieOverviewTextView: TextView = itemView.findViewById(R.id.movie_overview)
        private val posterImageView: ImageView = itemView.findViewById(R.id.poster)

        fun bind(movie: Movie) {
            movieTextView.text = movie.title
            movieOverviewTextView.text = movie.overview
            val imagePoster = "https://image.tmdb.org/t/p/w500/${movie.poster}"
            Log.e("TAG", "URL for image: ${imagePoster}")
            Picasso.with(itemView.context).load(imagePoster).into(posterImageView)
        }
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return movies.size
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}