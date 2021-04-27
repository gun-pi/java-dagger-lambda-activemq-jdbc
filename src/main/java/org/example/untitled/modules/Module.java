package org.example.untitled.modules;

import dagger.Provides;
import org.example.untitled.db.DocumentDao;
import org.example.untitled.mq.Mq;

import javax.inject.Singleton;

@dagger.Module
public class Module {

    @Provides
    @Singleton
    Mq providesMq() {
        return new Mq();
    }

    @Provides
    @Singleton
    DocumentDao providesDao() {
        return new DocumentDao();
    }
}
