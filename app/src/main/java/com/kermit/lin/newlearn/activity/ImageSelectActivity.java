package com.kermit.lin.newlearn.activity;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.PhotoView;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.base.RxBaseActivity;
import com.kermit.lin.newlearn.utils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ImageSelectActivity extends RxBaseActivity implements View.OnClickListener {

    private static final String TAG = "ImageSelectActivity";


    @BindView(R.id.viewPagerBrowser)
    ViewPager mViewPager;

    @BindView(R.id.tvNumShow)
    TextView mNumShow;

    @BindView(R.id.view_bottom_sheet)
    LinearLayout mBottomSheet;

    @BindView(R.id.tv_click_01)
    TextView mSave;
    @BindView(R.id.tv_click_02)
    TextView mShare;
    @BindView(R.id.tv_click_03)
    TextView mSet;
    @BindView(R.id.tv_click_cancel)
    TextView mCancel;

    @BindView(R.id.view_bottom_bg)
    View mBottomBg;


    private List<String> imageUrls = new ArrayList<>();
    private int currentPosition;
    Animation anim;
    Animation animDown;
    private ImageView currentImageView; //需要保存的图片
    @Override
    public int getLayoutId() {
        return R.layout.activity_image_select;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initData();
        initViewPager();
        mBottomBg.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mSet.setOnClickListener(this);
        mCancel.setOnClickListener(this);
    }

    @Override
    public void initToolBar() {
    }

    private void initData() {
        imageUrls = getIntent().getStringArrayListExtra("imageUrls");
        currentPosition = getIntent().getIntExtra("position",0);
        mNumShow.setText(String.valueOf((currentPosition + 1) + "/" + imageUrls.size()));
        mBottomSheet.setVisibility(View.GONE);

        anim = AnimationUtils.loadAnimation(this,R.anim.anim);
        animDown = AnimationUtils.loadAnimation(this,R.anim.anim_down);
    }

    private void initViewPager() {
        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.setCurrentItem(currentPosition);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNumShow.setText(String.valueOf((position + 1) + "/" + imageUrls.size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_bottom_bg :
                hideBottomBg();
                break;
            case  R.id.tv_click_cancel:
                hideBottomBg();
                break;
            case R.id.tv_click_01:
                saveBitmap();
                hideBottomBg();
                break;
            case R.id.tv_click_02:
                break;
            case R.id.tv_click_03:
                break;
            default:
                break;
        }
    }

    private void saveBitmap() {
        currentImageView.setDrawingCacheEnabled(true);
        final Bitmap bitmap = Bitmap.createBitmap(currentImageView.getDrawingCache());
        currentImageView.setDrawingCacheEnabled(false);
        if (bitmap == null) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean saveBitmap = BitmapUtils.saveBitmapToSD(bitmap,
                        Environment.getExternalStorageDirectory()+"/kermit",System.currentTimeMillis()+".png",true);
                if (saveBitmap){
                    Snackbar.make(findViewById(R.id.browser_root), "图片保存成功", Snackbar.LENGTH_SHORT)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Perform anything for the action selected
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorAccent))
                            .setDuration(4000).show();
                }
            }
        }).start();
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(ImageSelectActivity.this,R.layout.item_image_show,null);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.photoImageView);
            final RelativeLayout rl_bg = (RelativeLayout) view.findViewById(R.id.rl_image_placeholder_bg);
            final ImageView ivFail = (ImageView) view.findViewById(R.id.iv_fail);
            ivFail.setVisibility(View.GONE);

            String imageUrl = imageUrls.get(position);

            Glide.with(ImageSelectActivity.this).load(imageUrl)
                    .listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    ivFail.setVisibility(View.VISIBLE);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    rl_bg.setVisibility(View.GONE);
                    ivFail.setVisibility(View.GONE);
                    return false;
                }
            }).into(photoView);
            currentImageView = photoView;//传递保存的图片
            photoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            photoView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showBottomBg();
                    return false;
                }
            });
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return imageUrls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * 显示底部和背景
     */
    private void showBottomBg() {

        mBottomBg.setVisibility(View.VISIBLE);
        mBottomBg.setAlpha(1);
        mBottomSheet.setVisibility(View.VISIBLE);
        mBottomSheet.setAnimation(anim);
    }

    private void hideBottomBg() {
        mBottomBg.setVisibility(View.GONE);
        mBottomBg.setAlpha(0);
        mBottomSheet.setVisibility(View.GONE);
        mBottomSheet.setAnimation(animDown);
    }


}
