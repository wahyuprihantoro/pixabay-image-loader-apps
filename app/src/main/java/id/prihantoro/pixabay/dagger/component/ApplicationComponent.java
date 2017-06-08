package id.prihantoro.pixabay.dagger.component;

import dagger.Component;
import id.prihantoro.pixabay.dagger.module.NetworkModule;
import id.prihantoro.pixabay.retrofitservice.PixabayService;

/**
 * Created by wahyu on 08 June 2017.
 */

@Component(modules = NetworkModule.class)
public interface ApplicationComponent {
    PixabayService getService();
}
