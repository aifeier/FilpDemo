package com.ai.cwf.filpdemo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.MemoryFile;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created at 陈 on 2017/2/5.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class ImageFragment extends Fragment {
    public static ImageFragment NewImageFragment(int position) {
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    private int position = -1;
    private int[] images = {R.mipmap.three, R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.one};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        position = getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(images[position % images.length]);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SuUtil.kill("com.tianque.ecommunity");
                ActivityManager manager = (ActivityManager) getActivity().getSystemService(ACTIVITY_SERVICE);
                manager.restartPackage("com.tianque.ecommunity");
            }
        });
        JSON.parse("",new Feature[]{});
        return view;
    }
}
