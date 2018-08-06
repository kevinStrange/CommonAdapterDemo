package com.huanghongfa.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.huanghongfa.view.ImageViewWrapper;


/**
 * Created by huanghongfa on 2018/8/6.
 */

public class ImageLoaderUtil {
    private ImageLoaderUtil() {
    }

    static ImageLoaderEngine imageLoaderEngine;

    /**
     * 初始化图片加载器(在BaseApplication中初始化)
     *
     * @param context
     */
    public static void initialize(Context context) {
        imageLoaderEngine = new ImageLoaderEngine() {
            @Override
            public void initialize(Context context) {
                ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                        .setDownsampleEnabled(true)
                        .build();
                Fresco.initialize(context, config);
            }

            @Override
            public void loaderImage(String uri, ImageViewWrapper imageViewWrapper) {
                imageViewWrapper.setImageURI(uri);
            }

            @Override
            public void loaderImage(final String uri, final ImageViewWrapper imageViewWrapper, final ImageLoadingListener listener) {
                ControllerListener controllerListener = new BaseControllerListener<CloseableStaticBitmap>() {
                    @Override
                    public void onSubmit(String id, Object callerContext) {
                        listener.onLoadingStarted(uri, imageViewWrapper);
                    }

                    @Override
                    public void onFinalImageSet(String id, CloseableStaticBitmap imageInfo, Animatable animatable) {
                        listener.onLoadingComplete(uri, imageViewWrapper, imageInfo.getUnderlyingBitmap());
                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        listener.onLoadingFailed(uri, imageViewWrapper, throwable);
                    }
                };

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setControllerListener(controllerListener)
                        .setUri(uri)
                        // other setters
                        .build();
                imageViewWrapper.setController(controller);
            } // #END loaderImage

        };

        imageLoaderEngine.initialize(context);
    }

    /**
     * 加载图片
     *
     * @param uri              Image URI (i.e. "http://site.com/image.png", "file:///mnt/sdcard/image.png")
     * @param imageViewWrapper
     */
    public static void loaderImage(String uri, ImageViewWrapper imageViewWrapper) {
        imageLoaderEngine.loaderImage(uri, imageViewWrapper);
    }

    public static void loaderImage(String uri, ImageViewWrapper imageViewWrapper, ImageLoadingListener imageLoadingListener) {
        imageLoaderEngine.loaderImage(uri, imageViewWrapper, imageLoadingListener);
    }

    public static void clearDiskCache() {
        Fresco.getImagePipeline().clearDiskCaches();
    }


    /**
     * 图片加载器
     */
    interface ImageLoaderEngine {

        void initialize(Context context);

        void loaderImage(String uri, ImageViewWrapper imageViewWrapper);

        void loaderImage(String uri, ImageViewWrapper imageViewWrapper, ImageLoadingListener imageLoadingListener);
    }

    public interface ImageLoadingListener {

        void onLoadingStarted(String uri, ImageViewWrapper imageViewWrapper);

        void onLoadingFailed(String uri, ImageViewWrapper imageViewWrapper, Throwable throwable);


        void onLoadingComplete(String uri, ImageViewWrapper imageViewWrapper, Bitmap loadedImage);

    }

    public static class SimpleImageLoadingListener implements ImageLoadingListener {
        @Override
        public void onLoadingStarted(String uri, ImageViewWrapper imageViewWrapper) {
        }

        @Override
        public void onLoadingFailed(String uri, ImageViewWrapper imageViewWrapper, Throwable throwable) {
        }

        @Override
        public void onLoadingComplete(String uri, ImageViewWrapper imageViewWrapper, Bitmap loadedImage) {
        }
    }

}
