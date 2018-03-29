# lottieapply
Lottie是Airbnb开源的一个支持 Android、iOS 以及 ReactNative，利用json文件的方式快速实现动画效果的库。
这样可以把原来非常难实现的效果通过简单的几行代码就可以实现
Lottie的简单使用
第一步，在build.gradle中加入
compile 'com.airbnb.android:lottie:2.0.0'
第二步 就是lottie的简单使用了

<com.airbnb.lottie.LottieAnimationView
android:id="@+id/lav_home"
android:layout_width="172dp"
android:layout_height="80dp"
android:visibility="visible"
android:layout_marginRight="9dp"
android:layout_marginTop="24dp"
android:layout_marginLeft="24dp"
android:layout_alignParentRight="true"
/>

如果加载的是本地的
如果是UI设计好对应的json放入assets文件下，如果是studio，assets文件夹就放在src的main包下，如果放到res下面，就会报android Studio Error: 前言中不允许有内容这个错，哎，这地方浪费了很长时间
接下来就是
最简单的使用
lav_home.setAnimation("helloword.json");
lav_home.loop(true);
lav_home.playAnimation();


还可以LottieComposition加载，第一种fromAssetFileName
LottieComposition.Factory.fromAssetFileName(mContext, "helloword.json", new OnCompositionLoadedListener() {
@Override
public void onCompositionLoaded(@Nullable LottieComposition composition) {
mLavHome.setComposition(composition);
mLavHome.loop(true);
mLavHome.playAnimation();
}
});
第二种fromFileSync
LottieComposition composition = LottieComposition.Factory.fromFileSync(mContext, "helloword.json");
mLavHome.setComposition(composition);
mLavHome.loop(true);
mLavHome.playAnimation();
第三种fromInputStream，这种可以是放到手机sd卡的
LottieComposition.Factory.fromInputStream(mContext, fis, new OnCompositionLoadedListener() {
@Override
public void onCompositionLoaded(LottieComposition lottieComposition) {
if (null != lottieComposition) {
mLavHome.setComposition(lottieComposition);
mLavHome.loop(true);
mLavHome.playAnimation();
}
}
});
第四种fromJson 直接加载json，这种可以从网上直接下载下来使用

client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {

            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                }

                try {
                    JSONObject json = new JSONObject(response.body().string());
                    LottieComposition.fromJson(getResources(), json, new LottieComposition.OnCompositionLoadedListener() {
                                @Override
                                public void onCompositionLoaded(LottieComposition composition) {
                                     mLavHome.setComposition(composition);
                    mLavHome.loop(true);
                    mLavHome.playAnimation();
                                }
                            });
                } catch (JSONException e) {
                }
            }
        });
