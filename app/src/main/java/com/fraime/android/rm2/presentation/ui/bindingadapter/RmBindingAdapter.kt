package com.fraime.android.rm2.presentation.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:loadImage")
fun loadImagePicasso(view: ImageView, image: String?) {
    if (image == null) {
        view.setImageURI(null)
    } else {
        Picasso.get()
            .load(image)
            .into(view)
    }
}