package bar.foo.admobbannersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {

    private lateinit var adViewContainer: FrameLayout //ad banner container
    private lateinit var admobmAdView: AdView //ad banner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdMob() //initialize AdMob banner
        loadAdMob() //load AdMob banner
    }

    //region ADMOB

    /**
     * initialize AdMob banner
     */
    private fun initAdMob() {
        adViewContainer = findViewById<FrameLayout>(R.id.ad_view_container) //ad banner container

        MobileAds.initialize(this) {}
        admobmAdView = AdView(this)
        admobmAdView.adUnitId = "<!-- your ad unit id -->"

        admobmAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                adViewContainer.addView(admobmAdView) //put ad banner on container
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }

    /**
     * load AdMob banner
     */
    private fun loadAdMob() {
        var request = AdRequest.Builder().build()
        admobmAdView.adSize = AdSize.BANNER
        admobmAdView.loadAd(request)
    }

    //endregion
}
