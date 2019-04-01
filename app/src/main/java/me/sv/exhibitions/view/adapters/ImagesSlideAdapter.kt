package me.sv.exhibitions.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import me.sv.exhibitions.R
import me.sv.exhibitions.databinding.ImagePageItemBinding

class ImagesSlideAdapter(private val imagesUrlList: List<String?>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int) : View {
        val inflater = LayoutInflater.from(container.context)
        val page = inflater.inflate(R.layout.image_page_item, container, false)
        val binding: ImagePageItemBinding? = DataBindingUtil.bind(page)
        binding?.imageUrl = imagesUrlList[position]
        container.addView(page)
        return page
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imagesUrlList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (`object` is View) {
            container.removeView(`object`)
        }
    }
}