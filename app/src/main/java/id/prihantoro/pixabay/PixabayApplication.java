package id.prihantoro.pixabay;

import android.app.Application;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EApplication;

import id.prihantoro.pixabay.dagger.component.ApplicationComponent;
import id.prihantoro.pixabay.dagger.component.DaggerApplicationComponent;

/**
 * Created by wahyu on 08 June 2017.
 */

@EApplication
public class PixabayApplication extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
