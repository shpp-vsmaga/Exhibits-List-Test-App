package me.sv.exhibitions.view.adapters.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}