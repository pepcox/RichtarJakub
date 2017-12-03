package com.pepcox.richtar.richtarjakub.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.pepcox.richtar.richtarjakub.R
import com.pepcox.richtar.richtarjakub.RichtarJakupApp
import com.pepcox.richtar.richtarjakub.data.Beer
import com.pepcox.richtar.richtarjakub.managers.BeerManager
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_beer_detail.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class BeerDetailActivity: AppCompatActivity() {

    companion object {
        const val BEER_ARG = "beer"
    }

    @Inject
    lateinit var beerManager: BeerManager
    private lateinit var beer: Beer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_beer_detail)

        RichtarJakupApp.beersComponent.inject(this)

        initToolbar()
        startLoadingAnimation()

        beer = intent.extras.getSerializable(BEER_ARG) as Beer
        title = beer.name

        beerManager.getBeerDetail(beer.detail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Picasso.with(this)
                            .load(it.image)
                            .into(beer_image, object: Callback {
                                override fun onSuccess() {
                                    beer_description.text = Html.fromHtml(it.text)
                                    view_switcher.displayedChild = 1
                                    loading_image.clearAnimation()                                }

                                override fun onError() {}
                            })
                },
                {
                            Toast.makeText(ScrollingActivity@this, it.message, Toast.LENGTH_SHORT).show()
                })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun startLoadingAnimation() {
        val myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.loading)
        loading_image.startAnimation(myFadeInAnimation)
    }
}