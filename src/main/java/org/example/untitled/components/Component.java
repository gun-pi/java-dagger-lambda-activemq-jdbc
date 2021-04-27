package org.example.untitled.components;

import org.example.untitled.Handler;
import org.example.untitled.modules.Module;
import org.example.untitled.db.DocumentDao;
import org.example.untitled.mq.Mq;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = Module.class)
public interface Component {

    void injectInto(Handler handler);

    Mq getMq();

    DocumentDao getDao();
}
