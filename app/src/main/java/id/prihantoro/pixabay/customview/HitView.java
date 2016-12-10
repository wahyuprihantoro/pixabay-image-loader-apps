package id.prihantoro.pixabay.customview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.pixabay.R;
import id.prihantoro.pixabay.model.Hit;

/**
 * Created by wahyu on 10 Desember 2016.
 */

@EViewGroup
public class HitView extends LinearLayout{

    @ViewById
    CardView cv;
    @ViewById
    ImageView image;

    public HitView(Context context) {
        super(context);
    }

    public void bind(Hit hit){
        Glide.with(getContext()).load(hit.getWebformatURL()).into(image);
    }
}
