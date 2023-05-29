package com.example.promotion.redis.lock;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import jakarta.websocket.OnError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDistributionLock implements Lock, Closeable{
    
    protected final AtomicBoolean isLock = new AtomicBoolean(false);

    // lock polling time interval
    protected long intervalTime = 10L;

    // lock survial time (ms)
    protected long survivalMillis = 600000L;

    @Override
    public void lock(){
        while(survivalMillis > 0){
            try{
                if(tryLock()){
                    return;
                }
                Thread.sleep(intervalTime);
                survivalMillis -= intervalTime;
            } 
            catch (InterruptedException e){
                log.error("lock thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException{
        lock();
    } 

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit){
        this.survivalMillis = TimeUnit.MILLISECONDS.convert(time, unit);
        try{
            if(tryLock()){
                return true;
            }
            Thread.sleep(this.intervalTime);
            survivalMillis -= intervalTime;
        } catch (InterruptedException e){
            log.error("lock thread interrupted");
            Thread.currentThread().interrupt();
        }
        return false;
    }

    @Override
    public void unlock(){

    }

    @Override
    public Condition newCondition(){
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws IOException {
        if(this.isLock.get()){
            unlock();
        }
    }

}
