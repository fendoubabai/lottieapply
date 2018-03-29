package com.example.thinkpad.lottitapply;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView mLavHome;
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initData();
    }

    private void initView() {
        mLavHome = (LottieAnimationView) findViewById(R.id.lav_home);
    }

    private void initData() {
        /**
         * 最简单的使用
         */
        mLavHome.setAnimation("helloworld.json");
        mLavHome.loop(true);
        mLavHome.playAnimation();
        /**
         * 还可以LottieComposition加载，第一种fromAssetFileName
         */
        LottieComposition.Factory.fromAssetFileName(mContext, "helloword.json", new OnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(@Nullable LottieComposition composition) {
                mLavHome.setComposition(composition);
                mLavHome.loop(true);
                mLavHome.playAnimation();
            }
        });
        /**
         * fromFileSync
         */
        LottieComposition composition = LottieComposition.Factory.fromFileSync(mContext, "helloword.json");
        mLavHome.setComposition(composition);
        mLavHome.loop(true);
        mLavHome.playAnimation();
        /**
         * 第三种fromInputStream，这种可以是放到手机sd卡的
         */
//        FileInputStream fis = new FileInputStream();
//        LottieComposition.Factory.fromInputStream(mContext, fis, new OnCompositionLoadedListener() {
//            @Override
//            public void onCompositionLoaded(LottieComposition lottieComposition) {
//                if (null != lottieComposition) {
//                    mLavHome.setComposition(lottieComposition);
//                    mLavHome.loop(true);
//                    mLavHome.playAnimation();
//                }
//            }
//        });
        /**
         * 第四种fromJson 直接加载json，这种可以从网上直接下载下来使用
         */
//        client.newCall(request).enqueue(new Callback() {
//            @Override public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                }
//
//                try {
//                    JSONObject json = new JSONObject(response.body().string());
//                    LottieComposition.fromJson(getResources(), json, new LottieComposition.OnCompositionLoadedListener() {
//                        @Override
//                        public void onCompositionLoaded(LottieComposition composition) {
//                            mLavHome.setComposition(composition);
//                            mLavHome.loop(true);
//                            mLavHome.playAnimation();
//                        }
//                    });
//                } catch (JSONException e) {
//                }
//            }
//        });
    }


}
